package cn.iccas.zhang;

import javax.swing.*;
import java.awt.*;

/**
 * Author  : qipenglin@meituan.com            <br/>
 * Date    : 2017/5/31                          <br/>
 * Time    : 下午5:42                          <br/>
 * ---------------------------------------    <br/>
 * Desc    :
 */
public class SquarePanel extends JPanel {


    public SquarePanel(Color color, int x, int y) {
        super();
        int px = Constant.EDGE + x * (Constant.SQUARE_SIZE + Constant.SQUARE_INTERVAL);
        int py = Constant.EDGE + y * (Constant.SQUARE_SIZE + Constant.SQUARE_INTERVAL);
        setBounds(px, py, Constant.SQUARE_SIZE, Constant.SQUARE_SIZE);
        setBackground(color);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaintMode();
        g2.setColor(new Color(Constant.COLOR_BORDER));
        g2.setStroke(new BasicStroke(15.0f));
        g2.drawRect(0, 0, getWidth(), getHeight());
    }
}
