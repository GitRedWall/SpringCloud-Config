package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.MonTargetTypeDefaultRule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MonTargetTypeDefaultRuleRepository extends CrudRepository<MonTargetTypeDefaultRule, Long>{

    @Query(value = "SELECT m FROM MonTargetTypeDefaultRule m WHERE m.monTargetType.id=:monTargetTypeId and m.measureType.id=:measureTypeId")
    MonTargetTypeDefaultRule findByMonTargetTypeIdAndMeasureTypeId(@Param("monTargetTypeId")Long monTargetTypeId, @Param("measureTypeId")Long measureTypeId);

}
