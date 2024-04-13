package ro.dragomiralin.user.management.repository.persistence;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class User {
    private String id;
    private String email;
    private String username;
}
