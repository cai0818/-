package com.uniplan.user.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import java.sql.Date;

/**
 * @Author cai
 * @Description
 * @Date 2023/8/2210:12
 * @Description $
 * @Email :2904623189@qq.com
 * @return $
 **/

public class JwtUtil {
    private static final String SECRET_KEY = "miyao";
    private static final long EXPIRATION_TIME = 86400000; // 24小时

    public static String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }


    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            // 签名验证失败
            return false;
        }
    }

    public static String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}