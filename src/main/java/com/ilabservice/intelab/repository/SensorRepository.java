package com.ilabservice.intelab.repository;

import com.ilabservice.intelab.model.Sensor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorRepository extends CrudRepository<Sensor, Long>{

    @Query("select u from Sensor u where u.ioTDevice.id = ?1")
    public List<Sensor> findByDeviceId(Long deviceId);

}
