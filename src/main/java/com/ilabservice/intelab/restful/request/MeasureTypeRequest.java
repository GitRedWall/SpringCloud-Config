package com.ilabservice.intelab.restful.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MeasureTypeRequest {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, message = "name should have at least 1 character")
    private String name;

    @NotNull
    @Size(min = 1, message = "code should have at least 1 character")
    private String code;

    @NotNull
    @Size(min = 1, message = "unit should have at least 1 character")
    private String unit;

    @NotNull
    @Size(min = 1, message = "measurement should have at least 1 character")
    private String measurement;

    public MeasureTypeRequest() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
