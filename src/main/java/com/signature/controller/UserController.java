package com.signature.controller;

import com.signature.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping({"", "/", "/index", "/index.html"})
  public String index() {
    return "index";
  }

/*  @PostMapping("/users")
  public String getUsers(Model model, @RequestParam(required = false) Integer limit) {
    log.info("Received Limit value: " + limit);

    //default if null or zero
    if (limit == null || limit == 0) {
      log.info("Setting limit to default of 10");
      limit = 10;
    }

    model.addAttribute("users", userService.getAll(limit));

    return "users";
  }*/

  @PostMapping("/users")
  public String getUsers(Model model, ServerWebExchange serverWebExchange) {
    model.addAttribute("users", userService
            .getAll(serverWebExchange.getFormData().map(data -> {
              String value = data.getFirst("limit");

              log.info("Received Limit value: " + value);

              //default if null or zero
              if (value == null || value.isBlank() || value.equals("0")) {
                log.info("Setting limit to default of 10");
                value = "10";
              }
              return Integer.parseInt(value.trim());
            })));

    return "users";
  }
}