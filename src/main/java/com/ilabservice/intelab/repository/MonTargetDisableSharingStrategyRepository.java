package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.MonTargetDisableSharingStrategy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonTargetDisableSharingStrategyRepository extends CrudRepository<MonTargetDisableSharingStrategy, Long>{
    List<MonTargetDisableSharingStrategy> findByMonTargetId(long monTargetId);
}
