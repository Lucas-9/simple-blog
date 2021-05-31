package top.lucas9.blog.utils;

import cn.hutool.crypto.SecureUtil;

public class EncryptUtil {
    public static String encryptPassword(String original, String uuid) {
        String password = SecureUtil.md5(original+uuid);
        return password;
    }
}
