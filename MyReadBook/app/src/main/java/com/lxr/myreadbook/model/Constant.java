package com.lxr.myreadbook.model;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.StringDef;

import com.lxr.myreadbook.utils.AppUtils;
import com.lxr.myreadbook.utils.FileUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Admin on 2017/3/1  15:32
 *
 * @desc
 */

public class Constant {
    public static final String IMG_BASE_URL = "http://statics.zhuishushenqi.com";

    public static final String API_BASE_URL = "http://api.zhuishushenqi.com";
    public static String PATH_DATA = FileUtils.createRootPath(AppUtils.getAppContext()) + "/cache";
    public static final String SUFFIX_TXT = ".txt";
    public static final String SUFFIX_PDF = ".pdf";
    public static final String SUFFIX_EPUB = ".epub";
    public static final String SUFFIX_ZIP = ".zip";
    public static final String SUFFIX_CHM = ".chm";
    public static String PATH_TXT = PATH_DATA + "/book/";

    public static String PATH_EPUB = PATH_DATA + "/epub";

    public static String PATH_CHM = PATH_DATA + "/chm";

    @StringDef({
            Gender.MALE,
            Gender.FEMALE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Gender {
        String MALE = "male";

        String FEMALE = "female";
    }
}
