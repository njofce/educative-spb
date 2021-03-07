package com.educative.serverplayground.filters;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class LogRequestFilter implements Filter {

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    if (Arrays.asList("POST", "PUT").contains(httpRequest.getMethod())) {
      CustomHttpRequestWrapper requestWrapper = new CustomHttpRequestWrapper(httpRequest);
      filterChain.doFilter(requestWrapper, servletResponse);
      return;
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
