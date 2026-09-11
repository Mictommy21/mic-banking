package com.baraka.mic_banking.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration}")
    private long jwtExpirationDate;

    // Generate JWT token
    public String generateToken(Authentication authentication) {

        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(
                currentDate.getTime() + jwtExpirationDate
        );

        return Jwts.builder()
                .subject(username)
                .issuedAt(currentDate)
                .expiration(expireDate)
                .signWith(key())
                .compact();
    }

    // Create secret key
    private SecretKey key() {

        return Keys.hmacShaKeyFor(
                java.util.Base64.getDecoder().decode(jwtSecret)
        );
    }

    // Get username from JWT token
    public String getUsername(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(key())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    // Validate JWT token
    public boolean validateToken(String token) {

        try {

            Jwts.parser()
                    .verifyWith(key())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (ExpiredJwtException e) {

            System.out.println("JWT token has expired");

        } catch (MalformedJwtException e) {

            System.out.println("Invalid JWT token");

        } catch (IllegalArgumentException e) {

            System.out.println("JWT token is empty or invalid");

        }

        return false;
    }
}

