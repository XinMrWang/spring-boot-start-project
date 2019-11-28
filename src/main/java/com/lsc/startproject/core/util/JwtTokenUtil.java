package com.lsc.startproject.core.util;

import com.lsc.startproject.common.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

/**
 * jwt生成token
 *
 * @author halink
 */
@Slf4j
public class JwtTokenUtil {

    /**
     * 加密解密盐值
     */
    private static final String SALT = "123456";

    /**
     * 生成token(请根据自身业务扩展)
     *
     * @param subject           （主体信息）
     * @param expirationSeconds 过期时间（秒）
     * @param claims            自定义身份信息
     * @return token
     */
    public static String generateToken(String subject, int expirationSeconds, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                // 加密主体
                .setSubject(subject)
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                // 不使用公钥私钥
                .signWith(SignatureAlgorithm.HS512, SALT)
                // .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    /**
     * 生成token
     *
     * @param user 用户
     * @return token
     */
    public static String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUserId().toString())
                .setExpiration(new Date(System.currentTimeMillis()))
                .setIssuedAt(new Date())
                .setIssuer("JAMES")
                // 不使用公钥私钥
                .signWith(SignatureAlgorithm.HS512, SALT)
                .compact();
    }

    /**
     * 解析token,获得subject中的信息
     *
     * @param token token
     * @return 获得subject中的信息
     */
    public static String parseToken(String token) {
        String subject = null;
        try {
            subject = getTokenBody(token).getSubject();
        } catch (Exception e) {
            log.error("解析token发生异常{}", e.getMessage());
        }
        return subject;
    }

    /**
     * 获取token自定义属性
     *
     * @param token token
     * @return 获取token自定义属性
     */
    public static Map<String, Object> getClaims(String token) {
        Map<String, Object> claims = null;
        try {
            claims = getTokenBody(token);
        } catch (Exception e) {
            log.error("获取token自定义属性发生异常{}", e.getMessage());
        }
        return claims;
    }

    /**
     * 解析token自定义属性
     *
     * @param token token
     * @return token自定义属性
     */
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                //.setSigningKey(publicKey)
                .setSigningKey(SALT)
                .parseClaimsJws(token)
                .getBody();
    }
}
