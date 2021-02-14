package com.educative.serverplayground.configuration;

import com.educative.serverplayground.actor.Actor;
import com.educative.serverplayground.actor.ActorSample;
import java.util.Map;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActorScopeConfiguration {

  @Bean
  public static BeanFactoryPostProcessor actorScopeFactoryPostProcessor(ActorContext actorContext) {
    return new ActorBeanPostProcessor(actorContext);
  }

  @Bean(name = "actors")
  public static Map<String, Actor> actors() {
    return Map.of(
        "actor1", new ActorSample(),
        "actor2", new ActorSample());
  }

  @Bean
  public static ActorContext actorContext(Map<String, Actor> actors) {
    return new ActorContext(actors);
  }
}
