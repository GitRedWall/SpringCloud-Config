package com.ilabservice.intelab.restful.object;

import com.ilabservice.intelab.model.MeasureType;

public class RestMeasureType {

    private Long id;
    private String name;
    private String code;
    private String unit;

    public RestMeasureType(MeasureType measureType){
        id = measureType.getId();
        name = measureType.getName() != null ? measureType.getName() : "";
        code = measureType.getCode() != null ? measureType.getCode() : "";
        unit = measureType.getUnit() != null ? measureType.getUnit() : "";
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
}
