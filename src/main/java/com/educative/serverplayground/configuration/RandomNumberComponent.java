package com.educative.serverplayground.configuration;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberComponent {

  private final Random random = new Random(100);

  public RandomNumberComponent() {
    System.out.println("Instantiating random number bean!");
  }

  public int getRandomNumber() {
    return random.nextInt();
  }
}
