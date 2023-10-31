package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // 签名
    private static final String sign = "security";

    /**
     * 生成token
     * @param userId 用户编号
     * @return 返回含有数字签名的token值
     */
    public static String createToken(String userId){
        Map<String, Object> map = new HashMap<>();
        map.put("algorithm", "HS256");
        map.put("type", "JWT");

        // 设置过期时间为1天
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,1);

        return JWT.create()
                // 设置header
                .withHeader(map)
                // 设置用户信息，可根据实际情况进行修改
                .withClaim("userid", userId)
                // 可以添加多个用户信息
                // .withClaim("username", username)
                // 设置过期时间，如果用redis可以不设置
                .withExpiresAt(instance.getTime())
                // 设置签发时间
                .withIssuedAt(new Date())
                // 设置签名
                .sign(Algorithm.HMAC256(sign));
    }

    /**
     * 解析token
     * @param token 上面生成的含有数字签名的token值
     * @return 返回token中声明的用户信息
     */
    public static Map<String, Claim> parseToken(String token){
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(sign)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            return null;
        }
        // 获取声明的信息
        return jwt.getClaims();
    }

}

