package com.ideate.idea_api_server.InterfaceImpl;

import com.ideate.idea_api_server.dto.UserDto;
import com.ideate.idea_api_server.entity.QUsers;
import com.ideate.idea_api_server.repository.UserCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * <pre>
 * interfaceImpl
 * 1
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-08 10:35
 * @desc : 구현중
 */
@RequiredArgsConstructor
public class UserCustomImpl implements UserCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QUsers qUsers = QUsers.users;


    @Override
    public List<UserDto> getUserInfor() {
        //return jpaQueryFactory.select(qUsers.userId,qUsers.name, qUsers.phoneNumber).from(qUsers).fetch();
        return jpaQueryFactory.select(
                Projections.bean(UserDto.class, qUsers.userId, qUsers.name, qUsers.phoneNumber)).from(qUsers).fetch();
    }
}
