package com.study.logstudy.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dummy")
public class DummyEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "DUMMY_STRING")
  private String dummyString;

  @Column(name = "DUMMY_FLOAT")
  private Float dummyFloat;

  public static DummyEntity create(String dummyString, Float dummyFloat) {
    return new DummyEntity(null, dummyString, dummyFloat);
  }
}
