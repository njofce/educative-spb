package com.educative.serverplayground;

import com.educative.serverplayground.actor.ActorWorker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomeController {

  private final ActorWorker actorWorker;

  public HomeController(ActorWorker actorWorker) {
    this.actorWorker = actorWorker;
  }

  @GetMapping("/home")
  public String home() {
    return "Welcome";
  }

  @GetMapping("/worker")
  public String actorWorker() {
    return actorWorker.workerName();
  }
}
