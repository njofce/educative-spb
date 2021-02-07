package com.educative.serverplayground.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public String testBean() {
    return "A simple stupid bean";
  }

  @Bean
  public String anotherTestBean() {
    return "Another simple stupid bean";
  }
}
