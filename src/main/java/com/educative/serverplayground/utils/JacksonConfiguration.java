package com.educative.serverplayground.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

  private static final LocalDateTimeSerializer CUSTOM_DATE_SERIALIZER =
      new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm"));

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
    return builder -> builder.serializers(CUSTOM_DATE_SERIALIZER);
  }

  /**
   * Register this by annotating it with @Bean, @Primary
   *
   * @return the default Object Mapper
   */
  public ObjectMapper objectMapper() {
    JavaTimeModule timeModule = new JavaTimeModule();
    timeModule.addSerializer(CUSTOM_DATE_SERIALIZER);
    return new ObjectMapper()
        .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setSerializationInclusion(Include.NON_NULL)
        .registerModule(timeModule);
  }
}
