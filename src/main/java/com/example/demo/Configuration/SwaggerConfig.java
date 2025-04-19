package com.example.demo.Configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	
	    @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("SL Transport API")
	                        .version("1.0")
	                        .description("API Documentation for SL Transport System")
	                        .contact(new Contact()
	                                .name("Shamgumam")
	                                .email("sltranspots@demo.com")
	                                .url("https://sltransports.com")))
	                .servers(List.of(
	                        new Server().url("http://localhost:8080").description("Local Server"),
	                        new Server().url("https://api.production.com").description("Production Server")
	                ));
	    }
	    
}


