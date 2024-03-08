package com.ideate.idea_api_server.grade;

import lombok.Getter;

/**
 * <pre>
 * grade
 * Level
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-07 19:50
 * @desc :
 */

@Getter
public enum UserLevel {

    BASIC("일반"), VIP("우수"), HUMAN("휴먼"), BYE("탈퇴");

    private final String message;

    UserLevel(String message) {
        this.message = message;
    }
}
