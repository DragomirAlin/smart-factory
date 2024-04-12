package ro.dragomiralin.data.acquisition.controller;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ro.dragomiralin.data.acquisition.common.exception.HttpError;

@Slf4j
@ControllerAdvice
public class ControllerAdviceHandler {
    @Data
    @Builder
    public static class ErrorResponse {
        private String message;
    }

    @ExceptionHandler(HttpError.class)
    public ResponseEntity handleHttpError(HttpError e) {
        log.error("Error: status={}, message={},", e.getStatus().toString(), e.getMessage(), e);
        return ResponseEntity.status(e.getStatus()).body(ErrorResponse.builder().message(e.getMessage()).build());
    }
}
