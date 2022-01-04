<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/22
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String error = (String) request.getAttribute("error");
%>
<form method="post" action="${pageContext.request.contextPath}/login">
    用户名：<input name="account">
    <br>
    密码：<input name="pwd" type="password">
    <br>
    <%= (error == null ? "":error)%>
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
