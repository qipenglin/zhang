package cn.iccas.zhang;

import java.awt.*;

/**
 * Author  : qipenglin@meituan.com            <br/>
 * Date    : 2017/5/31                          <br/>
 * Time    : 下午6:08                          <br/>
 * ---------------------------------------    <br/>
 * Desc    :
 */
public class ColorUtils {

    public static Color getAvgColor(double val, double min, double max, int minColor, int maxColor) {
        int red = getAvgVal(val, min, max, (minColor & 0xff0000) >> 16, (maxColor & 0xff0000) >> 16);
        int green = getAvgVal(val, min, max, (minColor & 0x00ff00) >> 8, (maxColor & 0x00ff00) >> 8);
        int blue = getAvgVal(val, min, max, minColor & 0x0000ff, maxColor & 0x0000ff);
        System.out.println(red + ":" + green + ":" + blue);
        return new Color((red << 16) + (green << 8) + blue);
    }

    private static int getAvgVal(double val, double min, double max, int minValue, int maxValue) {
        double grade = (maxValue - minValue) / (max - min);
        double result = (val - min) * grade + minValue;
        return (int) result;
    }
}
