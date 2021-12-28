package com.example.instagrambackend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JWTUtil {
    private static final String SECRET_KEY = "THIS_IS_A_SECRET_KEY";

    public String generateToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        return CreateToken(claims, userDetails.getUsername());
    }

    public String CreateToken(HashMap<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) throws ExpiredJwtException {
        String username = extractUsername(token);
        return userDetails.getUsername().equals(username) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) throws ExpiredJwtException {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) throws ExpiredJwtException {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername(String token) throws ExpiredJwtException {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws ExpiredJwtException {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) throws ExpiredJwtException {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
