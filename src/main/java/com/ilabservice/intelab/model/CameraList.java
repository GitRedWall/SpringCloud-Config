package com.ilabservice.intelab.model;

import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "camera_list")
public class CameraList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "mon_target_id")
    private MonTarget monTarget;

    @Column(name = "serial_no")
    private String serialNo;

    @Column(name = "play_url")
    private String playURL;

    private String description;

    public CameraList() {
    }

    public CameraList(String name, MonTarget monTarget, String serialNo, String playURL, String description) {
        Assert.notNull(name);
        Assert.notNull(monTarget);
        this.name = name;
        this.monTarget = monTarget;
        this.serialNo = serialNo;
        this.playURL = playURL;
        this.description = description;
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

    public MonTarget getMonTarget() {
        return monTarget;
    }

    public void setMonTarget(MonTarget monTarget) {
        this.monTarget = monTarget;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPlayURL() {
        return playURL;
    }

    public void setPlayURL(String playURL) {
        this.playURL = playURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
