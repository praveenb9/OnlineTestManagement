package com.capg.otms.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class OtmsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsUserApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();			
}
	@Bean
	public CorsFilter corsFilter() {

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		final CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);

		config.addAllowedOrigin("*");

		config.addAllowedHeader("*");

		config.addAllowedMethod("OPTIONS");

		config.addAllowedMethod("HEAD");

		config.addAllowedMethod("GET");

		config.addAllowedMethod("PUT");

		config.addAllowedMethod("POST");

		config.addAllowedMethod("DELETE");

		config.addAllowedMethod("PATCH");

		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);

	}
}
