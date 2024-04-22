package ro.dragomiralin.subscription.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ro.dragomiralin.subscription.configuration.FeignClientInterceptor;
import ro.dragomiralin.subscription.dto.UserDTO;

@FeignClient(value = "user-management", url = "${user-management-service.base-url}", configuration = FeignClientInterceptor.class)
public interface UserManagementClient {

    @GetMapping("/users")
    UserDTO getUser();

}
