package com.ideate.idea_api_server.repository;

import com.ideate.idea_api_server.dto.UserDto;
import com.ideate.idea_api_server.entity.Users;
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
 * UserRepository
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-05 11:24
 * @desc :
 */

@Repository
public interface UserRepository extends JpaRepository<Users,String>{

    void save(UserDto userDto);

    List<Users> findAll();

    @Query("select u from Users u where u.userId = :userId")
    Optional<Users> findByUserId(@Param("userId") String userId);


    @Modifying
    @Query("delete from Users u where u.userId = :userId")
    void deleteById(@Param("userId") String userId);

}
