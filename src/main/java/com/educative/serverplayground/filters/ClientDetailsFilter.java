package com.educative.serverplayground.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ua_parser.Client;
import ua_parser.Parser;

@Component
public class ClientDetailsFilter implements Filter {

  private static final Logger logger = LoggerFactory.getLogger(ClientDetailsFilter.class);

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    logger.info("Incoming request: {}", servletRequest.getProtocol());

    save((HttpServletRequest) servletRequest);

    filterChain.doFilter(servletRequest, servletResponse);
  }

  private void save(HttpServletRequest request) {
    String browser = getBrowser(request.getHeader("User-Agent"));
    logger.info("Saving browser to DB: {}", browser);
  }

  private String getBrowser(String agentString) {
    Parser uaParser = new Parser();
    Client client = uaParser.parse(agentString);
    return client.userAgent.family;
  }
}
