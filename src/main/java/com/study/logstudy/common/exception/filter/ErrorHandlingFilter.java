package com.study.logstudy.common.exception.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class ErrorHandlingFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    try {
      filterChain.doFilter(request, response);
    } catch (RuntimeException ex) {
      handleException((HttpServletResponse) response, ex);
    }
  }

  private void handleException(HttpServletResponse response, RuntimeException ex) throws IOException {
    log.error(">>>>> Exception occurred in filter", ex);

    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    response.setContentType("application/json");
    String jsonResponse = """
        {
            "code": "500_10001",
            "message": "서버 내부에서 오류가 발생했습니다."
        }
        """;

    response.getWriter().write(jsonResponse);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
