package com.signature.service.impl;

import com.signature.model.User;
import com.signature.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

@Slf4j
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

  @Override
  public Flux<User> getAll(Mono<Integer> limit) {
    return limit.flatMapMany((Function<Integer, Publisher<User>>) integer -> WebClient
            .create(API_URL).get().uri(uriBuilder -> uriBuilder.path("/users").queryParam("_limit", integer).build())
            .accept(MediaType.APPLICATION_JSON).exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(User.class)));
  }
}