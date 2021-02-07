package com.educative.serverplayground.configuration;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberComponent {

  private final Random random = new Random(100);

  public RandomNumberComponent() {
    System.out.println("Instantiating random number bean!");
  }

  @PostConstruct
  public void init() {
    System.out.println("bean being initialized!");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("bean being destroyed!");
  }

  public int getRandomNumber() {
    return random.nextInt();
  }
}
