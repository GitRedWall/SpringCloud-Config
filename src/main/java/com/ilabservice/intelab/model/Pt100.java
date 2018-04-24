package com.ilabservice.intelab.model;

import javax.persistence.*;


@Entity
@Table(name = "pt100")
public class Pt100 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String temperature;

    private Double resistance;

    public Pt100() {
    }

    public Pt100(String temperature, Double resistance) {
        this.temperature = temperature;
        this.resistance = resistance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Double getResistance() {
        return resistance;
    }

    public void setResistance(Double resistance) {
        this.resistance = resistance;
    }
}
