package com.example.springblog.demos.web.utils;

import com.example.springblog.demos.web.constant.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtUtils {
    private static final long JWT_EXPIRATION = 60*60*1000;
    private static final String secretStr = "sodafoasidgoQWERlnasdabadscasdfasdksdfnoasg";
    private static final Key key = Keys.hmacShaKeyFor(secretStr.getBytes());
    /**
     * 生成token
     */
    public static String genJwtToken(Map<String,Object> claim) {
        String token = Jwts.builder().setClaims(claim)
                .setExpiration(new Date(System.currentTimeMillis()+JWT_EXPIRATION))
                .signWith(key)
                .compact();
        return token;
    }

    /**
     * 校验token
     * 非null 成功
     * null 失败
     */
    public static Claims parseToken(String token) {
        Claims claims = null;
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        try {
            claims = build.parseClaimsJws(token).getBody();
        }catch (Exception e) {
            log.error("解析token失败,token:{}",token);
            return null;
        }

        return claims;
    }

    public static Integer getIdByToken(String token) {
        Claims claims = parseToken(token);
        Integer userId = null;
        if (claims!=null) {
            userId = (Integer) claims.get(Constants.TOKEN_ID);
            if (userId>0) {
                return userId;
            }
        }
        return null;
    }

}
