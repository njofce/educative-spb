package com.educative.serverplayground.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomeController {

  @GetMapping("/home")
  public String home(HttpServletRequest request) {

    return "Hello: Request made from: " + request.getHeader("User-Agent");
  }
}
