package com.ideate.idea_api_server.service;

import com.ideate.idea_api_server.entity.User;
import com.ideate.idea_api_server.repository.UserRepository;
import com.ideate.idea_api_server.dto.UserDto;
import com.ideate.idea_api_server.util.Encryption;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
@Slf4j
public class UserSerivce {

    private final UserRepository userRepository;

    public List<User> getFindAll() {
        return userRepository.findAll();

    }

    public Optional<User> getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);

    }

    public boolean saveUser(UserDto userDto) {

        UserDto userDto1 = new UserDto();

        userDto1.setUserId(userDto.getUserId());
        userDto1.setPassWord(Encryption.encryptSHA256(userDto.getPassWord())); // 요구사항 비밀번호는 암호화 한다.
        userDto1.setName(userDto.getName());
        userDto1.setNickName(userDto.getNickName());
        userDto1.setBirthDay(userDto.getBirthDay());
        userDto1.setPhoneNumber(userDto.getPhoneNumber());
        userDto1.setImage(userDto.getImage());

        log.info("userDto1 =" + userDto1);


        User entity = userRepository.save(userDto1.toUserEntity());
        return true;
    }

    public void deleteByUserID(String userId) {
        userRepository.deleteById(userId);
    }

}
