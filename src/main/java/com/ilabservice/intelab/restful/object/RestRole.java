package com.ilabservice.intelab.restful.object;

import com.ilabservice.intelab.model.Permission;
import com.ilabservice.intelab.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RestRole {

    private String name;
    private String roleType;
    private List<RestPermission> permissions = new ArrayList<RestPermission>();

    public RestRole(Role role){
        name = role.getName();
        roleType = role.getRoleType();
        Set<Permission> permissionSet = role.getRolePermissions();
        if(permissionSet != null){
            for(Permission permission : permissionSet){
                permissions.add(new RestPermission(permission));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public List<RestPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RestPermission> permissions) {
        this.permissions = permissions;
    }
}
