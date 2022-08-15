package com.signature.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Geo implements Serializable {

  private final static long serialVersionUID = 4475678912177683483L;

  private String lat;
  private String lng;
}