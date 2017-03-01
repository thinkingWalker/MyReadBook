package com.lxr.myreadbook.manager;

import com.lxr.myreadbook.model.Constant;
import com.lxr.myreadbook.utils.SharedPreferencesUtil;

/**
 * Created by Admin on 2017/3/1  15:51
 *
 * @desc
 */

public class SettingManager  {
    private volatile static SettingManager manager;

    public static SettingManager getInstance() {
        return manager != null ? manager : (manager = new SettingManager());
    }

    private String getChapterKey(String bookId) {
        return bookId + "-chapter";
    }

    private String getStartPosKey(String bookId) {
        return bookId + "-startPos";
    }

    private String getEndPosKey(String bookId) {
        return bookId + "-endPos";
    }
    public boolean isNoneCover() {
        return SharedPreferencesUtil.getInstance().getBoolean("isNoneCover", false);
    }
    /**
     * 获取上次阅读章节及位置
     *
     * @param bookId
     * @return
     */
    public int[] getReadProgress(String bookId) {
        int lastChapter = SharedPreferencesUtil.getInstance().getInt(getChapterKey(bookId), 1);
        int startPos = SharedPreferencesUtil.getInstance().getInt(getStartPosKey(bookId), 0);
        int endPos = SharedPreferencesUtil.getInstance().getInt(getEndPosKey(bookId), 0);

        return new int[]{lastChapter, startPos, endPos};
    }

    /**
     * 获取用户选择性别
     *
     * @return
     */
    public String getUserChooseSex() {
        return SharedPreferencesUtil.getInstance().getString("userChooseSex", Constant.Gender.MALE);
    }

    public boolean isUserChooseSex() {
        return SharedPreferencesUtil.getInstance().exists("userChooseSex");
    }

}
