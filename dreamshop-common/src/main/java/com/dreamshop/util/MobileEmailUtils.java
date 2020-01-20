package com.dreamshop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * function:手机号邮箱验证工具
 *
 * @author DreamHeng
 * @date 2020/1/20
 */
public class MobileEmailUtils {
    public static boolean checkMobileIsOk(String mobile) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mobile);
        boolean isMatch = m.matches();
        return isMatch;
    }

    public static boolean checkEmailIsOk(String email) {
        boolean isMatch = true;
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            isMatch = false;
        }
        return isMatch;
    }
}