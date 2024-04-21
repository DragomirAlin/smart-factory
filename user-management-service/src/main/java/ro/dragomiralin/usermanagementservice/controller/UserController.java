package ro.dragomiralin.usermanagementservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.dragomiralin.usermanagementservice.controller.api.UserApi;
import ro.dragomiralin.usermanagementservice.dto.UserContext;
import ro.dragomiralin.usermanagementservice.dto.UserDTO;
import ro.dragomiralin.usermanagementservice.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public ResponseEntity<UserDTO> create(UserContext userContext) {
        return ResponseEntity.ok(userService.createUser(userContext));
    }

    @Override
    public ResponseEntity<UserDTO> get(UserContext userContext) {
        return ResponseEntity.ok(userService.getUserByEmail(userContext.getEmail()));
    }

}
