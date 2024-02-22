package br.com.farmtech.productmanager.infra;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Manager API")
                        .description("API Rest da aplicação de gerenciamento de produtos, contendo as funcionalidades de CRUD de produtos para o teste da FarmTech")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("rodrigo.neofx@gmail.com"))
                );
    }

}