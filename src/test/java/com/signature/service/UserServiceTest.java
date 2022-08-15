package com.signature.service;

import com.signature.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest {

  @Autowired
  public UserService userService;

  @Test
  void getUserById() {
    User user = userService.getUserById(1);

    assertNotNull(user);
    assertEquals(1, user.getId());
  }

  @Test
  void getAll() {
    List<User> users = userService.getAll(4);

    assertNotNull(users);
    assertEquals(4, users.size());
  }
}