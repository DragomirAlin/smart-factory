package ro.dragomiralin.subscription.controller.middleware;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import ro.dragomiralin.subscription.client.UserManagementClient;
import ro.dragomiralin.subscription.dto.UserDTO;

import java.util.UUID;


@Service
@AllArgsConstructor
public class UserResolver {
    private ApplicationContext applicationContext;

    public UserDTO getUser() {
        Authentication springAuth = SecurityContextHolder.getContext().getAuthentication();

        if ((springAuth instanceof JwtAuthenticationToken)) {
            UserManagementClient userManagementClient = applicationContext.getBean(UserManagementClient.class);
            return userManagementClient.getUser();
        }

        // Testing use case
        if (springAuth instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) springAuth;
            return UserDTO.builder()
                    .id(UUID.randomUUID().toString())
                    .sub(auth.getName())
                    .firstName(auth.getName())
                    .lastName("Test")
                    .email("test@cc")
                    .build();
        }

        return null;
    }
}
