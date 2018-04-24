package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role_definition")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Column(name = "role_type")
    private String roleType;

    @Column(name = "create_datetime")
    private Date createDatetime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission_map",
            joinColumns = {@JoinColumn(name = "role_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", nullable = false)})
    private Set<Permission> rolePermissions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public void addPermission(Permission permission){
        this.rolePermissions.add(permission);
        permission.getRolesWithPermission().add(this);
    }

    public void removePermission(Permission permission){
        this.rolePermissions.remove(permission);
        permission.getRolesWithPermission().remove(this);
    }

    public Role() {
    }

    public Role(String name, String description, String roleType, Date createDatetime) {
        this.name = name;
        this.description = description;
        this.roleType = roleType;
        this.createDatetime = createDatetime;
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

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Set<Permission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Set<Permission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
