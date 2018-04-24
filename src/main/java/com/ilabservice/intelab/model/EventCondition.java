package com.ilabservice.intelab.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event_condition")
public class EventCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "measure_type_id")
    private MeasureType measureType;

    @ManyToOne
    @JoinColumn(name = "iot_device_id")
    private IoTDevice ioTDevice;

    private String operator;

    private Float value;

    @Column(name = "create_datetime")
    private Date createDateTime;

    public EventCondition() {
    }

    public EventCondition(MeasureType measureType, IoTDevice ioTDevice, String operator, Float value, Date createDateTime) {
        this.measureType = measureType;
        this.ioTDevice = ioTDevice;
        this.operator = operator;
        this.value = value;
        this.createDateTime = createDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }

    public IoTDevice getIoTDevice() {
        return ioTDevice;
    }

    public void setIoTDevice(IoTDevice ioTDevice) {
        this.ioTDevice = ioTDevice;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
