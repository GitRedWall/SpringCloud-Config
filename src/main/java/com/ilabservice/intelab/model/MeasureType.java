package com.ilabservice.intelab.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "measure_type")
public class MeasureType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String code;

    private String unit;

    private String measurement;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "measureTypes")
    private Set<Sensor> sensorSet;

    public MeasureType() {
    }

    public MeasureType(String name, String code, String unit, String measurement, Set<Sensor> sensors) {
        Assert.notNull(name);
        this.name = name;
        this.code = code;
        this.unit = unit;
        this.measurement = measurement;
        this.sensorSet = sensors;
    }

    public MeasureType(String name, String code, String unit, String measurement) {
        this.name = name;
        this.code = code;
        this.unit = unit;
        this.measurement = measurement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public Set<Sensor> getSensorSet() {
        return sensorSet;
    }

    public void setSensorSet(Set<Sensor> sensorSet) {
        this.sensorSet = sensorSet;
    }
}
