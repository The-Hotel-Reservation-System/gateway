package com.example.gateway.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
//  @Value("${jwt.secret}")
//  private String secret;

  private String SECRET_KEY = "secret";

//  private Key key;

//  @PostConstruct
//  public void init(){
//    this.key = Keys.hmacShaKeyFor(secret.getBytes());
//  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  public Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }

  private boolean isTokenExpired(String token) {
    return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
  }

  public boolean isInvalid(String token) {
    return this.isTokenExpired(token);
  }

}
