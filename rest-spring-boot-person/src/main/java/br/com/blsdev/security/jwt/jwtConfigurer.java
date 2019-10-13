package br.com.blsdev.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.net.http.HttpRequest;

public class jwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public jwtConfigurer(JwtTokenProvider jwtTokenProvider) {

        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtTokenFilter custonFilter = new JwtTokenFilter(jwtTokenProvider);
        http.addFilterBefore(custonFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
