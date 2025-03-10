package sim_otp.ak.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sim_otp.ak.common.Common;
import sim_otp.ak.domain.entity.User;
import sim_otp.ak.domain.request.UserCreateRequest;
import sim_otp.ak.error.EntityNotExistException;
import sim_otp.ak.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User createNewUser(UserCreateRequest request){
        User user = User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(this.passwordEncoder.encode(request.getPassword()))
            .enabled(true)
            .role(request.getRole())
            .build();
        return this.userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
    public User getUserByUserName(String username) {
        return this.userRepository.findByEmail(username)
            .orElseThrow(() -> new EntityNotExistException(Common.USER_NOT_FOUND));
    }
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }
    public User getUserByRefreshToken(String refresh_token) {
        return this.userRepository.findByRefreshToken(refresh_token)
        .orElseThrow(() -> new EntityNotExistException(Common.REFRESH_TOKEN_NOT_FOUND));
    }
}
