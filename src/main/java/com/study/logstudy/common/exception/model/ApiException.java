package com.study.logstudy.common.exception.model;

import com.study.logstudy.common.exception.enums.ApiExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException{
  private HttpStatus httpStatus;
  private String code;
  private String message;

  public static ApiException of(ApiExceptionCode apiExceptionCode) {
    return new ApiException(
            apiExceptionCode.getHttpStatus(),
            apiExceptionCode.getCode(),
            apiExceptionCode.getMessage()
    );
  }
}
