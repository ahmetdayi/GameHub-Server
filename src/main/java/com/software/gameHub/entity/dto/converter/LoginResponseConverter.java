package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.LoginResponse;

import org.springframework.stereotype.Component;

@Component
public class LoginResponseConverter {


    public LoginResponse convert(String token){
        return new LoginResponse(token);

    }
}
