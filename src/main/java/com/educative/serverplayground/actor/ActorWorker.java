package com.educative.serverplayground.actor;

import com.educative.serverplayground.configuration.ActorScoped;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@ActorScoped
@Component(value = "actor1")
public class ActorWorker {

  @PostConstruct
  private void setUp() {
    System.out.println("Configured");
  }

  public String workerName() {
    return "Actor Worker 1";
  }
}
