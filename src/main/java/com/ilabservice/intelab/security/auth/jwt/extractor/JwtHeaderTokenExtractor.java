package com.ilabservice.intelab.security.auth.jwt.extractor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

@Component
public class JwtHeaderTokenExtractor implements TokenExtractor{
    public static String HEADER_PREFIX = "Bearer ";

    @Override
    public String extract(String header){
        if(StringUtils.isBlank(header))
            throw new AuthenticationServiceException("Authorization header is empty");

        if (header.length() < HEADER_PREFIX.length())
            throw new AuthenticationServiceException("Invalid authorization header length");

        return header.substring(HEADER_PREFIX.length(), header.length());
    }
}
