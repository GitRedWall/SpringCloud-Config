package com.ilabservice.intelab.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serial_no")
    private String serialNo;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private IoTDevice ioTDevice;

    @Column(name = "sample_frequency")
    private Integer sampleFrequency;

    @Column(name = "sample_time_unit")
    private String sampleTimeUnit;

    @Column(name = "zero_drift")
    private Double zeroDrift;

    @Column(name = "calibration_frequency")
    private String calibrationFrequency;

    @Column(name = "last_calibration_date")
    private Date lastCalibrationDate;

    @Column(name = "input_high")
    private Float inputHigh;

    @Column(name = "input_low")
    private Float inputLow;

    @Column(name = "output_high")
    private Float outputHigh;

    @Column(name = "output_low")
    private Float outputLow;

    @Column(name = "create_datetime")
    private Date createDateTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sensor_measure_type_map",
        joinColumns = {@JoinColumn(name = "sensor_id", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "measure_type_id", nullable = false)})
    private Set<MeasureType> measureTypes = new HashSet<>();

    public void addMeasureType(MeasureType measureType){
        this.measureTypes.add(measureType);
        measureType.getSensorSet().add(this);
    }

    public void removeMeasureType(MeasureType measureType){
        this.measureTypes.remove(measureType);
        measureType.getSensorSet().remove(this);
    }

    public Sensor() {
    }

    public Sensor(String serialNo, IoTDevice ioTDevice, Integer sampleFrequency, String sampleTimeUnit,
                  Double zeroDrift, String calibrationFrequency, Date lastCalibrationDate, Float inputHigh,
                  Float inputLow, Float outputHigh, Float outputLow, Date createDateTime) {
        Assert.notNull(ioTDevice);
        this.serialNo = serialNo;
        this.ioTDevice = ioTDevice;
        this.sampleFrequency = sampleFrequency;
        this.sampleTimeUnit = sampleTimeUnit;
        this.zeroDrift = zeroDrift;
        this.calibrationFrequency = calibrationFrequency;
        this.lastCalibrationDate = lastCalibrationDate;
        this.inputHigh = inputHigh;
        this.inputLow = inputLow;
        this.outputHigh = outputHigh;
        this.outputLow = outputLow;
        this.createDateTime = createDateTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public IoTDevice getIoTDevice() {
        return ioTDevice;
    }

    public void setIoTDevice(IoTDevice ioTDevice) {
        this.ioTDevice = ioTDevice;
    }

    public Integer getSampleFrequency() {
        return sampleFrequency;
    }

    public void setSampleFrequency(Integer sampleFrequency) {
        this.sampleFrequency = sampleFrequency;
    }

    public String getSampleTimeUnit() {
        return sampleTimeUnit;
    }

    public void setSampleTimeUnit(String sampleTimeUnit) {
        this.sampleTimeUnit = sampleTimeUnit;
    }

    public Double getZeroDrift() {
        return zeroDrift;
    }

    public void setZeroDrift(Double zeroDrift) {
        this.zeroDrift = zeroDrift;
    }

    public String getCalibrationFrequency() {
        return calibrationFrequency;
    }

    public void setCalibrationFrequency(String calibrationFrequency) {
        this.calibrationFrequency = calibrationFrequency;
    }

    public Date getLastCalibrationDate() {
        return lastCalibrationDate;
    }

    public void setLastCalibrationDate(Date lastCalibrationDate) {
        this.lastCalibrationDate = lastCalibrationDate;
    }

    public Float getInputHigh() {
        return inputHigh;
    }

    public void setInputHigh(Float inputHigh) {
        this.inputHigh = inputHigh;
    }

    public Float getInputLow() {
        return inputLow;
    }

    public void setInputLow(Float inputLow) {
        this.inputLow = inputLow;
    }

    public Float getOutputHigh() {
        return outputHigh;
    }

    public void setOutputHigh(Float outputHigh) {
        this.outputHigh = outputHigh;
    }

    public Float getOutputLow() {
        return outputLow;
    }

    public void setOutputLow(Float outputLow) {
        this.outputLow = outputLow;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Set<MeasureType> getMeasureTypes() {
        return measureTypes;
    }

    public void setMeasureTypes(Set<MeasureType> measureTypes) {
        this.measureTypes = measureTypes;
    }
}
