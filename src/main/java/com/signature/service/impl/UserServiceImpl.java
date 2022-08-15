package com.signature.service.impl;

import com.signature.model.User;
import com.signature.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final RestTemplate restTemplate;

  public UserServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public User getUserById(int id) {
    return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/{id}", User.class, id);
  }

  @Override
  public List<User> getAll(int limit) {
    return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users?_limit={limit}", List.class, limit);
  }
}