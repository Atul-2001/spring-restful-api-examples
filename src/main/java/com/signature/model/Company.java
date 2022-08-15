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
public class Company implements Serializable {

  private final static long serialVersionUID = 4680200539303849543L;

  private String name;
  private String catchPhrase;
  private String bs;
}