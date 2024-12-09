package com.study.logstudy.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ApiExceptionCode {
  API_ERR_400_100001(HttpStatus.BAD_REQUEST, "400_10001", "잘못된 파라미터 입니다."),

  API_ERR_500_100001(HttpStatus.INTERNAL_SERVER_ERROR, "500_10001", "서버 내부에서 오류가 발생했습니다.");

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;
}
