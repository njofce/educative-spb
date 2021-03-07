package com.educative.serverplayground.web.apis;

import com.educative.serverplayground.utils.JacksonConfiguration;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.AsyncFeign;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

/**
 * The factory of the API that transparently uses Feign to build a declarative API. Both synchronous
 * and asynchronous API calls are supported
 */
public class FileApiFactory {

  /**
   * Get synchronous access to FileAPI
   *
   * @return FileAPI
   */
  public static FileApi getSynchronousFileAPI() {
    String URL = "http://localhost:8080"; // This must be passed as an ENV variable
    return Feign.builder()
        .encoder(new JacksonEncoder(apiObjectMapper()))
        .decoder(new JacksonDecoder(apiObjectMapper()))
        .contract(new SpringMvcContract())
        .target(FileApi.class, URL);
  }

  /**
   * Get asynchronous access to FileAPI
   *
   * @return FileAPI
   */
  public static AsyncFileApi getAsyncFileAPI() {
    String URL = "http://localhost:8080"; // This must be passed as an ENV variable
    return AsyncFeign.asyncBuilder()
        .encoder(new JacksonEncoder(apiObjectMapper()))
        .decoder(new JacksonDecoder(apiObjectMapper()))
        .contract(new SpringMvcContract())
        .target(AsyncFileApi.class, URL);
  }

  private static ObjectMapper apiObjectMapper() {
    Module timeModule = JacksonConfiguration.getTimeModule();
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(timeModule);
    return mapper;
  }
}
