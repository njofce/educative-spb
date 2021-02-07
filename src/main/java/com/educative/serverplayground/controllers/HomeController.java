package com.educative.serverplayground.controllers;

import com.educative.serverplayground.configuration.RandomNumberComponent;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomeController {

  private final ApplicationContext context;
  private final List<String> stringBeans;
  private final RandomNumberComponent randomNumberComponent;

  public HomeController(
      ApplicationContext context,
      List<String> stringBeans,
      RandomNumberComponent randomNumberComponent) {
    this.context = context;
    this.stringBeans = stringBeans;
    this.randomNumberComponent = randomNumberComponent;
  }

  @GetMapping("/home")
  public String home() {
    return "Welcome";
  }

  @GetMapping("/context")
  public String getContext() {
    return context.getDisplayName();
  }

  @GetMapping("/sample")
  public String getSampleBean() {
    return stringBeans.toString();
  }

  @GetMapping("/random-number")
  public int getRandomNumber() {
    return randomNumberComponent.getRandomNumber();
  }
}
