package com.oak.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtil {

    public static final String KEY = "testtoken1111111111111111111111111111111111111";

    public static final long EXPIRE = 1000 * 60 * 30;

    /**
     * 创建JWT
     *
     * @param username
     * @return
     */
    public static String createJwt(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRE);

        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, KEY) // 签名
            .setSubject(username)
            .setIssuedAt(now) // 签发时间
            .setExpiration(expiration) //过期时间
            .compact();
    }

    private static Claims getClaims(String jwt) {
        Claims claims = Jwts.parser()
            .setSigningKey(KEY)
            .parseClaimsJws(jwt)
            .getBody();
        return claims;
    }
    
    /**
     * 获取用户名
     */
    public static String getUsername(String jwt) {
       try {
           return getClaims(jwt).getSubject();
       } catch (Exception e) {
           log.warn(e.getMessage(), e);
           return "";
       }
    }

    public static boolean isExpire(String jwt) {
        try {
            return getClaims(jwt).getExpiration().getTime() - System.currentTimeMillis() > 0;
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            return false;
        }
    }



}
