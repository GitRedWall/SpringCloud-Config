package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long>{

    List<Event> findAll();

}
