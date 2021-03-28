package com.educative.serverplayground.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class CustomSchedulingConfig implements SchedulingConfigurer {

  @Override
  public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

    threadPoolTaskScheduler.setPoolSize(2);
    threadPoolTaskScheduler.setThreadNamePrefix("educative-pool-");
    threadPoolTaskScheduler.setBeanName("educative-b");
    threadPoolTaskScheduler.initialize();

    scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
  }
}
