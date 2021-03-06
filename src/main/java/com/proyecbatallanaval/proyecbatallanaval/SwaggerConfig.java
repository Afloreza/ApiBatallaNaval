package com.proyecbatallanaval.proyecbatallanaval;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiBatallaNavalDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ProyecBatallaNaval")
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.proyecbatallanaval.proyecbatallanaval.controlador"))
                .paths(PathSelectors.any()).build()
                .apiInfo(getApiInfo());
    }
    //Agregar método información o documentación de mi api
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Api Batalla Naval",
                "Api de Batalla Naval con ListaDE",
                "1.0",
                "http://www.proyecbatallanaval.edu.co/",
                new Contact("Angela Florez", "http://www.proyecbatallanaval.edu.co/",
                        "angela@umanizales.edu.co"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
