package ro.dragomiralin.gateway.configuration;

import org.springdoc.core.SwaggerUiConfigParameters;
import org.springdoc.core.SwaggerUiOAuthProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ org.springdoc.core.SpringDocConfigProperties.class,
        org.springdoc.core.SpringDocConfiguration.class,
        SwaggerUiConfigParameters.class, SwaggerUiOAuthProperties.class,
        org.springdoc.core.SwaggerUiConfigProperties.class, org.springdoc.core.SwaggerUiOAuthProperties.class,
        org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration.class })
public class SwaggerConfiguration {

}