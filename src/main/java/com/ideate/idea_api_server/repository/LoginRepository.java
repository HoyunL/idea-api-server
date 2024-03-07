package com.ideate.idea_api_server.repository;

import com.ideate.idea_api_server.dto.LoginRequestDto;
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
 * LoginRepository
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 18:18
 * @desc :
 */

@Repository
public interface LoginRepository extends JpaRepository<Users,Long> {

    // 로그인 시 로그인 횟수 1씩 증가
   @Modifying
   @Query("update Users p set p.logInCount = p.logInCount + 1 where p.userId = :#{#dto.userId}")
   int updateLogInCountByDto(@Param("dto") LoginRequestDto dto);



//   @Query("select u from User u where u.userId = :userId")
    Optional<Users> findUserByUserId(String userId);
}
