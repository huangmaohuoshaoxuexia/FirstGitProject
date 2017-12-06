package com.jiaxufei.framework.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-30 下午8:58<br/>
 * <p>
 * <p>
 * 高效缓冲bitmap
 * </p>
 */
public class BitmapUtil {
    /**
     * 获取要显示的图片(大小比原来的少一位数)
     *
     * @param filePath 图片文件路径
     * @param pixelW   要显示的宽
     * @param pixelH   要显示的高
     * @return
     */
    public static Bitmap ratio(String filePath, int pixelW, int pixelH) {
        BitmapFactory.Options newOptions = new BitmapFactory.Options();
        newOptions.inJustDecodeBounds = true;//只加载图片的宽和高，不在家真正的内容
        newOptions.inPreferredConfig = Bitmap.Config.RGB_565;//消耗内存小的配置
        //预加载之后既可以获取宽和高
        BitmapFactory.decodeFile(filePath, newOptions);
        int originalW = newOptions.outWidth;
        int originalH = newOptions.outHeight;

        //采样
        newOptions.inSampleSize = getSampleSize(originalW, originalH, pixelW, pixelH);
        newOptions.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, newOptions);
    }

    /**
     * 计算采样率，意思是拆解
     *
     * @param originalW
     * @param originalH
     * @param pixelW
     * @param pixelH
     * @return
     */

    private static int getSampleSize(int originalW, int originalH, int pixelW, int pixelH) {
        int simpleSize = 1;
        if (originalW > originalH && originalW > pixelW) {
            simpleSize = originalW / pixelW;
        } else if (originalW < originalH && originalH > pixelH) {
            simpleSize = originalH / pixelH;
        }
        if (simpleSize <= 0) {
            simpleSize = 1;
        }
        return simpleSize;
    }
}
