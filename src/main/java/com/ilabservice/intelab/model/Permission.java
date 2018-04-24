package com.ilabservice.intelab.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "permission_type")
    private String permissionType;

    private String name;

    private String description;

    @Column(name = "create_datetime")
    private Date createDateTime;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "rolePermissions")
    private Set<Role> rolesWithPermission;

    public Permission() {
    }

    public Permission(String permissionType, String name, String description, Date createDateTime, Set<Role> rolesWithPermission) {
        this.permissionType = permissionType;
        this.name = name;
        this.description = description;
        this.createDateTime = createDateTime;
        this.rolesWithPermission = rolesWithPermission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
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

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Set<Role> getRolesWithPermission() {
        return rolesWithPermission;
    }

    public void setRolesWithPermission(Set<Role> rolesWithPermission) {
        this.rolesWithPermission = rolesWithPermission;
    }
}
