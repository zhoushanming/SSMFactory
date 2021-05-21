package cn.edu.usts.cs2018.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Service("validateCodeGen")
public class ValidateCodeService {
    public String genValidate(BufferedImage image) {
        char[] code = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String[] Fonts = {"Times New Roman", "Verdana",
                "Arial Narrow",
                "Candara",
                "Californian FB",
                "Brush Script MT"};
        int width = 60, height = 30;
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.fillRect(0, 0, width, height);
        g.setColor(getRandColor(160, 200));
        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);        //画随机线条
        }
        String sRand = "";
        int t;
        // 取随机产生的验证码(4位字符)
        for (int i = 0; i < 4; i++) {
            t = random.nextInt(code.length);
            String rand = "" + code[t];    //随机选择一个字符
            sRand += rand;
            //随机选择颜色
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            //随机选择字体，字体大小为（15+random.nextInt(5)）
            g.setFont(new Font(Fonts[random.nextInt(5)], Font.BOLD, 20 + random.nextInt(5)));
            //在(13*i,15+random.nextInt(10))位置写一个字符，将验证码显示到图象中
            g.drawString(rand, 13 * i + 6, 15 + random.nextInt(10));
        }
        return sRand;
    }

    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}