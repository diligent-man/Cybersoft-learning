package com.ndt.bookshop_authentication.service.impl;

import java.util.Date;
import java.time.Instant;

import javax.crypto.SecretKey;


import lombok.Getter;


import io.jsonwebtoken.*;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;


import com.ndt.bookshop_authentication.service.contract.JwtService;


@Service
public class JwtServiceImpl implements JwtService {
    @Value(value = "${jwt.secret:}")
    private String secretKey;

    @Getter
    @Value(value = "${jwt.expiration:900000}")
    private long expiration;


    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }


    public Claims extractClaims(String token) {
        return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }


    public boolean isTokenValid(String token) {
        try {
            Claims claims = extractClaims(token);
            return claims.getExpiration().toInstant().isAfter(Instant.now());
        } catch (Exception e) {
            return false;
        }
    }


    public String genAccessToken(Object data) {
        return genAccessToken(data, expiration);
    }


    public String genAccessToken(Object data, long expirationMs) {
        try {
            Instant now = Instant.now();
            return Jwts.builder()
                .subject("hello")
                // .subject(user.getId().toString())
                // .claim("role", user.getRoleName())
                // .claim("email", user.getEmail())
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusMillis(expirationMs)))
                .signWith(getSigningKey())
                .compact();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate JWT token", e);
        }
    }


    public static String genSecretKey() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        return Encoders.BASE64.encode(key.getEncoded());
    }
}
