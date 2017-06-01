package cn.iccas.zhang;

import javax.swing.*;
import java.awt.*;

/**
 * Author  : qipenglin@meituan.com            <br/>
 * Date    : 2017/5/31                          <br/>
 * Time    : 下午6:24                          <br/>
 * ---------------------------------------    <br/>
 * Desc    :
 */
public class ColorBar extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setPaintMode();
        for (int i = 0; i < getHeight(); i++) {
            g.setColor(ColorUtils.getAvgColor(i, 0, getHeight(), Constant.COLOR_RED, Constant.COLOR_BLUE));
            g.drawLine(0, i, getWidth(), i);
        }
    }
}
