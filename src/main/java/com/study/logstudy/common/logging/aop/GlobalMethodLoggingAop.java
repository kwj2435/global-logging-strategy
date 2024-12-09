package com.study.logstudy.common.logging.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class GlobalMethodLoggingAop {

  @Before("execution(* com.study..*.*(..))")
  public void logMethodCall(JoinPoint joinPoint) {
    String fullClassName = joinPoint.getSignature().getDeclaringTypeName();
    String className = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
    String methodName = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();

    log.info(">>>> Call Method: {}.{} - Args: {}", className, methodName, args);
  }
}

