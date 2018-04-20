package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.MeasureType;
import org.springframework.data.repository.CrudRepository;

public interface MeasureTypeRepository extends CrudRepository<MeasureType, Long>{

    MeasureType findByCode(String code);

}
