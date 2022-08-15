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
public class Geo implements Serializable {

  private final static long serialVersionUID = 4475678912177683483L;

  private String lat;
  private String lng;
}