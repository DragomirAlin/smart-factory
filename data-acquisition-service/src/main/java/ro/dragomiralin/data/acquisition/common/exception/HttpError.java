package ro.dragomiralin.data.acquisition.common.exception;

import lombok.*;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class HttpError extends RuntimeException {
    private HttpStatus status;
    private String message;

    public static HttpError notFound(String message) {
        return builder().status(HttpStatus.NOT_FOUND).message(message).build();
    }

    public static HttpError badRequest(String message) {
        return builder().status(HttpStatus.BAD_REQUEST).message(message).build();
    }

    public static HttpError unauthorized(String message) {
        return builder().status(HttpStatus.UNAUTHORIZED).message(message).build();
    }
}