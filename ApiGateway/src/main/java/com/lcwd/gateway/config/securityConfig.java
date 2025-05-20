package com.lcwd.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class securityConfig {


    @Bean
public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity)
{

   serverHttpSecurity
           .authorizeExchange(exchanges -> exchanges
                   .anyExchange().authenticated()
           )
           .oauth2ResourceServer(outh2 -> outh2.jwt(jwtSpec -> {}));
   return serverHttpSecurity.build();

//
//    serverHttpSecurity
//            .authorizeExchange()
//            .anyExchange()
//            .authenticated()
//            .and()
//            .oauth2Client()
//            .and()
//            .oauth2ResourceServer()
//            .jwt();
//    return serverHttpSecurity.build();


}



}
