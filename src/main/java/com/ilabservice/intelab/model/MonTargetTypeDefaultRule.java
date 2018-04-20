package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mon_target_type_default_rule")
public class MonTargetTypeDefaultRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mon_target_type_id")
    private MonTargetType monTargetType;

    @ManyToOne
    @JoinColumn(name = "measure_type_id")
    private MeasureType measureType;

    @Column(name = "standard")
    private Float standard;

    @Column(name = "low_up_alert")
    private Float lowUpAlert;

    @Column(name = "low_down_alert")
    private Float lowDownAlert;

    @Column(name = "high_up_alert")
    private Float highUpAlert;

    @Column(name = "high_down_alert")
    private Float highDownAlert;

    @Column(name = "create_datetime")
    private Date createDateTime;

    public MonTargetTypeDefaultRule() {
    }

    public MonTargetTypeDefaultRule(MonTargetType monTargetType, MeasureType measureType, Float standard,
                                    Float lowUpAlert, Float lowDownAlert, Float highUpAlert, Float highDownAlert,
                                    Date createDateTime) {
        this.monTargetType = monTargetType;
        this.measureType = measureType;
        this.standard = standard;
        this.lowUpAlert = lowUpAlert;
        this.lowDownAlert = lowDownAlert;
        this.highUpAlert = highUpAlert;
        this.highDownAlert = highDownAlert;
        this.createDateTime = createDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MonTargetType getMonTargetType() {
        return monTargetType;
    }

    public void setMonTargetType(MonTargetType monTargetType) {
        this.monTargetType = monTargetType;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }

    public Float getStandard() {
        return standard;
    }

    public void setStandard(Float standard) {
        this.standard = standard;
    }

    public Float getLowUpAlert() {
        return lowUpAlert;
    }

    public void setLowUpAlert(Float lowUpAlert) {
        this.lowUpAlert = lowUpAlert;
    }

    public Float getLowDownAlert() {
        return lowDownAlert;
    }

    public void setLowDownAlert(Float lowDownAlert) {
        this.lowDownAlert = lowDownAlert;
    }

    public Float getHighUpAlert() {
        return highUpAlert;
    }

    public void setHighUpAlert(Float highUpAlert) {
        this.highUpAlert = highUpAlert;
    }

    public Float getHighDownAlert() {
        return highDownAlert;
    }

    public void setHighDownAlert(Float highDownAlert) {
        this.highDownAlert = highDownAlert;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
