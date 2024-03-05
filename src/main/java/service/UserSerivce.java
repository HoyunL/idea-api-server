package service;

import dto.UserDto;
import entity.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * serivce
 * UserService
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 11:22
 * @desc :
 */

@Service
@Transactional
//@RequiredArgsConstructor
@AllArgsConstructor
public class UserSerivce {

    private final UserRepository userRepository;

    public List<User> getFindAll() {
        return userRepository.findAll();

    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);

    }

    public boolean saveUser(UserDto userDto) {
        User entity = userRepository.save(userDto.toUserEntity());
        return true;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
