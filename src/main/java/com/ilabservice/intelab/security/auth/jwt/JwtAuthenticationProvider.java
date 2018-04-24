package com.ilabservice.intelab.security.auth.jwt;

import com.ilabservice.intelab.security.auth.JwtAuthenticationToken;
import com.ilabservice.intelab.security.config.JwtSettings;
import com.ilabservice.intelab.security.model.UserContext;
import com.ilabservice.intelab.security.model.token.RawAccessJwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
//@SuppressWarnings("unchecked")
public class JwtAuthenticationProvider implements AuthenticationProvider{
    private static Logger logger = LoggerFactory.getLogger(JwtAuthenticationProvider.class);

    private final JwtSettings jwtSettings;

    @Autowired
    public JwtAuthenticationProvider(JwtSettings jwtSettings){
        this.jwtSettings = jwtSettings;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        RawAccessJwtToken rawAccessJwtToken = (RawAccessJwtToken) authentication.getCredentials();

        Jws<Claims> jwsClaims = rawAccessJwtToken.parseClaims(jwtSettings.getTokenSigningKey());
        String subject = jwsClaims.getBody().getSubject();

        Long id = jwsClaims.getBody().get("user_id", Integer.class).longValue();
        List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
        for (String scope : scopes){
            logger.debug("scope: " + scope);
        }
        List<GrantedAuthority> authorities = scopes.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());

        UserContext context = UserContext.create(id, subject, authorities);

        return new JwtAuthenticationToken(context, context.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication){
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
