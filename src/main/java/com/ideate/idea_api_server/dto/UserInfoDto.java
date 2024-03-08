package com.ideate.idea_api_server.dto;

import com.ideate.idea_api_server.grade.UserLevel;
import com.ideate.idea_api_server.util.BaseTime;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

/**
 * <pre>
 * dto
 * UserInfoDto
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-06 11:26
 * @desc :
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserInfoDto extends BaseTime {

    @NotEmpty
    private String userId; // 고객아이디

    @NotEmpty
    private UserLevel userLevel; // 고객등급

}
