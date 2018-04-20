package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "event_rule")
public class EventRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rule_name")
    private String ruleName;

    private String description;

    @Column(name = "create_datetime")
    private Date createDateTime;

    @ManyToOne
    @JoinColumn(name = "mon_target_type_id")
    private MonTargetType monTargetType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "event_rule_action_map",
        joinColumns = {@JoinColumn(name = "event_rule_id", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "event_action_id", nullable = false)})
    private Set<EventAction> eventActions;

    @OneToMany(mappedBy = "eventRule", fetch = FetchType.LAZY)
    private Set<Event> events;

    public void addEventAction(EventAction eventAction){
        this.eventActions.add(eventAction);
        eventAction.getEventRules().add(this);
    }

    public void removeEventAction(EventAction eventAction){
        this.eventActions.remove(eventAction);
        eventAction.getEventRules().remove(this);
    }

    public EventRule() {
    }

    public EventRule(String ruleName, String description, Date createDateTime, MonTargetType monTargetType,
                     Set<Event> events ) {
        this.ruleName = ruleName;
        this.description = description;
        this.createDateTime = createDateTime;
        this.monTargetType = monTargetType;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public MonTargetType getMonTargetType() {
        return monTargetType;
    }

    public void setMonTargetType(MonTargetType monTargetType) {
        this.monTargetType = monTargetType;
    }

    public Set<EventAction> getEventActions() {
        return eventActions;
    }

    public void setEventActions(Set<EventAction> eventActions) {
        this.eventActions = eventActions;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
