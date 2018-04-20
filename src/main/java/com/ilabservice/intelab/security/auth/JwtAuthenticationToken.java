package com.ilabservice.intelab.security.auth;

import com.ilabservice.intelab.security.model.UserContext;
import com.ilabservice.intelab.security.model.token.RawAccessJwtToken;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken{
    private RawAccessJwtToken rawAccessJwtToken;
    private UserContext userContext;

    public JwtAuthenticationToken(RawAccessJwtToken unsafeToken){
        super(null);
        this.rawAccessJwtToken = unsafeToken;
        this.setAuthenticated(false);
    }

    public JwtAuthenticationToken(UserContext context, Collection<? extends GrantedAuthority> authorities){
        super(authorities);
        this.eraseCredentials();
        this.userContext = context;
        super.setAuthenticated(true);
    }

    @Override
    public void setAuthenticated(boolean authenticated){
        if(authenticated){
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public Object getCredentials(){
        return rawAccessJwtToken;
    }

    @Override
    public Object getPrincipal(){
        return this.userContext;
    }

    @Override
    public void eraseCredentials(){
        super.eraseCredentials();
        this.rawAccessJwtToken = null;
    }
}
