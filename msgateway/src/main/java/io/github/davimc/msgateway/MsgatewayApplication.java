package io.github.davimc.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/employees/**").uri("lb://msemployee"))
				.route(r -> r.path("/stores/**").uri("lb://msstore"))
				.route(r -> r.path("/exchanges/**").uri("lb://msexchange"))
				//.route(r -> r.path("/avaliacoes-credito/**").uri("lb://msavaliadorcredito"))
				.build();
	}
}
