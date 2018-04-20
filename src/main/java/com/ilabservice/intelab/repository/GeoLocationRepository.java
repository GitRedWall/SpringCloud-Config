package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.GeoLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface GeoLocationRepository extends CrudRepository<GeoLocation, Long> {
    GeoLocation findByName(String name);
}
