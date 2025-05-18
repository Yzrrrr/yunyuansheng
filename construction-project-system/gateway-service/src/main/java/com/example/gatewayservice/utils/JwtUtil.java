package com.example.gatewayservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "yourSecretKey";  // 用于签名的密钥

    // 生成 JWT Token
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1天有效期
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 验证 JWT Token
    public static boolean validateToken(String token) {
        try {
            // 使用旧版 parser() 方法
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);
            return true;  // 如果解析成功，说明 Token 有效
        } catch (Exception e) {
            return false; // 如果解析失败，Token 无效
        }
    }

    // 获取 Token 中的用户名
    public static String getUsernameFromToken(String token) {
        // 使用旧版 parser() 方法
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}