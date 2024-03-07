package com.ideate.idea_api_server.entity;

import com.ideate.idea_api_server.util.BaseTime;
import jakarta.persistence.*;
import lombok.*;

/**
 * <pre>
 * entity
 * UserInfo
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-06 11:25
 * @desc :
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
@Entity
@Table(name = "userInfo")
public class UserInfo extends BaseTime {

    @Id
    private String userId; // 고객아이디

}
