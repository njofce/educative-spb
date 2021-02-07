package com.educative.serverplayground.controllers;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Scope(value = "request")
public class HomeController {

  @PostConstruct
  public void init() {
    System.out.println("controller initialized");
  }

  @GetMapping("/home")
  public String home() {
    return "Welcome";
  }
}
