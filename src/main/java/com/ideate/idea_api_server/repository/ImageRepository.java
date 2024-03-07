package com.ideate.idea_api_server.repository;

import com.ideate.idea_api_server.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * repository
 * ImageRepository
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-07 10:13
 * @desc :
 */

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {

}
