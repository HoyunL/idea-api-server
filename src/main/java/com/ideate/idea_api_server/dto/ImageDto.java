package com.ideate.idea_api_server.dto;

import com.ideate.idea_api_server.entity.Image;
import lombok.*;

/**
 * <pre>
 * dto
 * ImageDto
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-07 10:09
 * @desc :
 */

@NoArgsConstructor
@Getter
@Setter
public class ImageDto {

    private String originImageName;
    private String imageName;
    private String imagePath;

    public Image toEntity() {
        Image build = Image.builder()
                .originImageName(originImageName)
                .imageName(imageName)
                .imagePath(imagePath)
                .build();
        return build;
    }

    @Builder
    public ImageDto (String originImageName, String imageName,String imagePath) {
        this.originImageName = originImageName;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }

}
