package com.signature.service;

import com.signature.model.User;

import java.util.List;

public interface UserService {

  User getUserById(int id);

  List<User> getAll(int limit);
}
