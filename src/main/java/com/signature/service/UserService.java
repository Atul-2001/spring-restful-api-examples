package com.signature.service;

import com.signature.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

  User getUserById(int id);

  List<User> getAll(int limit);

  Flux<User> getAll(Mono<Integer> limit);
}
