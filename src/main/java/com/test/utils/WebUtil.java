package com.test.utils;

import org.junit.Test;

/**
 * @ClassName: WebUtil
 * @Description: 网络工具类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/21 12:21
 */
public class WebUtil {

    // 获取URL最后的数字参数
    public static int getPathId(String string) {
        int a  = 0;//返回数字赋初值0
        int tem =1;
        char[] b = string.toCharArray();
        for (int i = b.length-1; i > 0; i--) {
            if(b[i]!='/'&&Character.isDigit(b[i]))
            {
                String str=String.valueOf(b[i]);
                a +=  Integer.valueOf(str)*tem;
                tem*=10;
            }
            else
                break;
        }
        if(a==0){
            return -1;
        }
        return a;//返回最后的数字
    }


    @Test
    public void test() {
        System.out.println(WebUtil.getPathId("https://blog.csdn.net/weixin_41547486/article/details/81266697"));
    }


}
