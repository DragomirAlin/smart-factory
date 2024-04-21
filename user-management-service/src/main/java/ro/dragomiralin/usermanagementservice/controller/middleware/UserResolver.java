package ro.dragomiralin.usermanagementservice.controller.middleware;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import ro.dragomiralin.usermanagementservice.dto.UserContext;


@Service
@AllArgsConstructor
public class UserResolver {

    public UserContext getUser() {
        Authentication springAuth = SecurityContextHolder.getContext().getAuthentication();

        if ((springAuth instanceof JwtAuthenticationToken)) {
            JwtAuthenticationToken jwt = (JwtAuthenticationToken) springAuth;
            var claims = jwt.getTokenAttributes();

            return UserContext.from(claims);
        }

        // Testing use case
        if (springAuth instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) springAuth;
            return UserContext.builder()
                    .sub(auth.getName())
                    .firstName(auth.getName())
                    .lastName("Test")
                    .email("test@cc")
                    .build();
        }

        return null;
    }
}
