package com.example.demo.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {

    @Value("${jwt.secret.key}")
    private String  secretKey;
    @Value("${jwt.time.expiration}")
    private String timeExpiration;

    //create token
    public String generateAccessToken(String id){
        return Jwts.builder().setSubject(id)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(timeExpiration)))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //validar el token de acceso
    public boolean isTokenValid(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return   true;
        }catch (Exception e){
            return false;
        }
    }

    //obtener usuario del token
    public String getUserNameFromToken(String token){
        return getClaim(token,Claims::getSubject);
    }

    //obtener 1 solo claim u dato
    public <T> T getClaim(String token,Function<Claims,T> claimsFunction){
        Claims claims = extractAllClaim(token);
        return claimsFunction.apply(claims);
    }

    //obtener todos los claims u datos del token
    public Claims extractAllClaim(String token){
        return  Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //obtener firma del token
    public Key  getSignatureKey(){
        byte[]keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
