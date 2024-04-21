package ro.dragomiralin.usermanagementservice.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.dragomiralin.usermanagementservice.controller.handler.UserAlreadyExistsException;
import ro.dragomiralin.usermanagementservice.dto.UserContext;
import ro.dragomiralin.usermanagementservice.dto.UserDTO;
import ro.dragomiralin.usermanagementservice.entity.User;
import ro.dragomiralin.usermanagementservice.mapper.UserDTOMapper;
import ro.dragomiralin.usermanagementservice.repository.UserRepository;
import ro.dragomiralin.usermanagementservice.util.TestDataUtil;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserDTOMapper userDTOMapper;

    @Test
    @DisplayName("Test when create user successfully")
    public void testCreateUser() {
        User user = TestDataUtil.givenUser();
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(userDTOMapper.toUser(any(UserContext.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(TestDataUtil.givenUser());
        when(userDTOMapper.toUserDTO(any(User.class))).thenReturn(TestDataUtil.givenUserDTO());

        UserDTO result = userService.createUser(TestDataUtil.givenUserContext());

        verify(userRepository, times(1)).existsByEmail(anyString());
        verify(userDTOMapper, times(1)).toUser(any(UserContext.class));
        verify(userRepository, times(1)).save(any(User.class));
        verify(userDTOMapper, times(1)).toUserDTO(any(User.class));

        assertThat(result).isNotNull();
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    @DisplayName("Test when create user and user already exists")
    public void testWhenCreateUserAndUserAlreadyExists() {
        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        UserAlreadyExistsException existsException = assertThrows(UserAlreadyExistsException.class, () -> userService.createUser(TestDataUtil.givenUserContext()));
        assertThat(existsException.getMessage()).isEqualTo("User with email test@cc already exists");
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findById(anyString())).thenReturn(Optional.of(TestDataUtil.givenUser()));
        when(userDTOMapper.toUserDTO(any(User.class))).thenReturn(TestDataUtil.givenUserDTO());

        UserDTO result = userService.getUserById("1");

        verify(userRepository, times(1)).findById(anyString());
        verify(userDTOMapper, times(1)).toUserDTO(any(User.class));

        assertThat(result.getEmail()).isEqualTo(TestDataUtil.givenUser().getEmail());
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(anyString());

        userService.deleteUser("1");

        verify(userRepository, times(1)).deleteById(anyString());
    }

    @Test
    public void testUpdateUser() {
        when(userRepository.save(any(User.class))).thenReturn(TestDataUtil.givenUser());

        User result = userService.updateUser(TestDataUtil.givenUser());

        verify(userRepository, times(1)).save(any(User.class));

        assert result.getEmail().equals(TestDataUtil.givenUser().getEmail());
    }
}
