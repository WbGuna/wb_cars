package br.com.wbcars.util;

import org.apache.commons.codec.digest.DigestUtils;

public class CriptografiaUtil {
    public static String sha256(String valor) {
        return DigestUtils.sha256Hex(valor);
    }
}
