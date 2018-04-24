package com.ilabservice.intelab.security.auth.jwt.verifier;

public interface TokenVerifier {
    public boolean verify(String jit);
}
