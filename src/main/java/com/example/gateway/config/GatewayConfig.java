package com.example.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  @Autowired
  AuthenticationFilter filter;

  @Bean
  public RouteLocator routes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route("GUEST-SERVICE", r -> r.path("/api/guest/**")
            .filters(f -> f.filter(filter))
            .uri("lb://GUEST-SERVICE"))

        .route("HOTEL-SERVICE", r -> r.path("/api/hotel/**")
            .filters(f -> f.filter(filter))
            .uri("lb://HOTEL-SERVICE"))

        .route("RESERVATION-SERVICE", r -> r.path("/api/reservation/**")
            .filters(f -> f.filter(filter))
            .uri("lb://RESERVATION-SERVICE"))
        .build();
  }
}
