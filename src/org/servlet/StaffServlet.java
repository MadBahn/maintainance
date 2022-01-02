package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StaffServlet", value = "/staff")
public class StaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String account = request.getParameter("account");
        String pwd = request.getParameter("password");
        String pos = request.getParameter("position");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        System.out.println(method);
        System.out.println(id);
        System.out.println(name);
        System.out.println(account);
        System.out.println(pwd);
        System.out.println(pos);
        System.out.println(phone);
        System.out.println(email);

    }
}
