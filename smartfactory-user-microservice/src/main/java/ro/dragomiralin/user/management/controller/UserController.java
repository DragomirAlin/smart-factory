package ro.dragomiralin.user.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.dragomiralin.user.management.repository.persistence.User;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public User getUser() {
        log.info("The user endpoint was called!");
        return User.builder()
                .id("1")
                .email("smartfactory@dragomiralin.ro")
                .username("smartfactory")
                .build();
    }

    @PostMapping
    public User create(){
        return User.builder().build();
    }
}
