package com.books.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

//                UserAuthService url
                .route(p -> p
                        .path("/api/auth/**") // url pattern that will be exposed -- http://localhost:9000/api/v1/login
                        .uri("http://localhost:8090/")) // actual url pattern of microservice -- http://localhost:8085/api/v1/login
//                UserService
                .route(p->p
                        .path("/api/users/**")
                        .uri("http://localhost:8091/"))

//                BookService
                .route(p->p
                        .path("/api/Books/**")
                        .uri("http://localhost:8092/"))

//          NotificationService
                .route(p->p
                        .path("/api/notifications/**") //
                        .uri("http://localhost:8095/"))

                .build();
    }

}




