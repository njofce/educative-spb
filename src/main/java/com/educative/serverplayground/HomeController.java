package com.educative.serverplayground;

import com.educative.serverplayground.configuration.AWSPropertiesConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomeController {

  private final AWSPropertiesConfiguration awsPropertiesConfiguration;

  public HomeController(AWSPropertiesConfiguration awsPropertiesConfiguration) {
    this.awsPropertiesConfiguration = awsPropertiesConfiguration;
  }

  @GetMapping("/home")
  public String home() {
    return "Welcome";
  }

  @GetMapping("/test")
  public String test() {
    return awsPropertiesConfiguration.getBucket();
  }
}
