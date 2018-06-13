package com.adrianapi.controller;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Controller;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Controller
public class SecurityServiceImpl implements SecurityService {
    private static final String SECRET_KEY = "SecrettKey";

    @Override
    public String createToken(String subject, long ttlMillis) {
        if (ttlMillis <= 0) {
            throw new RuntimeException("Expiry time must be greater than zero:[" + ttlMillis +"] ");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);

        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .signWith(signatureAlgorithm, signingKey);
        long nowMillis = System.currentTimeMillis();
        builder.setExpiration(new Date(nowMillis + ttlMillis));
        return  builder.compact();
    }

    @Override
    public String getToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
