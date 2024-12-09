package com.study.logstudy.common.logging.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GlobalReqResLoggingFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, jakarta.servlet.ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    log.info(">>>> Request URI: {}, Request Method: {}, Request Headers: {}, Request Body: {}",
        httpRequest.getRequestURI(), httpRequest.getMethod(),
        httpRequest.getHeaderNames(), getRequestBody(httpRequest)
    );

    chain.doFilter(request, response);

    log.info(">>>> Response Status: {}", httpResponse.getStatus());
  }

  private String getRequestBody(HttpServletRequest request) {
    try {
      BufferedReader reader = request.getReader();
      return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    } catch (IOException e) {
      log.error("Failed to read request body", e);
      return "Error reading request body";
    }
  }
}

