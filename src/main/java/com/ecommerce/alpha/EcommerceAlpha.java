package com.ecommerce.alpha;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "EcommerceAlpha API", version = "2.0", description = "EcommerceAlpha Information"))
public class EcommerceAlpha {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceAlpha.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	}
}
