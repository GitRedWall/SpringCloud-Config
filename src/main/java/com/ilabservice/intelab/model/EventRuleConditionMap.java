package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event_rule_condition_map")
public class EventRuleConditionMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_rule_id")
    private EventRule eventRule;

    @ManyToOne
    @JoinColumn(name = "event_condition_id")
    private EventCondition eventCondition;

    @Column(name = "`order`")
    private Integer order;

    private String operator;

    @Column(name = "create_datetime")
    private Date createDateTime;

    public EventRuleConditionMap() {
    }

    public EventRuleConditionMap(EventRule eventRule, EventCondition eventCondition, Integer order, String operator, Date createDateTime) {
        this.eventRule = eventRule;
        this.eventCondition = eventCondition;
        this.order = order;
        this.operator = operator;
        this.createDateTime = createDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventRule getEventRule() {
        return eventRule;
    }

    public void setEventRule(EventRule eventRule) {
        this.eventRule = eventRule;
    }

    public EventCondition getEventCondition() {
        return eventCondition;
    }

    public void setEventCondition(EventCondition eventCondition) {
        this.eventCondition = eventCondition;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
