package com.study.logstudy.api.repository;

import com.study.logstudy.api.entity.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends JpaRepository<DummyEntity, Long> {
}
