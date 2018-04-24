package com.ilabservice.intelab.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "mon_target_group")
public class MonTargetGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_desc")
    private String groupDesc;

    @Column(name = "is_dynamic")
    private Integer isDynamic;

    @Column(name = "dynamic_group_rule")
    private String dynamicGroupRule;

    @Column(name = "parent_group_id")
    private Integer parentGroupId;

    @Column(name = "create_datetime")
    private Date createDateTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mon_target_group_static_map",
        joinColumns = {@JoinColumn(name = "group_id", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "mon_target_id", nullable = false)})
    private Set<MonTarget> monTargetSet;

    public MonTargetGroup() {
    }

    public MonTargetGroup(String groupName, String groupDesc, Integer isDynamic, String dynamicGroupRule,
                          Integer parentGroupId, Date createDateTime, Set<MonTarget> monTargetSet) {
        Assert.notNull(groupName);
        this.groupName = groupName;
        this.groupDesc = groupDesc;
        this.isDynamic = isDynamic;
        this.dynamicGroupRule = dynamicGroupRule;
        this.parentGroupId = parentGroupId;
        this.createDateTime = createDateTime;
        this.monTargetSet = monTargetSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Integer getIsDynamic() {
        return isDynamic;
    }

    public void setIsDynamic(Integer isDynamic) {
        this.isDynamic = isDynamic;
    }

    public String getDynamicGroupRule() {
        return dynamicGroupRule;
    }

    public void setDynamicGroupRule(String dynamicGroupRule) {
        this.dynamicGroupRule = dynamicGroupRule;
    }

    public Integer getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Integer parentGroupId) {
        this.parentGroupId = parentGroupId;
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
