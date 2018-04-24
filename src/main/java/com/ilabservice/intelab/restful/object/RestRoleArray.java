package com.ilabservice.intelab.restful.object;

import com.ilabservice.intelab.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RestRoleArray {
    private List<RestRole> roles = new ArrayList<>();

    public RestRoleArray(Set<Role> roleSet){
        if(roleSet != null){
            for(Role role : roleSet){
                roles.add(new RestRole(role));
            }
        }
    }

    public List<RestRole> getRoles() {
        return roles;
    }

    public void setRoles(List<RestRole> roles) {
        this.roles = roles;
    }
}
