package com.ideate.idea_api_server.controller;

import com.ideate.idea_api_server.entity.Users;
import com.ideate.idea_api_server.service.UserSerivce;
import com.ideate.idea_api_server.dto.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * controller
 * UserController
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 13:15
 * @desc :
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserSerivce userSerivce;

    @GetMapping("/users")
    public List<Users> getFindAllUser() {

        log.info("getMapping test");

        List<Users> findAll = userSerivce.getFindAll();

        log.info(findAll.toString());

        return findAll;

    }

    @GetMapping("/users/{userId}")
    public Optional<Users> findByUserId(@PathVariable(name = "userId") String userId) {

//        if (id.equals("") || id == null) {
//            return "게시물 번호가 존재하지 않습니다.(GET)";
//        }

        Optional<Users> userByUserId = userSerivce.getUserByUserId(userId);
        log.info("userById : " + userByUserId.toString());

        return userByUserId;
    }

    @PostMapping("/users/{userId}")
    public String postFindByUserId(@PathVariable(name = "userId") String userId) {

        if (userId.equals("") || userId == null) {
            return "고객정보 존재하지 않습니다.(POST)";
        }

        Optional<Users> userByUserInfo = userSerivce.getUserByUserId(userId);

        return "고객정보 1건 조회 성공 (POST)";
    }

    @PostMapping("/users")
    public ResponseEntity<?> InsertUserByDto(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {

        log.info("postMapping test");
        log.info(String.valueOf(userDto));

        if (userDto.getNickName() == null || userDto.getNickName() == "") {
            userDto.setNickName(userDto.getName()); // 요구사항 : 닉네임이 없을 경우, 이름을 디폴트 값으로 설정한다.
        }

        log.info(String.valueOf("bindingResult.hasErrors()"+bindingResult.hasErrors()));

        if (bindingResult.hasErrors()) {

            return new ResponseEntity<>("회원등록 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (userSerivce.saveUser(userDto)) {
            return new ResponseEntity<>("회원등록 성공", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("회원등록 오류2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/update")
    public ResponseEntity<?> updateBoard(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {

        if (userDto.getUserId() == null) {
            return new ResponseEntity<>("userId is null errors", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("userUpdate fail1", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (userSerivce.saveUser(userDto)) {
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("fail2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/delete/{userId}")
    public String deleteUserByUserId(@PathVariable(name = "userId") String userId) {
        userSerivce.deleteByUserID(userId);
        return "delete ok";
    }
}
