package com.fengzz.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5 util
 *
 * @author Fengzz
 * @date 2022/10/1 23:47
 * <p>
 * ******* Think twice, code once. *******
 */

public class Md5Util {

    private static final String ALGORITHM_MD5 = "md5";


    /**
     * md5 encrypt
     * @param text
     * @return
     */
    public static String md5(String text) {
        byte[] digest;
        try {
            digest = MessageDigest.getInstance(ALGORITHM_MD5).digest(text.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String md5Code = new BigInteger(1, digest).toString(16);

        for (int i = 0; i < 32 - md5Code.length(); i++) {
            md5Code = "0" + md5Code;
        }
        return md5Code;
    }
}
