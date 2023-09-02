package com.example.shoppingmall.global.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    @Value("secret")
    private String secretKey;

    public String createAccessToken(String email) {
        return createToken(email, "access", 7200L);
    }

    private String createToken(String email, String type, Long exp) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expiration = new Date(nowMillis + exp * 1000L);
            return Jwts.builder()
                    .claim("type", type)
                    .setIssuedAt(now)
                    .setSubject(email)
                    .setExpiration(expiration)
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
    }

}
