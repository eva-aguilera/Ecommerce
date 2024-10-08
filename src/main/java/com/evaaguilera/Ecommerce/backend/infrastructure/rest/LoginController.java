package com.evaaguilera.Ecommerce.backend.infrastructure.rest;

import com.evaaguilera.Ecommerce.backend.infrastructure.dto.JWTClient;
import com.evaaguilera.Ecommerce.backend.infrastructure.dto.UserDTO;
import com.evaaguilera.Ecommerce.backend.infrastructure.jwt.JWTGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/security")
@Slf4j
public class LoginController {
    private final JWTGenerator jwtGenerator;
    private final AuthenticationManager authenticationManager;

    public LoginController(JWTGenerator jwtGenerator, AuthenticationManager authenticationManager) {
        this.jwtGenerator = jwtGenerator;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTClient> login(@RequestBody UserDTO userDTO){
    Authentication authentication = authenticationManager.authenticate(
            new  UsernamePasswordAuthenticationToken( userDTO.username(), userDTO.password())
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    log.info("Rol de user: {}", SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get().toString());



    String token = jwtGenerator.getToken(userDTO.username());
    JWTClient jwtClient = new JWTClient(token);

    return new ResponseEntity<>(jwtClient, HttpStatus.OK);
    }
}
