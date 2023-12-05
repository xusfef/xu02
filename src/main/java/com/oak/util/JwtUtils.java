package com.oak.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtils {

    private static final String SECRET = "et230611111111111111111111111111";

    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final long EXPIRE = 1000 * 60 * 60 *24;

    public static String create(String username) {
        Date now = new Date();
        return Jwts.builder()
                .signWith(KEY, SignatureAlgorithm.HS256) // 签名算法
                .setIssuedAt(now) // 签发时间
                .setExpiration(new Date(now.getTime() + EXPIRE)) // 过期时间
                .setSubject(username)
                .compact();
    }

    public static String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(KEY).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
