package com.ideate.idea_api_server.controller;

import com.ideate.idea_api_server.dto.LogInRequestDto;
import com.ideate.idea_api_server.service.LogInService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * controller
 * LoginController
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 18:15
 * @desc :
 */

@RestController
@AllArgsConstructor
@Slf4j
public class LoginController {

    private final LogInService logInService;


    @PostMapping("/login")
    public ResponseEntity<LogInRequestDto> userLogIn(@RequestBody @Valid LogInRequestDto logInRequestDto, BindingResult bindingResult) {

        log.info("postMapping LogIn test");
        log.info(String.valueOf(logInRequestDto));


        if (logInRequestDto.getUserId() != null || logInRequestDto.getPassWord() != null) {

            log.info(String.valueOf(logInRequestDto));

            logInService.LogInUser(logInRequestDto);
            logInService.updateLogInCountByDto(logInRequestDto);

            return new ResponseEntity(logInService.LogInUser(logInRequestDto), HttpStatus.OK);
        } else {
            return new ResponseEntity("로그인 오류2", HttpStatus.UNAUTHORIZED); //요구사항 : 로그인 실패시 401 에러
        }
    }
}
