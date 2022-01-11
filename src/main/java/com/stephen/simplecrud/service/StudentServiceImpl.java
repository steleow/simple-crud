package com.stephen.simplecrud.service;

import com.stephen.simplecrud.model.Student;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
  @Value("${external.service.host}")
  private String host = "";

  @Value("${external.service.timeout}")
  private int timeout = 3;

  private static final String path = "/students";

  private final WebClient webClient = WebClient.create();

  @Override
  public Flux<Student> getAllStudents() {
    return webClient
        .get()
        .uri(host + path)
        .exchangeToFlux(response -> response.bodyToFlux(Student.class))
        .timeout(Duration.ofSeconds(timeout));
  }

  @Override
  public Mono<Student> getStudent(final long id) {
    return webClient
        .get()
        .uri(host + path + "/" + id)
        .exchangeToMono(response -> response.bodyToMono(Student.class))
        .timeout(Duration.ofSeconds(timeout));
  }

  @Override
  public Mono<Student> createStudent(final Student student) {
    return webClient
        .post()
        .uri(host + path)
        .body(Mono.just(student), Student.class)
        .exchangeToMono(response -> response.bodyToMono(Student.class))
        .timeout(Duration.ofSeconds(timeout));
  }

  @Override
  public Mono<Student> updateStudent(final Student student, final long id) {
    var result = getStudent(id);
    return result.flatMap(
        data -> {
          if (data.getId() == null) {
            return createStudent(student);
          } else {
            return webClient
                .put()
                .uri(host + path + "/" + id)
                .body(Mono.just(student), Student.class)
                .exchangeToMono(response -> response.bodyToMono(Student.class))
                .timeout(Duration.ofSeconds(timeout));
          }
        });
  }

  @Override
  public Mono<String> deleteStudent(final long id) {
    return webClient
        .delete()
        .uri(host + path + "/" + id)
        .exchangeToMono(response -> response.bodyToMono(String.class))
        .timeout(Duration.ofSeconds(timeout));
  }
}
