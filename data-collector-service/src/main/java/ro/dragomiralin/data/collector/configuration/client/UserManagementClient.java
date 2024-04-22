package ro.dragomiralin.data.collector.configuration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ro.dragomiralin.data.collector.configuration.FeignClientInterceptor;
import ro.dragomiralin.data.collector.dto.UserDTO;

@FeignClient(value = "user-management", url = "${user-management-service.base-url}", configuration = FeignClientInterceptor.class)
public interface UserManagementClient {

    @GetMapping("/users")
    UserDTO getUser();

}
