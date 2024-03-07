package com.ideate.idea_api_server.dto;

import com.ideate.idea_api_server.util.BaseTime;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

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


@Data
public class LoginRequestDto {

    @NotEmpty
    private String userId; // 고객아이디

    @NotEmpty
    private String passWord; // 고객 비밀번호
}
