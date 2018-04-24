package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.EventCondition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventConditionRepository extends CrudRepository<EventCondition, Long>{

    List<EventCondition> findAll();

}
