package com.ilabservice.intelab.security.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilabservice.intelab.security.CustomCorsFilter;
import com.ilabservice.intelab.security.RestAuthenticationEntryPoint;
import com.ilabservice.intelab.security.auth.ajax.AjaxAuthenticationProvider;
import com.ilabservice.intelab.security.auth.ajax.LoginProcessFilter;
import com.ilabservice.intelab.security.auth.jwt.JwtAuthenticationProvider;
import com.ilabservice.intelab.security.auth.jwt.JwtTokenAuthenticationProcessingFilter;
import com.ilabservice.intelab.security.auth.jwt.SkipPathRequestMatcher;
import com.ilabservice.intelab.security.auth.jwt.extractor.TokenExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
    public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
    public static final String FORM_BASED_LOGIN_ENTRY_POINT = "/api/unsecure/login";
    public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/secure/**";
    public static final String PLANT_ENTRY_POINT = "/api/unsecure/**";
    public static final String TOKEN_REFRESH_ENTRY_POINT = "/api/unsecure/token";

    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    @Autowired
    private AjaxAuthenticationProvider ajaxAuthenticationProvider;
    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;
    @Autowired
    private TokenExtractor tokenExtractor;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ObjectMapper objectMapper;

    protected LoginProcessFilter buildLoginProcessFilter() throws Exception{
        LoginProcessFilter filter = new LoginProcessFilter(FORM_BASED_LOGIN_ENTRY_POINT, successHandler, failureHandler, objectMapper);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter() throws Exception{
        List<String> pathsToSkip = Arrays.asList(TOKEN_REFRESH_ENTRY_POINT, FORM_BASED_LOGIN_ENTRY_POINT, PLANT_ENTRY_POINT);
        SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, TOKEN_BASED_AUTH_ENTRY_POINT);
        JwtTokenAuthenticationProcessingFilter filter
                = new JwtTokenAuthenticationProcessingFilter(failureHandler, tokenExtractor, matcher);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(ajaxAuthenticationProvider);
        auth.authenticationProvider(jwtAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(this.authenticationEntryPoint)
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                        .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll()
                        .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll()
                        .antMatchers(PLANT_ENTRY_POINT).permitAll()
                .and()
                    .authorizeRequests()
                        .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated()
                .and()
                    .addFilterBefore(new CustomCorsFilter(), UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(buildLoginProcessFilter(), UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
