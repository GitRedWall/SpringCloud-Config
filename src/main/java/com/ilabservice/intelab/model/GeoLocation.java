package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "geo_location")
public class GeoLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private GeoLocation parent;

    @OneToMany(mappedBy = "parent")
    private Set<GeoLocation> childLocation = new HashSet<>();

    private String name;

    private String description;

    private String address;

    @Column(name = "location_type")
    private String locationType;

    private String timezone;

    private String latitude;

    private String longtitude;

    @Column(name = "create_datetime")
    private Date createDateTime;

    @Column(name = "x_location")
    private Float xLocation;

    @Column(name = "y_location")
    private Float yLocation;

    @Column(name = "is_root")
    private Integer isRoot;

    @Column(name = "is_leaf")
    private Integer isLeaf;

    public GeoLocation() {
    }

    public GeoLocation(GeoLocation parent, String name, String description, String address, String locationType,
                       String timezone, String latitude, String longtitude, Date createDateTime, Float xLocation,
                       Float yLocation, Integer isRoot, Integer isLeaf) {
        this.parent = parent;
        this.name = name;
        this.description = description;
        this.address = address;
        this.locationType = locationType;
        this.timezone = timezone;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.createDateTime = createDateTime;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.isRoot = isRoot;
        this.isLeaf = isLeaf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeoLocation getParent() {
        return parent;
    }

    public void setParent(GeoLocation parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Float getxLocation() {
        return xLocation;
    }

    public void setxLocation(Float xLocation) {
        this.xLocation = xLocation;
    }

    public Float getyLocation() {
        return yLocation;
    }

    public void setyLocation(Float yLocation) {
        this.yLocation = yLocation;
    }

    public Integer getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Integer isRoot) {
        this.isRoot = isRoot;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Set<GeoLocation> getChildLocation() {
        return childLocation;
    }

    public void setChildLocation(Set<GeoLocation> childLocation) {
        this.childLocation = childLocation;
    }
}
