package com.signature.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

  private final static long serialVersionUID = -8028653841265977963L;

  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private Geo geo;
}