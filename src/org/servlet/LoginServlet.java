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
        String pwd = request.getParameter("pwd");

        Staff_impl si = new Staff_impl();
        Staff s = si.Login(account,pwd);
        System.out.println(s);
        if(s!=null){
            response.sendRedirect("main.jsp");
        }else{
            request.setAttribute("error","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
//            response.sendRedirect("login.jsp");
        }


    }
}
