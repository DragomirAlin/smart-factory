package ro.dragomiralin.usermanagementservice.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI smartFactoryApiDesc() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Management API")
                        .description("Spring User Management API application")
                        .version("v0.0.1")
                        .summary("Spring User Management application")
                        .contact(new Contact()
                                .name("Dragomir Alin")
                                .url("https://github.com/DragomirAlin")
                                .email("dragomirdanielalin@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")))
                .schemaRequirement("Bearer Authentication",
                        new SecurityScheme()
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .type(SecurityScheme.Type.HTTP));

    }

    @Bean
    public GroupedOpenApi smartFactoryApiSpec() {
        return GroupedOpenApi.builder()
                .group("smartfactory")
                .packagesToScan(getClass().getPackageName())
                .build();
    }

}
