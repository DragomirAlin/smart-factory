package ro.dragomiralin.gateway.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Autowired
    RouteDefinitionLocator routeDefinitionLocator;
    @Bean
    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters swaggerUiConfigProperties) {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = routeDefinitionLocator.getRouteDefinitions().collectList().block();
        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
            String name = routeDefinition.getId().replaceAll("-service", "");
            swaggerUiConfigProperties.addGroup(name);
            GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
        });
        return groups;
    }
}
