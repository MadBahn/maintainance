package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet(name = "CodeServlet", value = "/code")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //创建空白图片
        BufferedImage image=new BufferedImage(60,25,BufferedImage.TYPE_3BYTE_BGR);
        //获取图片画笔
        Graphics g=image.getGraphics();
        Random r=new Random();
        //设置画笔颜色
//        g.setColor(new Color(r.nextInt(225),r.nextInt(225),r.nextInt(225)));
        //绘制矩形背景
        g.fillRect(0,0,60,25);
        //绘制5条干扰线
        for (int i=0;i<5;i++){
            g.setColor(new Color(r.nextInt(225),r.nextInt(225),r.nextInt(225)));
            g.drawLine(r.nextInt(60),r.nextInt(25),r.nextInt(60),r.nextInt(25));
        }
        //设置画笔颜色
        g.setColor(new Color(r.nextInt(225),r.nextInt(225),r.nextInt(225)));
        //获取随机字符串
        String number=getNumber(4);
        HttpSession session=request.getSession();
        session.setAttribute("r_code",number);//保存到session中
        g.setFont(new Font(null,Font.PLAIN,20));
        g.drawString(number,3,23);
        response.setContentType("image/jpeg");
        OutputStream out=response.getOutputStream();
        ImageIO.write(image,"jpeg",out);
        out.close();//关闭输出流对象
    }

    private String getNumber(int size) {
        String str="QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        String number="";
        Random r=new Random();
        for (int i=0;i<size;i++){
            char c= str.charAt(r.nextInt(str.length()));
            number=number+c;
        }
        return number;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
