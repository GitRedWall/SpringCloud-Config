package com.ilabservice.intelab.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "mon_target_type")
public class MonTargetType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Column(name = "logo_url")
    private String logoURL;

    @Column(name = "create_datetime")
    private Date createDateTime;

    @OneToMany(mappedBy = "monTargetType", fetch = FetchType.LAZY)
    private Set<MonTarget> monTargetSet;

    public MonTargetType() {
    }

    public MonTargetType(String name, String description, String logoURL, Date createDateTime,
                         Set<MonTarget> monTargetSet) {
        Assert.notNull(name);
        this.name = name;
        this.description = description;
        this.logoURL = logoURL;
        this.createDateTime = createDateTime;
        this.monTargetSet = monTargetSet;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Set<MonTarget> getMonTargetSet() {
        return monTargetSet;
    }

    public void setMonTargetSet(Set<MonTarget> monTargetSet) {
        this.monTargetSet = monTargetSet;
    }
}
