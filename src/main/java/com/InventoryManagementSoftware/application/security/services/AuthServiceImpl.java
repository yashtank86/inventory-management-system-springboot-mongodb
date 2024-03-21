package com.InventoryManagementSoftware.application.security.services;

import com.InventoryManagementSoftware.application.payload.request.LoginRequest;
import com.InventoryManagementSoftware.application.security.jwt.JwtUtils;
import com.InventoryManagementSoftware.domain.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    public String authenticate(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // Generate JWT token
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return jwtTokenUtil.generateTokenFromUsername(username);
    }
}
