package com.educative.serverplayground.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ActorBeanPostProcessor implements BeanFactoryPostProcessor {

  private final ActorContext actorContext;

  public ActorBeanPostProcessor(ActorContext actorContext) {
    super();
    this.actorContext = actorContext;
  }

  @Override
  public void postProcessBeanFactory(
      ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    configurableListableBeanFactory.registerScope("actor", new ActorScope(actorContext));
  }
}
