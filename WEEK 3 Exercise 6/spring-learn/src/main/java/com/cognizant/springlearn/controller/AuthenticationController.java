package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    
    // Key used to sign the JWT
    private static final byte[] SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - authenticate");
        
        // 1. Read Authorization header and decode username and password
        String user = "unknown";
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedCreds = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedCreds);
            String[] split = credentials.split(":", 2);
            user = split[0];
            String password = split[1];
            LOGGER.debug("Decoded user: {}", user);
        }
        
        // 2. Generate token based on the user retrieved
        String token = generateJwt(user);
        
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        
        LOGGER.info("END - authenticate");
        return response;
    }
    
    private String generateJwt(String user) {
        JwtBuilder builder = Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 minutes expiration
            .signWith(Keys.hmacShaKeyFor(SECRET_KEY));
        return builder.compact();
    }
}
