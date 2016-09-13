package com.reiser.androidlib.untils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by sunsharp on 16/9/12.
 */
public class SaveUtil {
    /**
     * SharedPreferences写入
     * 这里的SharedPreferences只是作为展示,因为并不能读写字符串以外的类型
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    public static void putSharedPreferences(Context context, String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        //TODO 将value类型修改为Object 再判断类型
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * SharedPreferences读取
     *
     * @param context 上下文
     * @param key     键
     * @return 值
     */
    public static String getSharedPreferences(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, "");
    }


}
