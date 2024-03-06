package com.ideate.idea_api_server.util;

import java.security.MessageDigest;

/**
 * <pre>
 * util
 * Encryption
 * </pre>
 *
 * @author : lee ho yun
 * @version : x.x
 * @date : 2024-03-06 15:41
 * @desc :
 */
public class Encryption {

    public static String encryptSHA256(String s) {
        return encrypt(s, "SHA-256");
    }


/*    SHA-256 알고리즘이 MD5보다 강력하다고 합니다. 그래서 SHA-256 알고리즘으로 구현했습니다.  */

//    public static String encryptMD5(String s) {
//        return encrypt(s, "MD5");
//    }

    public static String encrypt(String s, String messageDigest) {
        try {
            MessageDigest md = MessageDigest.getInstance(messageDigest);
            byte[] passBytes = s.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digested.length; i++)
                sb.append(Integer.toString((digested[i] & 0xff) + 0x100, 16).substring(1));
            return sb.toString();
        } catch (Exception e) {
            return s;
        }
    }
}
