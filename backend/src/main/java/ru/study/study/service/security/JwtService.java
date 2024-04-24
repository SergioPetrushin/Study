package ru.study.study.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.study.study.entity.user.User;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.properties.secretKey}")
    private String secret;

    @Value("${jwt.properties.validityDuration}")
    private Long duration;


    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();

        if (userDetails instanceof User user){
            claims.put("id", user.getId());
            claims.put("email", user.getEmail());
        }

        return generateToken(claims, userDetails);

    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equalsIgnoreCase(userDetails.getUsername()) && extractExpirationDate(token).after(new Date(System.currentTimeMillis()));
    }



    private String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + duration))
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    private Key getSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }


    private Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token).getBody();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Date extractExpirationDate(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

}
