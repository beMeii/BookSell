package com.prm.group6.services;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    String extractEmail(String token);
    String generateToken(UserDetails userDetails);
    String generateToken(
            Map<String,Object> extraClaims
            ,UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpire(String token);
    Date extractExperation(String token);
    <T> T extractClaim(String token, Function<Claims,T> claimsResolver);
    Claims extractAllClaims(String token);
    Key getSignInKey();

}
