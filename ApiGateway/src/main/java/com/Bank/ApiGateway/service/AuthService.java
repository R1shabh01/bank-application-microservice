package com.Bank.ApiGateway.service;


import com.Bank.ApiGateway.dto.JwtRequest;
import com.Bank.ApiGateway.dto.JwtResponse;
import com.Bank.ApiGateway.jwt.JwtAuthenticationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtAuthenticationHelper jwtHelper;

    @Autowired
    UserDetailsService userDetailsService;

    public JwtResponse login(JwtRequest jwtRequest) {

            //authenticate with Authentication manager

            this.doAuthenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

            UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
            String token = jwtHelper.generateToken(userDetails);

            JwtResponse response = JwtResponse.builder().setJwtToken(token).build();
            return response;
    }

    private void doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authenticationToken);

        }catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Username or Password");
        }
    }

}
