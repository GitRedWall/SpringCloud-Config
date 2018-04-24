package com.ilabservice.intelab.model;

import javax.persistence.*;

@Entity
@Table(name = "mon_target_disable_sharing_strategy")
public class MonTargetDisableSharingStrategy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mon_target_id")
    private MonTarget monTarget;

    @Column(name = "strategy_type")
    private String strategyType;

    private String content;

    public MonTargetDisableSharingStrategy() {
    }

    public MonTargetDisableSharingStrategy(MonTarget monTarget, String strategyType, String content) {
        this.monTarget = monTarget;
        this.strategyType = strategyType;
        this.content = content;
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

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
