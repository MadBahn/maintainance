package org.servlet;

import com.mysql.cj.Session;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dao.impl.Staff_impl;
import org.model.Staff;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        String pwd = request.getParameter("password");

        //输入的验证码
        String code=request.getParameter("code");
        //session中保存的图片验证码数据
        HttpSession session=request.getSession();
        String r_code=(String) session.getAttribute("r_code");

        Staff_impl si = new Staff_impl();
        Staff s = si.Login(account,pwd);
        System.out.println(s);
        if(s != null&& code.equalsIgnoreCase(r_code)){
            request.getSession().setAttribute("user",s);
            response.sendRedirect("main.jsp");
        }else{
            request.setAttribute("error","用户名或密码错误!");
            request.setAttribute("error_code", "图片验证码错误！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
