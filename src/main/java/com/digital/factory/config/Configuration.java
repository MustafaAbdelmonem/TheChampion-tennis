package com.digital.factory.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@EnableSwagger2
@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Digital Factory API")
				.description("Digital Factory API reference for developers")
				.termsOfServiceUrl("http://DigitalFactory.com")
				.contact("DigitalFactory@gmail.com").license("Digital Factory License")
				.licenseUrl("Digital Factory@gmail.com").version("1.0").build();
	}
}
