package com.reiser.androidlib.untils;

import android.content.res.Resources;

/**
 * Created by sunsharp on 16/9/12.
 */
public class DensityUtil {

//    public static int px2dip(Context context, float pxValue) {
//        final float scale = context.getResources().getDisplayMetrics().density;
//        return (int) (pxValue / scale + 0.5f);
//    }
//
//    public static int dip2px(Context context, float dpValue) {
//        final float scale = context.getResources().getDisplayMetrics().density;
//        return (int) (dpValue * scale + 0.5f);
//    }

    private static float density = -1F;
    private static int widthPixels = -1;
    private static int heightPixels = -1;

    public static float getDensity() {
        if (density <= 0F) {
            density = Resources.getSystem().getDisplayMetrics().density;
        }
        return density;
    }

    public static float dip2px(float dpValue) {
        return (int) (dpValue * getDensity() + 0.5f);
    }

    public static int px2dip(float pxValue) {
        return (int) (pxValue / getDensity() + 0.5f);
    }

    public static int getDeviceWidth() {
        if (widthPixels <= 0) {
            widthPixels = Resources.getSystem().getDisplayMetrics().widthPixels;
        }
        return widthPixels;
    }

    public static int getDeviceHeight() {
        if (heightPixels <= 0) {
            heightPixels = Resources.getSystem().getDisplayMetrics().heightPixels;
        }
        return heightPixels;
    }
}
