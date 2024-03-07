package com.ideate.idea_api_server.controller;

import com.ideate.idea_api_server.dto.LoginRequestDto;
import com.ideate.idea_api_server.entity.Users;
import com.ideate.idea_api_server.service.LoginService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService logInService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("logInRequestDto") LoginRequestDto logInRequestDto) {

        log.info("get Mapping test");
        return "login getMapping test";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRequestDto> userLogIn(@RequestBody @Valid LoginRequestDto loginRequestDto, BindingResult bindingResult) {

        log.info("postMapping LogIn test");

        log.info(String.valueOf(loginRequestDto));

        if (bindingResult.hasErrors()) {
            return new ResponseEntity("로그인 오류1", HttpStatus.UNAUTHORIZED); //요구사항 : 로그인 실패시 401 에러
        }

        log.info(String.valueOf(loginRequestDto));


        logInService.loginuser(loginRequestDto);
        logInService.updateLogInCountByDto(loginRequestDto);

        return new ResponseEntity(logInService.updateLogInCountByDto(loginRequestDto), HttpStatus.OK);

    }
}
