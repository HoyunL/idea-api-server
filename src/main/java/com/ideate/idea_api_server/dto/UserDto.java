package com.ideate.idea_api_server.dto;

import com.ideate.idea_api_server.entity.Users;
import com.querydsl.core.annotations.QueryProjection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 8, message = " 아이디는 최소 8자리 입니다.")
    private String userId; // 고객아이디

    @NotBlank
    @Size(min = 8, message = "최소 8글자 이상 입력하세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", message = "비밀번호는 대/소문자, 숫자, 특수문자를 포함해야 합니다.")
    private String passWord; // 고객 비밀번호

    private String name; // 고객 이름

    private String nickName; // 고객 별명

    private String birthDay; // 고객 생년원일
    @NotBlank
    @Size(min = 13, message = "휴대폰 번호는 최소 13자리 입니다.")
    private String phoneNumber; // 고객 전화번호

    private String image; // 고객 이미지

    private int logInCount; // 로그인 횟수


     @QueryProjection
     public UserDto(String userId, String name, String phoneNumber) {
     this.userId = userId;
     this.name = name;
     this.phoneNumber = phoneNumber;
     }

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
    public Users toUserEntity(){
        return Users.builder()
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
