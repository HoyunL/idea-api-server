package com.ideate.idea_api_server.repository;

import com.ideate.idea_api_server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <pre>
 * repository
 * LogInfoRepository
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-06 11:30
 * @desc :
 */

@Repository
public interface UserInfoRepository extends JpaRepository<Users, String> {

    @Query("select u.name from Users u where u.userId = :userId")
    Optional<Users> selectedByUserInfo(@Param("userId") String userId);
}
