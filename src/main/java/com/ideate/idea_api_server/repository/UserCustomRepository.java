package com.ideate.idea_api_server.repository;

import com.ideate.idea_api_server.entity.Users;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

/**
 * <pre>
 * repository
 * UserCustomRepository
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-08 10:31
 * @desc :
 */
public interface UserCustomRepository {



    List<Users> findByIdAndNameAndPhoneNumber(String userId, String name, String phoneNumber);
}
