package com.ideate.idea_api_server.InterfaceImpl;

import com.ideate.idea_api_server.entity.Users;
import com.ideate.idea_api_server.repository.UserCustomRepository;
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
 * @desc :
 */
@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {




    @Override
    public List<Users> findByIdAndNameAndPhoneNumber(String userId, String name, String phoneNumber) {
        return null;
    }
}
