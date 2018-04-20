package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iot_device_id")
    private IoTDevice iotDevice;

    @ManyToOne
    @JoinColumn(name = "event_rule_id")
    private EventRule eventRule;

    private Integer counts;

    @Column(name = "start_datetime")
    private Date startDateTime;

    @Column(name = "end_datetime")
    private Date endDateTime;

    @Column(name = "diagnose_reason")
    private String diagnoseReason;

    @Column(name = "corrective_action")
    private String correctiveAction;

    @Column(name = "process_status")
    private String processStatus;

    @Column(name = "last_process_datetime")
    private Date lastProcessDatetime;

    public Event() {
    }

    public Event(IoTDevice iotDevice, EventRule eventRule, Integer counts, Date startDateTime, Date endDateTime,
                 String diagnoseReason, String correctiveAction, String processStatus, Date lastProcessDatetime) {
        this.iotDevice = iotDevice;
        this.eventRule = eventRule;
        this.counts = counts;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.diagnoseReason = diagnoseReason;
        this.correctiveAction = correctiveAction;
        this.processStatus = processStatus;
        this.lastProcessDatetime = lastProcessDatetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IoTDevice getIotDevice() {
        return iotDevice;
    }

    public void setIotDevice(IoTDevice iotDevice) {
        this.iotDevice = iotDevice;
    }

    public EventRule getEventRule() {
        return eventRule;
    }

    public void setEventRule(EventRule eventRule) {
        this.eventRule = eventRule;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getDiagnoseReason() {
        return diagnoseReason;
    }

    public void setDiagnoseReason(String diagnoseReason) {
        this.diagnoseReason = diagnoseReason;
    }

    public String getCorrectiveAction() {
        return correctiveAction;
    }

    public void setCorrectiveAction(String correctiveAction) {
        this.correctiveAction = correctiveAction;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Date getLastProcessDatetime() {
        return lastProcessDatetime;
    }

    public void setLastProcessDatetime(Date lastProcessDatetime) {
        this.lastProcessDatetime = lastProcessDatetime;
    }
}
