package com.ideate.idea_api_server.service;

import com.ideate.idea_api_server.dto.LogInRequestDto;
import com.ideate.idea_api_server.dto.UserDto;
import com.ideate.idea_api_server.entity.User;
import com.ideate.idea_api_server.repository.LogInRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
public class LogInService {

    private final LogInRepository logInRepository;

    public boolean LogInUser(LogInRequestDto logInRequestDto) {
        return logInRepository.existsById(logInRequestDto.getUserNo());
    }

}
