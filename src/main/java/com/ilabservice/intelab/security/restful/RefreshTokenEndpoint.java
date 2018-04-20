package com.ilabservice.intelab.security.restful;

import com.ilabservice.intelab.model.User;
import com.ilabservice.intelab.security.auth.jwt.extractor.TokenExtractor;
import com.ilabservice.intelab.security.auth.jwt.verifier.TokenVerifier;
import com.ilabservice.intelab.security.config.JwtSettings;
import com.ilabservice.intelab.security.config.WebSecurityConfig;
import com.ilabservice.intelab.security.exceptions.InvalidJwtToken;
import org.springframework.http.MediaType;
import com.ilabservice.intelab.security.model.UserContext;
import com.ilabservice.intelab.security.model.token.JwtToken;
import com.ilabservice.intelab.security.model.token.JwtTokenFactory;
import com.ilabservice.intelab.security.model.token.RawAccessJwtToken;
import com.ilabservice.intelab.security.model.token.RefreshToken;
import com.ilabservice.intelab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RefreshTokenEndpoint {
    @Autowired private JwtTokenFactory tokenFactory;
    @Autowired private JwtSettings jwtSettings;
    @Autowired private UserService userService;
    @Autowired private TokenVerifier tokenVerifier;
    @Autowired @Qualifier("jwtHeaderTokenExtractor") private TokenExtractor tokenExtractor;

    @RequestMapping(value="/api/auth/token", method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM));
        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtToken());

        String jti = refreshToken.getJti();
        if(!tokenVerifier.verify(jti)){
            throw new InvalidJwtToken();
        }

        String subject = refreshToken.getSubject();
        User user = userService.getByUsername(subject);
        if (user == null){
            throw new UsernameNotFoundException("User not found: " + subject);
        }

        if (user.getRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getId(), user.getUserName(), authorities);

        return tokenFactory.createAccessJwtToken(userContext);
    }
}
