package ro.dragomiralin.subscription.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.dragomiralin.subscription.dto.SubscriptionDTO;
import ro.dragomiralin.subscription.dto.UserDTO;

import java.util.List;

@Tag(name = "Subscriptions")
public interface SubscriptionApi {

    @Operation(operationId = "Create Subscription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SubscriptionDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")}),
    })
    @PostMapping
    ResponseEntity<SubscriptionDTO> createSubscription(@Parameter(hidden = true) UserDTO userDTO, @RequestBody SubscriptionDTO subscriptionDTO);

    @Operation(operationId = "Get Subscription by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SubscriptionDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid ID", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")}),
    })
    @GetMapping("/{id}")
    ResponseEntity<SubscriptionDTO> getSubscriptionById(@Parameter(hidden = true) UserDTO userDTO, @PathVariable String id);

    @Operation(operationId = "Get All Subscriptions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscriptions found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")}),
    })
    @GetMapping
    ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions(@Parameter(hidden = true) UserDTO userDTO);

    @Operation(operationId = "Delete Subscription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Subscription deleted", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid ID", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")}),
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSubscription(@Parameter(hidden = true) UserDTO userDTO, @PathVariable String id);
}