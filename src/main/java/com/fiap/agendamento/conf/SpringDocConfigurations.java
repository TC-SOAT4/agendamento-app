//package com.fiap.agendamento.conf;
//
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@SecurityScheme(
//    name = "bearerAuth",
//    type = SecuritySchemeType.HTTP,
//    bearerFormat = "JWT",
//    scheme = "bearer"
//)
//public class SpringDocConfigurations {
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI().info(new Info()
//                .title("Agendamento API")
//                .description("Agendamento API")
//                .contact(new Contact().name("Grupo 33")));
//    }
//}
