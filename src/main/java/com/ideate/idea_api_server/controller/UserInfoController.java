package com.ideate.idea_api_server.controller;

import com.ideate.idea_api_server.entity.Users;
import com.ideate.idea_api_server.grade.UserLevel;
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

        @GetMapping("/userInfo/{userId}")
        public Optional<Users> selectUserInfoById(@PathVariable(name = "userId") String userId){

            log.info(userId);

            Optional<Users> selecteduserInfo = userInfoService.getUserInfoById(userId);

            log.info(String.valueOf(selecteduserInfo));
            return selecteduserInfo;
        }

}
