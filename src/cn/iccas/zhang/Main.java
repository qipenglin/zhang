package cn.iccas.zhang;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Author  : qipenglin@meituan.com            <br/>
 * Date    : 2017/5/31                          <br/>
 * Time    : 下午4:31                          <br/>
 * ---------------------------------------    <br/>
 * Desc    :
 */
public class Main {

    public static void main(String[] args) {

        JPanel mPanel = new JPanel();
        mPanel.setSize(Constant.WIDTH, Constant.HEIGHT);
        mPanel.setBackground(new Color(0xffffff));
        mPanel.setLayout(null);

        double[] data = {97.43, 96.58, 51, 47, 96.55, 52, 96.73, 94.29, 105.6};
        for (int i = 0; i < 9; i++) {
            Color color = ColorUtils.getAvgColor(data[i], Constant.MIN, Constant.MAX,
                                                 Constant.COLOR_BLUE, Constant.COLOR_RED);
            SquarePanel squarePanel = new SquarePanel(color, i % 3, i / 3);
            mPanel.add(squarePanel);
        }

        JPanel colorBar = new ColorBar();
        int px = Constant.EDGE + 3 * (Constant.SQUARE_SIZE + Constant.SQUARE_INTERVAL) + 20;
        colorBar.setBounds(px, Constant.EDGE, 50, 1240);
        mPanel.add(colorBar);

        try {
            generateImage(mPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateImage(JPanel jpanel) throws Exception {
        BufferedImage image = new BufferedImage(jpanel.getWidth(), jpanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        jpanel.paint(g2);
        File pic = new File("/Users/QiPeng/jpanel.jpg");
        if (!pic.exists()) {
            pic.createNewFile();
        }
        ImageIO.write(image, "jpeg", pic);
    }
}
