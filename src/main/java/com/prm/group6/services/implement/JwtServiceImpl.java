package com.prm.group6.services.implement;

import com.prm.group6.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
private static final String SECRET_KEY="7A25432A46294A404E635266556A586E3272357538782F413F4428472B4B6150";
    public String extractEmail(String token) {
        return extractClaim(token,Claims::getSubject);
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(){
                    {
                        put("Role","CUSTOMER");
                    }
                },userDetails);
    }
    public String generateToken(
            Map<String,Object> extraClaims
            ,UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60*24)) //expire in 1 day
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String email=extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpire(token));
    }
    public boolean isTokenExpire(String token) {
        return extractExperation(token).before(new Date());
    }
    public Date extractExperation(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    //Extract a claim by choice
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }
    public Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
