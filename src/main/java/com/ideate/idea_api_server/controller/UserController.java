package com.ideate.idea_api_server.controller;

import com.ideate.idea_api_server.entity.User;
import com.ideate.idea_api_server.service.UserSerivce;
import com.ideate.idea_api_server.dto.UserDto;
import com.ideate.idea_api_server.entity.User;
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


    @GetMapping("/user")
    public String getFindAllUser() {

        log.info("getMapping test");

        List<User> findAll = userSerivce.getFindAll();

        log.info(findAll.toString());

        return "OK";

    }

    @GetMapping("/user/{id}")
    public String findByBoardId(@PathVariable(name = "id") Long id) {

        Optional<User> userById = userSerivce.getUserById(id);
        log.info("userById : " + userById.toString());

        return "게시물 1건 조회 성공 (GET)";
    }


    @PostMapping("/user/{id}")
    public String postFindByBoardId(@PathVariable(name = "id") Long id) {

        if (id.equals("") || id == null) {
            return "게시물 번호가 존재하지 않습니다.(post)";
        }

        userSerivce.getUserById(id);
        return "게시물 1건 조회 성공 (POST)";
    }


    @PostMapping("/user")
    public ResponseEntity<?> postBoard(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {

        log.info("postMapping test");
        log.info(String.valueOf(userDto));

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("회원등록 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (userSerivce.saveUser(userDto)) {
            return new ResponseEntity<>("회원등록 성공", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("회원등록 오류2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable(name = "id") Long id,
                                         @RequestBody @Valid UserDto userDto, BindingResult bindingResult) {

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

    @DeleteMapping("/user/delete/{id}")
    public String deleteBoard(@PathVariable(name = "id") Long id) {

        userSerivce.delete(id);
        return "delete ok";
    }
}
