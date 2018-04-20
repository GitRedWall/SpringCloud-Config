package com.ilabservice.intelab.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

@Component
public class BloomFilterTokenVerifier implements TokenVerifier{
    @Override
    public boolean verify(String jit){
        return true;
    }
}
