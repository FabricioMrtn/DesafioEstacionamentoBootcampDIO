package com.fabriciomrtn.github.Estacionamento.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fabriciomrtn.github.Estacionamento"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData())
				.securityContexts(Arrays.asList(actuatorSecurityContext()))
				.securitySchemes(Arrays.asList(basicAuthScheme()));
	}

	private SecurityScheme basicAuthScheme() {
		
		return new BasicAuth("basicAuth");
	}

	private Object actuatorSecurityContext() {
		return SecurityContext.builder().securityReferences(Arrays.asList(basicAuthScheme())
				).build;
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Estacionamento REST API")
				.description("API REST com Spring Boot para Estacionamento")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
}
