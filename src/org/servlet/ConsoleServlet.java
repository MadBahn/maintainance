package org.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.dbutils.QueryRunner;
import org.ctrl.DBCtrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ConsoleServlet", value = "/console")
public class ConsoleServlet extends HttpServlet {

    private QueryRunner qr = DBCtrl.getRunner();
    private String jdbcURL = "jdbc:mysql://localhost:3306/railway?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "19791212";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");
        System.out.println(command);
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd;
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            s = conn.createStatement();
            rs = s.executeQuery(command);
            rsmd = rs.getMetaData();
            List<Map<String, Object>> li = new ArrayList<Map<String, Object>>();

            while(rs.next()){
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 0;i<rsmd.getColumnCount();i++){
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(columnLabel);
                    System.out.println(columnLabel+":"+columnValue);
                    map.put(columnLabel, columnValue);
                }
                li.add(map);
            }
            out.write("\n————————The result of command:\""+command+"\"————————\n");
            for(Map<String, Object> i : li){
                out.println(i);
            }

            rs.close();
            s.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            out.write("\n————————The result of command:\""+command+"\"————————\n");
            try {
                assert s != null;
                count = s.executeUpdate(command);
                out.println("Affected rows:"+count);
            } catch (SQLException ex) {
                ex.printStackTrace();
                out.write(ex.toString());
            }
        }
    }
}
