package ro.dragomiralin.usermanagementservice.mapper;

import org.mapstruct.Mapper;
import ro.dragomiralin.usermanagementservice.dto.UserContext;
import ro.dragomiralin.usermanagementservice.dto.UserDTO;
import ro.dragomiralin.usermanagementservice.entity.User;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);

    User toUser(UserContext userContext);
}
