package ro.dragomiralin.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String sub;
    private String email;
    private String firstName;
    private String lastName;
}
