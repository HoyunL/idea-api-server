package com.ideate.idea_api_server.service;

import com.ideate.idea_api_server.entity.Users;
import com.ideate.idea_api_server.repository.UserCustomRepository;
import com.ideate.idea_api_server.repository.UserRepository;
import com.ideate.idea_api_server.dto.UserDto;
import com.ideate.idea_api_server.util.Encryption;
import com.ideate.idea_api_server.util.MaskingUtil;
import com.querydsl.core.Tuple;
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
    //private final UserCustomRepository userCustomRepository;

    public List<Users> getFindAll() {
        return userRepository.findAll();
    }


//    public List<UserDto> getFindWhere(){
//        return userCustomRepository.getUserInfor();
//    }


    public Optional<Users> getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);

    }

    public boolean saveUser(UserDto userDto) {

        UserDto userDto1 = new UserDto();

        userDto1.setUserId(userDto.getUserId());
        userDto1.setPassWord(Encryption.encryptSHA256(userDto.getPassWord())); // 비밀번호는 암호화
        userDto1.setName(userDto.getName());
        userDto1.setNickName(userDto.getNickName());
        userDto1.setBirthDay(userDto.getBirthDay());
        userDto1.setPhoneNumber(MaskingUtil.maskingPhoneNumber(userDto.getPhoneNumber())); // 전화번호 마스킹 처리
        userDto1.setImage(userDto.getImage());

        log.info("userDto1 =" + userDto1);


        Users entity = userRepository.save(userDto1.toUserEntity());
        return true;
    }

    public void deleteByUserID(String userId) {
        userRepository.deleteById(userId);
    }

}
