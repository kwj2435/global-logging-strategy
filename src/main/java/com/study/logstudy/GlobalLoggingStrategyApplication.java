package com.study.logstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class GlobalLoggingStrategyApplication {

  public static void main(String[] args) {
    SpringApplication.run(GlobalLoggingStrategyApplication.class, args);
  }

}
