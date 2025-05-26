package com.example.springblog.demos.web.mapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class JwtUtilsTest {
    // 1小时(ms
    private static final long JWT_EXPIRATION = 60 * 60 * 1000;

    private static final String secretStr = "sodafoasidgolnasdabadscasdfasdksdfnoasg";

    private static final  Key key = Keys.hmacShaKeyFor(secretStr.getBytes());
    @Test
    public void genJwt() {
        // 生成key



        Map<String,Object> claim = new HashMap<>();
        claim.put("id",1);
        claim.put("name","zhangsan");
        System.out.println(Jwts.builder().setClaims(claim).compact());
    }

    @Test
    public void getKey() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String str = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(str);
    }

    @Test
    public void parseToken() {
        String token = "还没去官网转换";

        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = build.parseClaimsJws(token).getBody();
        System.out.println(claims);
    }
}
