package com.educative.serverplayground.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
public class ScheduledTasks {

  private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
  private static final DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

  //  @Scheduled(fixedDelay = 2000)
  public void fixedDelayScheduled() {
    logger.info("Scheduled at fixed delay: {}", hourFormatter.format(LocalDateTime.now()));
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      logger.error("Error", e);
    }
  }

  //  @Scheduled(fixedRate = 1000)
  //  @Async
  public void fixedRateScheduled() {
    logger.info("Scheduled at fixed rate: {}", hourFormatter.format(LocalDateTime.now()));
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      logger.error("Error", e);
    }
  }

  @Scheduled(cron = "${cron.rate1}")
  public void cronScheduled() {
    logger.info("Scheduled every 2 minutes: {}", hourFormatter.format(LocalDateTime.now()));
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      logger.error("Error", e);
    }
  }
}
