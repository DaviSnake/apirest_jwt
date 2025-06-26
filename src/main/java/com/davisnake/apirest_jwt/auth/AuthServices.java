package com.davisnake.apirest_jwt.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.davisnake.apirest_jwt.jwt.JwtServices;
import com.davisnake.apirest_jwt.user.Role;
import com.davisnake.apirest_jwt.user.User;
import com.davisnake.apirest_jwt.user.UserDTO;
import com.davisnake.apirest_jwt.user.UserRepository;
import com.davisnake.apirest_jwt.user.UserServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServices {

    private final UserRepository userRepository;
    private final JwtServices jwtServices;
    private final UserServices userServices;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        UserDetails user = userRepository.findByUserName(request.getUserName()).orElseThrow();
        String token = jwtServices.getToken(user);
        UserDTO userDTO = userServices.getUserByName(user.getUsername());
        return AuthResponse.builder()
            .id(userDTO.getId())
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        
        User user = User.builder()
            .userName(request.getUserName())
            .password(passwordEncoder.encode( request.getPassword()))
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .country(request.getCountry())
            .role(Role.USER)
            .build();
        
        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtServices.getToken(user))
            .build();
    }

}
