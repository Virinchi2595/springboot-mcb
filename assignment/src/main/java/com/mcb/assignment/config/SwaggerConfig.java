package com.mcb.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
public class SwaggerConfig {

  @Bean
  public Docket api() {

    return new Docket(SWAGGER_2)
        .securitySchemes(singletonList(new ApiKey(AUTHORIZATION, AUTHORIZATION, "header")))
        .securityContexts(
            singletonList(
                SecurityContext.builder()
                    .securityReferences(
                        singletonList(
                            SecurityReference.builder()
                                .reference(AUTHORIZATION)
                                .scopes(new AuthorizationScope[0])
                                .build()))
                    .build()))
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.mcb.assignment"))
        .build();
  }
}
