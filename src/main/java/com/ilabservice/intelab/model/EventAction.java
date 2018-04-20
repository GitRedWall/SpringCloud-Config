package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "event_action")
public class EventAction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "action_name")
    private String actionName;

    private String description;

    @Column(name = "is_enabled")
    private Integer isEnabled;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "eventActions")
    private Set<EventRule> eventRules;

    public EventAction() {
    }

    public EventAction(String actionName, String description, Integer isEnabled, Set<EventRule> eventRules) {
        this.actionName = actionName;
        this.description = description;
        this.isEnabled = isEnabled;
        this.eventRules = eventRules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Set<EventRule> getEventRules() {
        return eventRules;
    }

    public void setEventRules(Set<EventRule> eventRules) {
        this.eventRules = eventRules;
    }
}
