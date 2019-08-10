package com.GregsApp;

import io.swagger.models.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@EnableJpaRepositories
@SpringBootApplication
public class ShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareApplication.class, args);
    }
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Server API")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public ApiInfo apiInfo() {
        Contact contact = new Contact();
        contact.setName("Grzegorz Ozimski");
        contact.setEmail("grzegorzozimski@gmail.com");
        contact.setUrl("http://github.com/");
        return new ApiInfoBuilder()
                .title("Parking-Sharing")
                .description("Share your parking place")
                .contact(String.valueOf(contact))
                .build();
    }

}
