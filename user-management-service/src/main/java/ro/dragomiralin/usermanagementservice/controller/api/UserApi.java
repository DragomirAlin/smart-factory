package ro.dragomiralin.usermanagementservice.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.dragomiralin.usermanagementservice.dto.ErrorResponse;
import ro.dragomiralin.usermanagementservice.dto.UserContext;
import ro.dragomiralin.usermanagementservice.dto.UserDTO;

@Tag(name = "Users")
public interface UserApi {

    @Operation(operationId = "Create User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "400", description = "User already exists", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @PostMapping
    ResponseEntity<UserDTO> create(@Parameter(hidden = true) UserContext userContext);

    @Operation(operationId = "Get User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "400", description = "User already exists", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping
    ResponseEntity<UserDTO> get(@Parameter(hidden = true) UserContext userContext);

}
