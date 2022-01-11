package com.stephen.simplecrud.controller;

import com.stephen.simplecrud.model.Student;
import com.stephen.simplecrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(produces = "application/json")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/students")
  public Flux<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping("/students/{id}")
  public Mono<Student> getStudent(@PathVariable final long id) {
    return studentService.getStudent(id);
  }

  @PostMapping(path = "/students", consumes = "application/json")
  public Mono<Student> createStudent(@RequestBody final Student student) {
    return studentService.createStudent(student);
  }

  @PutMapping(path = "/students/{id}", consumes = "application/json")
  public Mono<Student> updateStudent(
      @RequestBody final Student student, @PathVariable final long id) {
    return studentService.updateStudent(student, id);
  }

  @DeleteMapping("/students/{id}")
  public Mono<String> deleteStudent(@PathVariable final long id) {
    return studentService.deleteStudent(id).thenReturn("OK");
  }
}
