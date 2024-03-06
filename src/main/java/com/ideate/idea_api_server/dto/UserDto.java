package com.ideate.idea_api_server.dto;

import com.ideate.idea_api_server.entity.User;
import lombok.*;
import com.ideate.idea_api_server.util.BaseTime;

/**
 * <pre>
 * dto
 * UserDto
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 11:02
 * @desc : 고객정보(필드값)를 전달하기 위해 생성.
 */
@Getter
@Setter // 별명 디폴트 값을 controller 에서 설정하기 위해 setter 추가
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto extends BaseTime {

    private Long userNo; // 고객번호

    private String userId; // 고객아이디

    private String passWord; // 고객 비밀번호

    private String name; // 고객 이름

    private String nickName; // 고객 별명

    private String birthDay; // 고객 생년원일

    private String phoneNumber; // 고객 전화번호

    private String image; // 고객 이미지

    private int logInCount; // 로그인 횟수


    /**
     * <pre>
     * 1. 개요 : 고객정보 service 레이어 단계에서 User 테이블에 고객정보를 넘겨주기 위해 사용한다.
     * 2. 처리내용 : controller에서 부터 받아온 고객정보를 user table에 넘겨주기 준다.
     * </pre>
     * @Method Name: toUserEntity
     * @date : 2024.03.05
     * @author : lee ho yun
     * @history :
     * ----------------------------------------------------
     --------------
     * 변경일 작성자 변경내역
     * ----------------------------------------------------
     --------------
     * 2024.03.05 lee ho yun 최초작성
      * ----------------------------------------------------
     --------------
     */
    public User toUserEntity(){
        return User.builder()
                .userId(userId)
                .passWord(passWord)
                .name(name)
                .nickName(nickName)
                .birthDay(birthDay)
                .phoneNumber(phoneNumber)
                .image(image)
                .logInCount(logInCount)
                .build();
    }
}
