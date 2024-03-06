package com.ideate.idea_api_server.service;

import com.ideate.idea_api_server.entity.UserInfo;
import com.ideate.idea_api_server.repository.UserInfoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <pre>
 * service
 * LogInfoService
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-06 11:27
 * @desc :
 */
@Service
@Transactional
@AllArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public Optional<UserInfo> getUserInfoById(Long id){
        return userInfoRepository.findById(id);
    }


}
