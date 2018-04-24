package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.Pt100;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Pt100Repository extends CrudRepository<Pt100, Long>{

    @Query(value = "SELECT p FROM Pt100 p WHERE p.resistance=:resistance")
    Pt100 findByResistance(@Param("resistance")Double Resistance);

    @Query(value = "SELECT p FROM Pt100 p WHERE p.resistance <:resistance ORDER BY p.resistance DESC")
    List<Pt100> findByResistanceLessThanOrderByResistanceDESC(@Param("resistance")Double Resistance);

    @Query(value = "SELECT p FROM Pt100 p WHERE p.resistance >:resistance ORDER BY p.resistance ASC")
    List<Pt100> findByResistanceGreaterThanOrderByResistanceAsc(@Param("resistance")Double Resistance);

}
