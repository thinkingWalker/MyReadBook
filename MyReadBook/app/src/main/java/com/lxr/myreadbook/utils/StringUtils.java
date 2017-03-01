package com.lxr.myreadbook.utils;

/**
 * Created by Admin on 2017/3/1  15:54
 *
 * @desc
 */

public class StringUtils {

    public static String creatAcacheKey(Object... param) {
        String key = "";
        for (Object o : param) {
            key += "-" + o;
        }
        return key.replaceFirst("-","");
    }

}
