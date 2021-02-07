package com.educative.serverplayground.controllers;

import com.educative.serverplayground.configuration.RandomNumberComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("random")
public class RandomNumberController {

  private final RandomNumberComponent randomNumberComponent;

  public RandomNumberController(RandomNumberComponent randomNumberComponent) {
    this.randomNumberComponent = randomNumberComponent;
  }

  @GetMapping("/random-number")
  public int getRandomNumber() {
    return randomNumberComponent.getRandomNumber();
  }
}
