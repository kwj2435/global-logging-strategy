package com.study.logstudy.common.exception.model;

import com.study.logstudy.common.exception.enums.ApiExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class ApiExceptionResponse {
  private String code;
  private String message;

  public static ApiExceptionResponse of(ApiException apiException) {
    return new ApiExceptionResponse(
            apiException.getCode(),
            apiException.getMessage());
  }
}
