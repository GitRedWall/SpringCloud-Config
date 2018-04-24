package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.RentClause;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentClauseRepository extends CrudRepository<RentClause, Long>{

    List<RentClause> findAll();

}
