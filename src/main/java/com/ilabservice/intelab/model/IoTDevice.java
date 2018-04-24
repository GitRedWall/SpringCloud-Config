package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "iotdevice")
public class IoTDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serial_no")
    private String serialNo;

    @Column(name = "battery_status")
    private Float batteryStatus;

    @Column(name = "is_online")
    private Integer isOnline;

    private String model;

    @Column(name = "firmware_version")
    private String firmwareVersion;

    @Column(name = "create_datetime")
    private Date createDateTime;

    public IoTDevice() {
    }

    public IoTDevice(String serialNo, Float batteryStatus, Integer isOnline, String model, String firmwareVersion,
                     Date createDateTime) {
        this.serialNo = serialNo;
        this.batteryStatus = batteryStatus;
        this.isOnline = isOnline;
        this.model = model;
        this.firmwareVersion = firmwareVersion;
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

    public Float getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(Float batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
