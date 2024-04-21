package ro.dragomiralin.usermanagementservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomiralin.usermanagementservice.controller.handler.UserAlreadyExistsException;
import ro.dragomiralin.usermanagementservice.controller.handler.UserNotFoundException;
import ro.dragomiralin.usermanagementservice.dto.UserContext;
import ro.dragomiralin.usermanagementservice.dto.UserDTO;
import ro.dragomiralin.usermanagementservice.entity.User;
import ro.dragomiralin.usermanagementservice.mapper.UserDTOMapper;
import ro.dragomiralin.usermanagementservice.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDTOMapper userDTOMapper;
    private final UserRepository userRepository;

    public UserDTO createUser(UserContext userContext) {
        if (userRepository.existsByEmail(userContext.getEmail())) {
            throw new UserAlreadyExistsException(UserAlreadyExistsException.Messages.userAlreadyExistsMessage(userContext.getEmail()));
        }

        User user = userRepository.save(userDTOMapper.toUser(userContext));
        log.info("User with email {} has been created.", user.getEmail());

        return userDTOMapper.toUserDTO(user);
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userDTOMapper::toUserDTO)
                .orElseThrow(() -> new UserNotFoundException(UserNotFoundException.Messages.userNotFoundMessage(email)));
    }

    public UserDTO getUserById(String id) {
        return userRepository.findById(id)
                .map(userDTOMapper::toUserDTO)
                .orElseThrow(() -> new UserNotFoundException(UserNotFoundException.Messages.USER_NOT_FOUND));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
        log.info("User has been deleted with id: {}", id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
