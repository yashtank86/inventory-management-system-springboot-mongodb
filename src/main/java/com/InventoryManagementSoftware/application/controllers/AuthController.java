package com.InventoryManagementSoftware.application.controllers;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.InventoryManagementSoftware.application.payload.request.LoginRequest;
import com.InventoryManagementSoftware.application.payload.request.SignupRequest;
import com.InventoryManagementSoftware.application.security.services.UserDetailsServiceImpl;
import com.InventoryManagementSoftware.domain.Entities.ERole;
import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import com.InventoryManagementSoftware.domain.Entities.TblRole;
import com.InventoryManagementSoftware.domain.Entities.TblUser;
import com.InventoryManagementSoftware.domain.Services.AuthService;
import com.InventoryManagementSoftware.domain.repository.RoleRepository;
import com.InventoryManagementSoftware.domain.repository.UserRepository;
import com.InventoryManagementSoftware.application.security.jwt.JwtUtils;
import com.InventoryManagementSoftware.application.security.services.UserDetailsImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @GetMapping("/login")
    public String login(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginUser", loginRequest);
        return "login";
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "user/home";
    }


    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin/home";
    }


    @GetMapping("/register")
    public String register(Model model) {
        SignupRequest signupRequest = new SignupRequest();
        model.addAttribute("registerUser", signupRequest);
        return "register";
    }

    @PostMapping("/login/save")
    public String authenticateUser(@Valid @ModelAttribute("loginUser") LoginRequest loginRequest,
                                   HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            // Handle authentication failure, e.g., invalid credentials
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/login"; // Return login page with error message
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        /*List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());*/

        //String url = determineRedirectUrl(authentication, userDetails.getUsername());

        String token = jwtUtils.generateTokenFromUsername(loginRequest.getUsername());
        // Set JWT token as a cookie
        Cookie jwtCookie = new Cookie("jwtToken", token);
        jwtCookie.setPath("/IMS");
        response.addCookie(jwtCookie);

        return determineRedirectUrl(userDetails);

    }

    private String determineRedirectUrl(UserDetailsImpl userDetails) {

        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

       /* List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()); */

        if (roles.contains("ROLE_USER")) {
            return "redirect:/user/home";
        } else if (roles.contains("ROLE_ADMIN")) {
            return "redirect:/admin/home";
        }
        return "redirect:/";
    }

    /*public String defaultPage() {
        // Redirect to the appropriate home page based on the user's role
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_USER")) {
                return "redirect:/user/productList";
            } else if (authority.getAuthority().equals("ROLE_ADMIN")) {
                return "redirect:/admin/home";
            }
        }
        return "redirect:/";
    }*/


    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute("registerUser") SignupRequest signUpRequest, Model model, BindingResult result) {

        String msg = "";

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            result.rejectValue("username", "", "username is already taken!!");

        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            result.rejectValue("email", "", "this email is already in use!!");

        }

        // Create new user's account
        TblUser user = new TblUser(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRoles();
        Set<TblRole> roles = new HashSet<>();

        if (strRoles == null) {
            TblRole userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        TblRole adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        TblRole modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        TblRole userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        if (result.hasErrors()) {
            model.addAttribute("registerUser", signUpRequest);
            return "redirect:/register";
        }

        user.setRoles(roles);
        userRepository.save(user);

        return "redirect:/login";
    }

    @PostMapping("/logout")
    public void logout() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();


    }


}

