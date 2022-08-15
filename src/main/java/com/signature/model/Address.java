package com.signature.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Address implements Serializable {

  private final static long serialVersionUID = -8028653841265977963L;

  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private Geo geo;
}