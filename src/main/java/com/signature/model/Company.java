package com.signature.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Company implements Serializable {

  private final static long serialVersionUID = 4680200539303849543L;

  private String name;
  private String catchPhrase;
  private String bs;
}