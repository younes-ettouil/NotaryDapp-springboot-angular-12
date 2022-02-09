package com.notaryDapp.gateway.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component @Slf4j
public class TokenFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        try {
            String token = exchange.getRequest().getHeaders().get("Authorization").get(0);
            if (token != null) {
                try {
                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(token);
                    String username = decodedJWT.getSubject();
                    log.info("user {} request {}", username, exchange.getRequest().getPath());
                    return chain.filter(exchange);
                } catch (Exception e) {
                    log.error("Invalid token");
                    return null;
                }
            }
        } catch (Exception e) {
            log.error("No token was provided");
        }
        return null;
    }
}