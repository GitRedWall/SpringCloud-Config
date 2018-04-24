package com.ilabservice.intelab.security.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class UserContext {
    private final String username;
    private final List<GrantedAuthority> authorities;
    private final Long id;

    private UserContext(Long id, String username, List<GrantedAuthority> authorities){
        this.username = username;
        this.authorities = authorities;
        this.id = id;
    }

    public static UserContext create(Long id, String username, List<GrantedAuthority> authorities){
        if(StringUtils.isBlank(username))
            throw new IllegalArgumentException("Username is blank");
        return new UserContext(id, username, authorities);
    }

    public String getUsername(){
        return username;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId(){
        return id;
    }
}
