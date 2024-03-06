package com.ideate.idea_api_server.controller;

import com.ideate.idea_api_server.entity.UserInfo;
import com.ideate.idea_api_server.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * <pre>
 * controller
 * UserInfoController
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-06 11:23
 * @desc :
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserInfoController {

        private final UserInfoService userInfoService;

        @GetMapping("/userInfo/{id}")
        public Optional<UserInfo> selectUserInfoById(@PathVariable(name = "id") Long id){

            Optional<UserInfo> selecteduserInfo = userInfoService.getUserInfoById(id);
            log.info(String.valueOf(selecteduserInfo));
            return selecteduserInfo;
        }

}
