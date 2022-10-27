package sat.recruitment.api.configuration;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("sat.recruitment.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo apiInfo(){
        return new ApiInfo(
                "Paramo-Tech",
                "Descripción",
                "2.0",
                "Términos y Condiciones",
                new Contact("Charly Moreno Code", "www.charly", "charlydmoreno@gmail.com"),
                "Licencia",
                "www.licencia.com",
                Collections.emptyList()
        );
    }

}
