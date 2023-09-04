package com.example.shoppingmall.global.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;
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


    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private Claims parseClaims(String token) throws JwtException {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public Authentication getAuthentication(String token) {
        try {
            Claims claim = parseClaims(token);
            UserDetails details = createAuthenticatedUserFromClaims(claim);
            return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
        } catch (JwtException e) {
            return null;
        }
    }

    private UserDetails createAuthenticatedUserFromClaims(Claims claims) {
        String username = getName(claims);
        return new User(username, "", Collections.emptyList());
    }

    private String getName(Claims claims) {
        return claims.getSubject();
    }

}
