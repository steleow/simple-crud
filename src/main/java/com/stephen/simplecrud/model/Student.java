package com.stephen.simplecrud.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
  private static final long serialVersionUID = -627257094033837970L;
  private Long id;
  private String name;
  private int age;
  private Address address;
  private String course;
}
