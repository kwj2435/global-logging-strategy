package com.study.logstudy.common.exception.handler;

import com.study.logstudy.common.exception.enums.ApiExceptionCode;
import com.study.logstudy.common.exception.model.ApiException;
import com.study.logstudy.common.exception.model.ApiExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalApiExceptionHandler {

  @ExceptionHandler(value = ApiException.class)
  public ResponseEntity<ApiExceptionResponse> handleApiException(ApiException apiException) {
    ApiExceptionResponse exceptionResponse = ApiExceptionResponse.of(apiException);

    return ResponseEntity.status(apiException.getHttpStatus().value()).body(exceptionResponse);
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ApiExceptionResponse> handleApiException(Exception exception) {
    log.error(exception.getMessage());

    ApiException apiException = ApiException.of(ApiExceptionCode.API_ERR_500_100001);
    ApiExceptionResponse exceptionResponse = ApiExceptionResponse.of(apiException);

    return ResponseEntity.status(apiException.getHttpStatus().value()).body(exceptionResponse);
  }
}
