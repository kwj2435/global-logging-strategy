package com.study.logstudy.api.controller;

import com.study.logstudy.api.model.DummyModel;
import com.study.logstudy.api.service.TrackingService;
import com.study.logstudy.common.exception.enums.ApiExceptionCode;
import com.study.logstudy.common.exception.model.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.InputMismatchException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tracking")
public class TrackingController {

  private final TrackingService trackingService;

  // 메서드 로깅 트래킹 테스트 API
  @GetMapping
  public DummyModel.DummyDto getTracking(
          @RequestParam("dummyString") String dummyString,
          @RequestParam("dummyFloat") Float dummyFloat) {

    return trackingService.getTracking(dummyString, dummyFloat);
  }

  // Exception 테스트 API
  @GetMapping("/exception/400")
  public void getException400() {
    throw ApiException.of(ApiExceptionCode.API_ERR_400_100001);
  }

  // 500 Exception 테스트 API
  @GetMapping("/exception/500")
  public void getException500() throws Exception{
    throw new InputMismatchException();
  }
}
