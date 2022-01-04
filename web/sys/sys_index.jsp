<%@ page import="org.dao.impl.Staff_impl" %>
<%@ page import="org.model.Staff" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/29
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台</title>
</head>
<body>
<%
    Staff_impl si = new Staff_impl();
    List<Staff> sl = si.queryAll();
%>
<a href="add.jsp">添加</a><a href="console.jsp">控制台</a>
<ul>
    <%for(Staff i : sl){%>
    <li>
        <%=i.getStaff_id()%>-<%=i.getStaff_name()%>-<%=i.getStaff_account()%>-<%=i.getStaff_password()%>-<%=i.getStaff_position()%>-<%=i.getStaff_phone()%>-<%=i.getStaff_email()%>
        <br>
    </li>
    <%}%>
</ul>
</body>
</html>
