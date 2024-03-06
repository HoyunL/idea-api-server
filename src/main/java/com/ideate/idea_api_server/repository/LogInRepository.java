package com.ideate.idea_api_server.repository;

import com.ideate.idea_api_server.dto.LogInRequestDto;
import com.ideate.idea_api_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * repository
 * LoginRepository
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 18:18
 * @desc :
 */

@Repository
public interface LogInRepository extends JpaRepository<User,Long> {

    // 로그인 시 로그인 횟수 1씩 증가
    @Modifying
   @Query("update User p set p.logInCount = p.logInCount + 1 where p.userNo = :#{#dto.userNo}")
   int updateLogInCountByDto(@Param("dto") LogInRequestDto dto);



//   @Query("select u from User u where u.userId = :userId")
    Optional<User> findUserByUserId(String userId);
}
