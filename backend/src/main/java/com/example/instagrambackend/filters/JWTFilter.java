package com.example.instagrambackend.filters;


import com.example.instagrambackend.util.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    UserDetailsService userDetailsService;
    JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Pass All The Allowed paths and methods
        if (!isPathOrMethodAllowed(request)) {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            // Is Authorisation Token is null Or Wrong
            if (isNotNullOrBearer(authorizationHeader)) {
                String token = authorizationHeader.split(" ")[1];
                String username = jwtUtil.extractUsername(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (userDetails != null) {
                    if (jwtUtil.validateToken(token, userDetails)) {
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    } else response.sendError(FORBIDDEN.value());
                } else response.sendError(FORBIDDEN.value());
            } else response.sendError(FORBIDDEN.value());
        }
        filterChain.doFilter(request, response);
    }

    private boolean isNotNullOrBearer(String authorizationHeader) {
        return authorizationHeader != null || authorizationHeader.startsWith("Bearer ");
    }

    private boolean isPathOrMethodAllowed(HttpServletRequest request) {
        return request.getServletPath().equals("/auth/login") ||
                request.getServletPath().equals("/auth/sign-up") ||
                request.getServletPath().equals("/auth/isValidUsername") ||
                request.getMethod().equals("OPTIONS");
    }
}
