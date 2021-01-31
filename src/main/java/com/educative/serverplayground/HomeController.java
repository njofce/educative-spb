package com.educative.serverplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomeController {

  @GetMapping("/home")
  public String home() {
    return "Welcome";
  }

  @GetMapping("/test")
  public String test() {
    return "Test endpoint";
  }
}
