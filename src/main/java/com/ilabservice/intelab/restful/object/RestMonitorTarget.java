package com.ilabservice.intelab.restful.object;

import com.ilabservice.intelab.model.MonTarget;

import java.util.Date;

public class RestMonitorTarget {

    private Long id;
    private String name;
    private String code;
    private String monitorTargetType;
    private Long createTime;
    private String serialNo;
    private Long ownerId;
    private Long locationId;
    private String locationBackground;
    private Integer enableSharing;
    private String chainKey;
    private String rentClause;
    private Double rentPrice;
    private Integer latestRunningStatus;

    public RestMonitorTarget(MonTarget monTarget) {
        this.id = monTarget.getId();
        this.name = monTarget.getName();
        this.code = monTarget.getCode();
        this.monitorTargetType = monTarget.getMonTargetType() == null ? null : monTarget.getMonTargetType().getName();
        this.createTime = monTarget.getCreateDateTime() == null ? null : monTarget.getCreateDateTime().getTime();
        this.serialNo = monTarget.getSerialNo();
        this.ownerId = monTarget.getOwner() == null ? null : monTarget.getOwner().getId();
        this.locationId = monTarget.getGeoLocation() == null ? null : monTarget.getGeoLocation().getId();
        this.locationBackground = "";
        this.enableSharing = monTarget.getEnableSharing();
        this.chainKey = monTarget.getBlockChainKey();
        this.rentClause = monTarget.getRent_clause();
        this.rentPrice = monTarget.getRentPricePerHour();
        this.latestRunningStatus = monTarget.getLatestRunningStatus();
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

    public String getMonitorTargetType() {
        return monitorTargetType;
    }

    public void setMonitorTargetType(String monitorTargetType) {
        this.monitorTargetType = monitorTargetType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationBackground() {
        return locationBackground;
    }

    public void setLocationBackground(String locationBackground) {
        this.locationBackground = locationBackground;
    }

    public Integer getEnableSharing() {
        return enableSharing;
    }

    public void setEnableSharing(Integer enableSharing) {
        this.enableSharing = enableSharing;
    }

    public String getChainKey() {
        return chainKey;
    }

    public void setChainKey(String chainKey) {
        this.chainKey = chainKey;
    }

    public String getRentClause() {
        return rentClause;
    }

    public void setRentClause(String rentClause) {
        this.rentClause = rentClause;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Integer getLatestRunningStatus() {
        return latestRunningStatus;
    }

    public void setLatestRunningStatus(Integer latestRunningStatus) {
        this.latestRunningStatus = latestRunningStatus;
    }
}
