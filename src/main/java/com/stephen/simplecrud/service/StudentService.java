package com.stephen.simplecrud.service;

import com.stephen.simplecrud.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
  Flux<Student> getAllStudents();

  Mono<Student> getStudent(long id);

  Mono<Student> createStudent(Student student);

  Mono<Student> updateStudent(Student student, long id);

  Mono<String> deleteStudent(long id);
}
