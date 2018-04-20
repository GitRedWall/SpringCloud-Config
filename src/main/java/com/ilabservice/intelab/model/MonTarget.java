package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mon_target")
public class MonTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private GeoLocation geoLocation;

    @ManyToOne
    @JoinColumn(name = "mon_target_type_id")
    private MonTargetType monTargetType;

    @Column(name = "serial_no")
    private String serialNo;

    @Column(name = "ref_table")
    private String refTable;

    @Column(name = "ref_table_id")
    private Long refTableId;

    private String code;

    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column(name = "create_datetime")
    private Date createDateTime;

    @Column(name = "is_enabled")
    private Integer isEnabled;

    private String status;

    @Column(name = "enable_sharing")
    private Integer enableSharing;

    @Column(name = "block_chain_key")
    private String blockChainKey;

    @Column(name = "rent_clause")
    private String rent_clause;

    @Column(name = "rent_price_per_hour")
    private Double rentPricePerHour;

    @Column(name = "latest_running_status")
    private Integer latestRunningStatus;

    public MonTarget() {
    }

    public MonTarget(GeoLocation geoLocation, String serialNo, MonTargetType monTargetType, String refTable, Long refTableId,
                     String code, String name, User owner, User creator, Date createDateTime, Integer isEnabled,
                     String status, Integer enableSharing, String blockChainKey, String rent_clause,
                     Double rentPricePerHour, Integer latestRunningStatus) {
        this.geoLocation = geoLocation;
        this.serialNo = serialNo;
        this.monTargetType = monTargetType;
        this.refTable = refTable;
        this.refTableId = refTableId;
        this.code = code;
        this.name = name;
        this.owner = owner;
        this.creator = creator;
        this.createDateTime = createDateTime;
        this.isEnabled = isEnabled;
        this.status = status;
        this.enableSharing = enableSharing;
        this.blockChainKey = blockChainKey;
        this.rent_clause = rent_clause;
        this.rentPricePerHour = rentPricePerHour;
        this.latestRunningStatus = latestRunningStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public MonTargetType getMonTargetType() {
        return monTargetType;
    }

    public void setMonTargetType(MonTargetType monTargetType) {
        this.monTargetType = monTargetType;
    }

    public String getRefTable() {
        return refTable;
    }

    public void setRefTable(String refTable) {
        this.refTable = refTable;
    }

    public Long getRefTableId() {
        return refTableId;
    }

    public void setRefTableId(Long refTableId) {
        this.refTableId = refTableId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEnableSharing() {
        return enableSharing;
    }

    public void setEnableSharing(Integer enableSharing) {
        this.enableSharing = enableSharing;
    }

    public String getBlockChainKey() {
        return blockChainKey;
    }

    public void setBlockChainKey(String blockChainKey) {
        this.blockChainKey = blockChainKey;
    }

    public String getRent_clause() {
        return rent_clause;
    }

    public void setRent_clause(String rent_clause) {
        this.rent_clause = rent_clause;
    }

    public Double getRentPricePerHour() {
        return rentPricePerHour;
    }

    public void setRentPricePerHour(Double rentPricePerHour) {
        this.rentPricePerHour = rentPricePerHour;
    }

    public Integer getLatestRunningStatus() {
        return latestRunningStatus;
    }

    public void setLatestRunningStatus(Integer latestRunningStatus) {
        this.latestRunningStatus = latestRunningStatus;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
