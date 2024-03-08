package com.ideate.idea_api_server.entity;

import com.ideate.idea_api_server.dto.UserDto;
import com.ideate.idea_api_server.grade.UserLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import com.ideate.idea_api_server.util.BaseTime;

/**
 * <pre>
 * entity
 * User
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 10:22
 * @desc : 고객정보 테이블을 의미합니다.
 */
@Builder // dto를 파라메터로 받아온 필드값들을 entity에 넘겨주기 위해서 사용했습니다.
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
@Entity
@Table(name = "users")
public class Users extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_no")
    private Long userNo; // 고객아이디 같은경우 변경이 될 수 있어서 고객번호를 추가

    @Column(updatable = false)
    private String userId; // 고객아이디

    @NotBlank
    private String passWord; // 고객 비밀번호1

    @Column(nullable = false)
    private String name; // 고객 이름1

    @Column(nullable = true, updatable = false)
    private String nickName; // 고객 별명

    @Column(nullable = false, updatable = false)
    private String birthDay; // 고객 생년원일

    @Column
    private String phoneNumber; // 고객 전화번호1

    @Column(nullable = true, updatable = false)
    private String image; // 고객 이미지1

    @ColumnDefault("0")
    private int logInCount;

    @Enumerated(value = EnumType.STRING)
    @Column
    private UserLevel userLevel;

    public UserDto toUserDto() {
        return UserDto.builder()
                .userNo(userNo)
                .userId(userId)
                .passWord(passWord)
                .name(name)
                .nickName(nickName)
                .birthDay(birthDay)
                .phoneNumber(phoneNumber)
                .image(image)
                .build();
    }
}
