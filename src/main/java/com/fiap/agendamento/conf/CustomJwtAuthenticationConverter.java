package com.fiap.agendamento.conf;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

   private static final String COGNITO_GROUPS = "cognito:groups";
   private static final String COGNITO_USERNAME = "username";


   @SuppressWarnings("null")
   @Override
   public AbstractAuthenticationToken convert(Jwt source) {

       String username = (String) source.getClaims().get(COGNITO_USERNAME);

       @SuppressWarnings("unchecked")
       List<String> roles = (List<String>) source.getClaims().get(COGNITO_GROUPS);

       if (roles == null || roles.isEmpty())
           return new JwtAuthenticationToken(source, Arrays.asList(new SimpleGrantedAuthority("ROLE_CLIENTE")),
                   username);

       // Create authorities from roles.
       List<SimpleGrantedAuthority> authorities = roles.stream()
               .map(role -> new SimpleGrantedAuthority("ROLE_" + role)).toList();

       return new JwtAuthenticationToken(source, authorities, username);

   }
}
