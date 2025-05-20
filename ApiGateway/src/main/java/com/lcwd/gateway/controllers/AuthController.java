package com.lcwd.gateway.controllers;


import com.lcwd.gateway.models.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public static final Logger logger=Logger.getLogger(AuthController.class.getName());

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> logIn(
           @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
           @AuthenticationPrincipal OidcUser user,
           Model model

    )
    {

        logger.info("User  Email id: {}" + user.getEmail());

        //creating AuthResponse obj using Builder
        AuthResponse authResponse= new AuthResponse();

        //setting email to AuthResponse
        authResponse.setUserId(user.getEmail());

        //setting token to athResponse
        authResponse.setAccessToken(client.getAccessToken().getTokenValue());

        //setting token to athResponse
        authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());

        authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());

        //collection type
        //It is used to apply a function to each element of the stream and collect or operate on the transformed elements.
        //map used for extract each element
        List<String> authorities = user.getAuthorities().stream().map(grantedAuthority -> {
            return grantedAuthority.getAuthority();
        }).collect(Collectors.toList());

        authResponse.setAuthorities(authorities);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

}
