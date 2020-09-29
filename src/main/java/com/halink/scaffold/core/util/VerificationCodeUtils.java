package com.halink.scaffold.core.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 获取验证码
 *
 * @author halink
 */
public class VerificationCodeUtils {

    private static final int CAPTCHA_WIDTH = 100;
    private static final int CAPTCHA_HEIGHT = 35;
    private static final int NUMBER_CNT = 4;
    private static VerificationCodeUtils utils = null;
    private final Random r = new Random();
    private final String[] fontNames = {"宋体", "黑体", "微软雅黑"};
    private final Color bgColor = new Color(255, 255, 255);
    private String text;

    /**
     * 实例化对象
     */
    public static VerificationCodeUtils getInstance() {
        if (utils == null) {
            synchronized (VerificationCodeUtils.class) {
                if (utils == null) {
                    utils = new VerificationCodeUtils();
                }
            }
        }
        return utils;
    }

    private Color randomColor() {
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int blue = r.nextInt(150);
        return new Color(red, green, blue);
    }

    private Font randomFont() {
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int size = r.nextInt(5) + 24;
        return new Font(fontName, Font.BOLD + Font.ITALIC, size);
    }

    private void drawLine(BufferedImage image) {
        int num = 5;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = r.nextInt(CAPTCHA_WIDTH);
            int y1 = r.nextInt(CAPTCHA_HEIGHT);
            int x2 = r.nextInt(CAPTCHA_WIDTH);
            int y2 = r.nextInt(CAPTCHA_HEIGHT);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(randomColor());
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    private char randomChar() {
        String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, CAPTCHA_WIDTH, CAPTCHA_HEIGHT);
        return image;
    }

    public BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMBER_CNT; i++) {
            String s = randomChar() + "";
            sb.append(s);
            float x = i * 1.0F * CAPTCHA_WIDTH / NUMBER_CNT;
            g2.setFont(randomFont());
            g2.setColor(randomColor());
            g2.drawString(s, x, CAPTCHA_HEIGHT - 5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    public String getText() {
        return text;
    }
}