package com.ideate.idea_api_server.service;

import com.ideate.idea_api_server.dto.LoginRequestDto;
import com.ideate.idea_api_server.entity.Users;
import com.ideate.idea_api_server.repository.LoginRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <pre>
 * service
 * LogInService
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 18:20
 * @desc :
 */

@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class LoginService {

    private final LoginRepository logInRepository;

    public Optional<Users> loginuser(LoginRequestDto loginRequestDto) {

        log.info(String.valueOf(loginRequestDto));

        return logInRepository.findUserByUserId(loginRequestDto.getUserId());
    }

    public int updateLogInCountByDto(LoginRequestDto logInRequestDto) {

        log.info(String.valueOf(logInRequestDto));

        return logInRepository.updateLogInCountByDto(logInRequestDto);
    }

}
