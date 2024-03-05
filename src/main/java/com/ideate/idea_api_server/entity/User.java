package com.ideate.idea_api_server.entity;

import com.ideate.idea_api_server.dto.UserDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import com.ideate.idea_api_server.util.BaseTime;

/**
 * <pre>
 * entity
 * User
 * </pre>
 *
 * @author : lee ho yun
 * @version : 1.0
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
@Table(name = "user")
public class User extends BaseTime {

    @Id @Length(min = 8)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo; // 고객아이디 같은경우 변경이 될 수 있어서 고객번호를 추가

    private String userId; // 고객아이디

    @Length(min = 8)
    private String passWord; // 고객 비밀번호

    @Column(nullable = true)
    private String name; // 고객 이름

    @ColumnDefault("")
    @Column(nullable = false)
    private String nickName; // 고객 별명

    @Column(nullable = true)
    private int birth; // 고객 생년원일

    @Column(nullable = true)
    @Length(min = 13)
    private int phoneNumber; // 고객 전화번호

    @Column(nullable = false)
    private String image; // 고객 이미지


    public UserDto toUserDto(){
        return UserDto.builder()
                .userId(userId)
                .passWord(passWord)
                .name(name)
                .nickName(nickName)
                .birth(birth)
                .phoneNumber(phoneNumber)
                .image(image)
                .build();
    }

}
