package com.ideate.idea_api_server.dto;

import com.ideate.idea_api_server.util.BaseTime;
import jakarta.persistence.OneToMany;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserInfoDto extends BaseTime {

    private Long userNo; // 고객번호


}
