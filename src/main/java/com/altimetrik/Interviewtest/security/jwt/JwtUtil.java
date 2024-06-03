package com.altimetrik.Interviewtest.security.jwt;

import com.altimetrik.Interviewtest.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    @Value("${altimetrik.app.jwt.secret}")
    private String secrete;

    @Value("${altimetrik.app.jwt.expiration.ms}")
    private String expirationMs;

    public String generateToken(User user){
        Claims claims = Jwts.claims().setSubject(user.getUsername()).setExpiration(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+8640000));
        return createToken(claims,user.getUsername());
    }

    private String createToken(Claims claims, String username) {
        return Jwts.builder().setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secrete).compact();
    }

    public boolean validateToken(String token, User userDetails){
        final String userName = extractuserName(token);
        return (userName.equals(userDetails.getUsername()));
    }

    public String extractuserName(String token) {
        return extractClain(token, Claims::getSubject);
    }

    private <T> T extractClain(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllClains(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClains(String token){
        return Jwts.parser().setSigningKey(secrete).parseClaimsJws(token).getBody();
    }

}
