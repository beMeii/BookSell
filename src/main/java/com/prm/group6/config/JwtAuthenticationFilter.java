package com.prm.group6.config;

import com.prm.group6.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtServiceImpl;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if (request.getRequestURI().startsWith("/h2-console/")) {
            System.out.println("Acessing h2-console");
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("Token check");
        // check coi nó có gắn token dô cái request chưa
        if (authHeader==null || !authHeader.startsWith("Bearer ")){
            System.out.println("Bearer check");
            filterChain.doFilter(request,response);
            return;
        }

        // nếu mà nó gắn token rồi
        jwt = authHeader.substring(7);
        userEmail = jwtServiceImpl.extractEmail(jwt); //lấy user email từ cái jwt token ra
        //nếu mà fetch được userEmail maf user chưa được authenticate thì tạo 1 cái authToken gắn cho SecurityContext
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            System.out.println("User fetched from database");
            if (jwtServiceImpl.isTokenValid(jwt,userDetails)){
                System.out.println("Token is valid");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
