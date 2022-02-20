package com.test.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @ClassName: TokenUtil
 * @Description: 处理token的工具类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/19 14:58
 */
public class TokenUtil {


    // 生成token
    public static String generateToken(String str) {
        return StringUtils.reverse(str);
    }

    // 解析token
    public static String decodeToken(String str) {
        str = StringUtils.reverse(str);
        String[] split = StringUtils.split(str, ":");
        return split[0];
    }

    @Test
    public void testEncode() {
        System.out.println(TokenUtil.generateToken("Hilda" + ":" + "1234"));
        System.out.println(TokenUtil.decodeToken(TokenUtil.generateToken("Hilda" + ":" + "1234")));
    }
}
