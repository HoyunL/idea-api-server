package com.ideate.repository;

import com.ideate.idea_api_server.dto.UserDto;
import com.ideate.idea_api_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface UserRepository extends JpaRepository<User,Long> {


    void save(UserDto userDto);


    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);


}
