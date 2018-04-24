package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resource_role_user_map")
public class ResourceRoleUserMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "resource_id")
    private Long resourceId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_datetime")
    private Date createDatetime;

    public ResourceRoleUserMap(){

    }

    public ResourceRoleUserMap(Long resource_id, Role role, Long user_id, Date create_datetime) {
        this.resourceId = resource_id;
        this.role = role;
        this.userId = user_id;
        this.createDatetime = create_datetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resource_id) {
        this.resourceId = resource_id;
    }

    public Role getRole() {
        return role;
    }

    public void setRoleId(Role role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date create_datetime) {
        this.createDatetime = create_datetime;
    }
}
