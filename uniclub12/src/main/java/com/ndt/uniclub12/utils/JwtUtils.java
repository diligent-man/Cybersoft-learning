package com.ndt.uniclub12.utils;

import javax.crypto.SecretKey;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


@Component
public class JwtUtils {
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

    public static String generateJWTKey(){
        SecretKey key = Jwts.SIG.HS256.key().build();
        return Encoders.BASE64.encode(key.getEncoded());
    }
}
