package com.software.gameHub.service;

import com.software.gameHub.core.security.JwtUtil;
import com.software.gameHub.entity.dto.LoginRequest;
import com.software.gameHub.entity.dto.LoginResponse;
import com.software.gameHub.entity.dto.converter.LoginResponseConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthManager {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final LoginResponseConverter converter;

    public AuthManager(AuthenticationManager authenticationManager, JwtUtil jwtUtil, LoginResponseConverter converter) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.converter = converter;
    }

    public LoginResponse login(LoginRequest request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                (request.getEmail(),
                        request.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        return converter.convert(jwtUtil.generateToken(authenticate));
    }
}
