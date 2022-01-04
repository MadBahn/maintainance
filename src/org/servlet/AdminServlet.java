package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.ctrl.DBCtrl;
import org.model.Admin;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String a = request.getParameter("a");
        String pwd = request.getParameter("pwd");

        String sql = "select * from admin where admin = ? and password = ?";
        QueryRunner qr = DBCtrl.getRunner();
        try {
            if(qr.query(sql,new BeanHandler<>(Admin.class),a,pwd)!=null){
                response.sendRedirect("./sys/sys_index.jsp");
            }
            else{
                request.setAttribute("error","用户名或密码错误");
                request.getRequestDispatcher("./sys/sys_login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
