package com.ndt.bookshop_authentication.service.contract;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Encoders;


public interface JwtService {
    Claims extractClaims(String token);


    boolean isTokenValid(String token);


    String genAccessToken(Object data);


    String genAccessToken(Object data, long expiration);


    static String genSecretKey() {
        return Encoders.BASE64.encode(Jwts.SIG.HS256.key().build().getEncoded());
    }
}
