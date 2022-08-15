package com.signature.service.impl;

import com.signature.model.User;
import com.signature.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final String API_URL;
  private final RestTemplate restTemplate;

  public UserServiceImpl(@Value("${api.url}") String api_url,
                         final RestTemplate restTemplate) {
    this.API_URL = api_url;
    this.restTemplate = restTemplate;
  }

  @Override
  public User getUserById(int id) {
    UriComponents uriComponents = UriComponentsBuilder.fromUriString(API_URL)
            .path("/users/{id}").buildAndExpand(id);
    return restTemplate.getForObject(uriComponents.toUriString(), User.class);
  }

  @Override
  public List<User> getAll(int limit) {
    UriComponents uriComponents = UriComponentsBuilder.fromUriString(API_URL)
            .path("/users").queryParam("_limit", limit).build();
    return restTemplate.getForObject(uriComponents.toUriString(), List.class);
  }
}