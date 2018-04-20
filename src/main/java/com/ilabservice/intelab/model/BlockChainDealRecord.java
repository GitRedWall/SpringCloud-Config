package com.ilabservice.intelab.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "block_chain_deal_record")
public class BlockChainDealRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mon_target_id")
    private MonTarget monTarget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lessor_id")
    private User lessor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lessee_id")
    private User lessee;

    private Double price;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    private String aggrement;

    private Integer status;

    public BlockChainDealRecord() {
    }

    public BlockChainDealRecord(MonTarget monTarget, User lessor, User lessee, Double price, Date beginTime,
                                Date endTime, String aggrement, Integer status) {
        Assert.notNull(monTarget);
        Assert.notNull(lessor);
        Assert.notNull(lessee);
        Assert.notNull(price);
        Assert.notNull(beginTime);
        Assert.notNull(endTime);
        Assert.notNull(status);
        this.monTarget = monTarget;
        this.lessor = lessor;
        this.lessee = lessee;
        this.price = price;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.aggrement = aggrement;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MonTarget getMonTarget() {
        return monTarget;
    }

    public void setMonTarget(MonTarget monTarget) {
        this.monTarget = monTarget;
    }

    public User getLessor() {
        return lessor;
    }

    public void setLessor(User lessor) {
        this.lessor = lessor;
    }

    public User getLessee() {
        return lessee;
    }

    public void setLessee(User lessee) {
        this.lessee = lessee;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAggrement() {
        return aggrement;
    }

    public void setAggrement(String aggrement) {
        this.aggrement = aggrement;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
