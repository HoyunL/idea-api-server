package com.ideate.idea_api_server.dto;

import com.ideate.idea_api_server.entity.User;
import com.ideate.idea_api_server.util.BaseTime;
import lombok.*;
import org.apache.coyote.http11.upgrade.UpgradeProcessorInternal;

/**
 * <pre>
 * dto
 * LogInRequestDto
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-06 18:16
 * @desc :
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LogInRequestDto extends BaseTime {

    private Long userNo; // 고객번호

    private String userId; // 고객아이디

    private String passWord; // 고객 비밀번호

    private int logInCount; // 로그인 횟수
}
