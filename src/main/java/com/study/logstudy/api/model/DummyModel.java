package com.study.logstudy.api.model;

import com.study.logstudy.api.entity.DummyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DummyModel {

  @Getter
  @AllArgsConstructor
  @Builder
  @NoArgsConstructor
  public static class DummyDto {
    private String parameterString;
    private Long parameterInteger;
    private Float parameterFloat;
    private DummyObject parameterObject;

    public static DummyDto from(DummyEntity dummyEntity) {
      DummyObject dummyObject = new DummyObject();

      return DummyDto.builder()
              .parameterString("test")
              .parameterInteger(dummyEntity.getId())
              .parameterFloat(1.0f)
              .parameterObject(dummyObject)
              .build();
    }
  }

  @Getter
  @AllArgsConstructor
  @Builder
  @NoArgsConstructor
  public static class DummyObject {
    private String paramObjectString;
    private Integer paramObjectInteger;
  }
}
