package com.ideate.idea_api_server.repository;

import com.ideate.idea_api_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
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


}
