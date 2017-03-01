package com.lxr.myreadbook.utils;

import android.content.Context;
import android.os.Environment;

import com.lxr.myreadbook.model.Constant;

import java.io.File;

/**
 * Created by Admin on 2017/3/1  15:43
 *
 * @desc
 */

public class FileUtils {

    public static String getChapterPath(String bookId, int chapter) {
        return Constant.PATH_TXT + bookId + File.separator + chapter + ".txt";
    }

    public static File getChapterFile(String bookId, int chapter) {
        File file = new File(getChapterPath(bookId, chapter));
        if (!file.exists())
            createFile(file);
        return file;
    }
    /**
     * 创建根缓存目录
     *
     * @return
     */
    public static String createRootPath(Context context) {
        String cacheRootPath = "";
        if (isSdCardAvailable()) {
            // /sdcard/Android/data/<application package>/cache
            cacheRootPath = context.getExternalCacheDir().getPath();
        } else {
            // /data/data/<application package>/cache
            cacheRootPath = context.getCacheDir().getPath();
        }
        return cacheRootPath;
    }

    /**
     * 递归创建文件夹
     *
     * @param file
     * @return 创建失败返回""
     */
    public static String createFile(File file) {
        try {
            if (file.getParentFile().exists()) {
                LogUtils.i("----- 创建文件" + file.getAbsolutePath());
                file.createNewFile();
                return file.getAbsolutePath();
            } else {
                createDir(file.getParentFile().getAbsolutePath());
                file.createNewFile();
                LogUtils.i("----- 创建文件" + file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 递归创建文件夹
     *
     * @param dirPath
     * @return 创建失败返回""
     */
    public static String createDir(String dirPath) {
        try {
            File file = new File(dirPath);
            if (file.getParentFile().exists()) {
                LogUtils.i("----- 创建文件夹" + file.getAbsolutePath());
                file.mkdir();
                return file.getAbsolutePath();
            } else {
                createDir(file.getParentFile().getAbsolutePath());
                LogUtils.i("----- 创建文件夹" + file.getAbsolutePath());
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirPath;
    }


    public static boolean isSdCardAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

}
