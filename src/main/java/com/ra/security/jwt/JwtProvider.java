package com.ra.security.jwt;

import com.ra.security.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("${expired}")
    private Long EXPIRED;
    @Value("${secret_key}")
    private String SECRET_KEY;
    private Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
    public String generateToken(UserPrinciple userPrinciple){
        // Tạo ra thời gian sống của token
        Date dateExpiration = new Date(new Date().getTime() + EXPIRED);

        return Jwts.builder()
                .setSubject(userPrinciple.getUsername()).
                setExpiration(dateExpiration).
                signWith(SignatureAlgorithm.HS512,SECRET_KEY).compact();
    }
    public Boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpressionException |SignatureException | ExpiredJwtException | MalformedJwtException exception){
            logger.error("Exception Authentication {}",exception.getMessage());
        }
        return false;
    }
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
}
