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
public class User implements Serializable {

  private final static long serialVersionUID = 7434638176685932688L;

  private long id;
  private String name;
  private String email;
  private String phone;
  private String username;
  private String website;
  private Address address;
  private Company company;
}