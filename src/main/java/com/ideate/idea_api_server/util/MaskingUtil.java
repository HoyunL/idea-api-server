package com.ideate.idea_api_server.util;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * util
 * MaskingUtil
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-08 09:32
 * @desc :
 */
@Slf4j
public class MaskingUtil {

    /**
     * 핸드폰번호 masking 후 리턴<br>
     * 변환 실패시 입력값 그대로 리턴
     */
    public static String maskingPhoneNumber(String phoneNumber) {
        try {
            if (StringUtils.isEmpty(phoneNumber)) {
                return phoneNumber;
            }

            phoneNumber = phoneNumber.replaceAll("[^0-9]", ""); // 숫자만 추출

            if (!(phoneNumber.length() == 11)) {
                return phoneNumber;
            }

            if (phoneNumber.length() == 11) {
                return phoneNumber.substring(0, 3) + "*" + phoneNumber.substring(4, 5) + "***" + phoneNumber.substring(8, 11);
            }
        } catch (Exception e) {
            log.error(e.toString());
        }

        return phoneNumber;
    }
}
