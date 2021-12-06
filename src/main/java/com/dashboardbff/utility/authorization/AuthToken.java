package com.dashboardbff.utility.authorization;

import com.dashboardbff.request.LoginRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AuthToken {

    private static String SECRET = Key.AUTH_TOKEN_SECRET.getDescription();

    public static String getJWTToken(LoginRequest loginRequest) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("DASHBOARD_USER");

        String token = Jwts
                .builder()
                .claim("username", loginRequest.getEmail())
                .claim("password", loginRequest.getPassword())
                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();

        return "Bearer " + token;
    }

    public static Claims parseToken(String token) {
        try {

            String jwtToken = token.replace("Bearer ", "");
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(jwtToken)
                    .getBody();

            return body;
        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

}
