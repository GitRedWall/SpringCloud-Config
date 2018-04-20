package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.MonTargetType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonTargetTypeRepository extends CrudRepository<MonTargetType, Long> {

    List<MonTargetType> findAllByOrderByCreateDateTimeDesc();

}
