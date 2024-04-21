package ro.dragomiralin.usermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UserContext {
    private String sub;
    private String email;
    private String firstName;
    private String lastName;

    public static final class Fields {
        public static final String SUB = "sub";
        public static final String FIRST_NAME = "preferred_username";
        public static final String LAST_NAME = "family_name";
        public static final String EMAIL = "email";
        public static final String EMAIL_VERIFIED = "email_verified";
        public static final String CLAIMS = "claims";
    }

    @JsonIgnore
    public static UserContext from(Map<String, Object> claims){
        return UserContext.builder()
                .sub((String) claims.get(Fields.SUB))
                .firstName((String) claims.get(Fields.FIRST_NAME))
                .lastName((String) claims.get(Fields.LAST_NAME))
                .email((String) claims.get(Fields.EMAIL))
                .build();
    }
}
