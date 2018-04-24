package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.EventRuleConditionMap;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRuleConditionMapRepository extends CrudRepository<EventRuleConditionMap, Long> {

    List<EventRuleConditionMap> findAll();

}
