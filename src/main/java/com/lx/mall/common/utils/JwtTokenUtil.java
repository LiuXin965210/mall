package com.lx.mall.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtToken生成的工具类
 *
 * @author LiuXin
 * @date 2021/12/19 20:47
 **/
@Slf4j
@Component
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 生成token
     * @author LiuXin
     * @date 2021/12/19 21:23
     * @param userDetails 
     * @return java.lang.String
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 生成token
     * @author LiuXin
     * @date 2021/12/19 20:54
     * @param claims 
     * @return java.lang.String
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成过期时间
     * @author LiuXin
     * @date 2021/12/19 20:57
     * @return java.util.Date
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration);
    }

    /**
     * 从token中获取用户名
     * @author LiuXin
     * @date 2021/12/19 21:05
     * @param token
     * @return java.lang.String
     */
    public String getUsernameFromToken(String token) {
        String username = null;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
        }
        return username;
    }

    /**
     * 从token中获取JWT负载
     * @author LiuXin
     * @date 2021/12/19 21:09
     * @param token
     * @return io.jsonwebtoken.Claims
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.info("JWT格式验证失败:{}", token);
        }
        return claims;
    }

    /**
     * 验证token是否有效
     * @author LiuXin
     * @date 2021/12/19 21:12
     * @param token 
     * @param userDetails 
     * @return boolean
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        if (!isTokenExpired(token)) {
            String username = getUsernameFromToken(token);
            return userDetails.getUsername().equals(username);
        }
        return true;
    }

    /**
     * 判断token是否失效
     * @author LiuXin
     * @date 2021/12/19 21:12
     * @param token
     * @return boolean
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 获取令牌的过期时间
     * @author LiuXin
     * @date 2021/12/19 21:18
     * @param token 
     * @return java.util.Date
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 判断token是否可刷新
     * @author LiuXin
     * @date 2021/12/19 21:24
     * @param token 
     * @return boolean
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @author LiuXin
     * @date 2021/12/19 21:24
     * @param token 
     * @return java.lang.String
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
}
