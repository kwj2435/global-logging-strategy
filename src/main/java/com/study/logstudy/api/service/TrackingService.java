package com.study.logstudy.api.service;

import com.study.logstudy.api.entity.DummyEntity;
import com.study.logstudy.api.model.DummyModel;
import com.study.logstudy.api.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackingService {

  private final TrackingRepository trackingRepository;

  public DummyModel.DummyDto getTracking(String dummyString, Float dummyFloat) {
    return dummyMethodA(dummyString, dummyFloat);
  }

  private DummyModel.DummyDto dummyMethodA(String dummyString, Float dummyFloat) {
    return dummyMethodB(dummyString, dummyFloat);
  }

  private DummyModel.DummyDto dummyMethodB(String dummyString, Float dummyFloat) {
    return dummyMethodC(dummyString, dummyFloat);
  }

  private DummyModel.DummyDto dummyMethodC(String dummyString, Float dummyFloat) {
    DummyEntity savedDummyEntity =
            trackingRepository.save(DummyEntity.create(dummyString, dummyFloat));

    return DummyModel.DummyDto.from(savedDummyEntity);
  }
}
