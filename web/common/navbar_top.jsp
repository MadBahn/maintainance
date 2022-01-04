<%@ page import="org.model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/29
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <%
        Staff s = null;
        try {
            s = (Staff) session.getAttribute("user");
        }catch (Exception e){
            response.sendRedirect("login.jsp");
        }
    %>

    <span>当前用户：<a href="account.jsp"><%=s.getStaff_name()%></a></span>
    <span>————————————</span>
    <a href="main.jsp">主页</a>
    <a href="line.jsp">线路</a>
    <a href="infrastructure.jsp">设施</a>
    <a href="facility.jsp">设备</a>
    <a href="mission.jsp">任务</a>
    <a href="report.jsp">记录</a>
    <a href="warning.jsp">警告</a>
</header>
