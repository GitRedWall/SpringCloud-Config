package com.ilabservice.intelab.restful.object;

import com.ilabservice.intelab.model.Permission;

public class RestPermission {
    private String name;
    private String permissionType;
    private String description;

    public RestPermission(Permission permission){
        name = permission.getName();
        if(permission.getPermissionType() != null) {
            permissionType = permission.getPermissionType();
        }
        if(permission.getDescription() != null){
            description = permission.getDescription();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
