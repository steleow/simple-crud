package com.stephen.simplecrud.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
  private static final long serialVersionUID = 691229577864418461L;
  private String street;
  private String city;
  private String postcode;
}
