package com.ideate.idea_api_server.repository;

import com.ideate.idea_api_server.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    // JpaRepository 내장 메서드 중 findById()를 지원한다. 따로 LogInfoRepository에 구현하지 않아도 알아서 JPA가 실행해준다.
}
