package com.Bank.ApiGateway.controller;


import com.Bank.ApiGateway.dto.JwtRequest;
import com.Bank.ApiGateway.dto.JwtResponse;
import com.Bank.ApiGateway.dto.UserDto;
import com.Bank.ApiGateway.service.AuthService;
import com.Bank.ApiGateway.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest)
    {
        return new ResponseEntity<>(authService.login(jwtRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid UserDto user , BindingResult result)
    {
        if(result.hasErrors()){
            return "Validation error : " + result.getAllErrors();
        }
        else {
            userService.registerUser(user);
            return "User created successfully!";
        }
    }
}
