package com.ideate.idea_api_server.service;

import com.ideate.idea_api_server.dto.ImageDto;
import com.ideate.idea_api_server.repository.ImageRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * service
 * ImageRepository
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-07 10:15
 * @desc : 구현중
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {

    private final ImageRepository imageRepository;

    @Transactional
    public Long saveImage(ImageDto imageDto) {
        return imageRepository.save(imageDto.toEntity()).getImageNo();
    }


}
