package com.ndt.uniclub12.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;


@Component
public class JWTUtils {
    @Value(value = "${jwt.private-key:}")
    private String secretStr;

    public String generateJWTToken(String data){
        SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretStr));
        return Jwts.builder().subject(data).signWith(secret).compact();
    }

    public String decodeJWTToken(String token){
        SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretStr));
        return Jwts.parser()
            .verifyWith(secret)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    public String generateJWTKey(){
        SecretKey key = Jwts.SIG.HS256.key().build();
        return Encoders.BASE64.encode(key.getEncoded());
    }
}
