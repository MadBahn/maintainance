<%--
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
<form action="${pageContext.request.contextPath}/admin" method="post">
    <span class="abel">用户</span>
    <input name="a">
    <br>
    <span class="abel">密码</span>
    <input name="pwd" type="password">
    <br>
    <p style="color: red;font-size: 12px;">
        <%=request.getAttribute("error") == null?"":request.getAttribute("error")%>
    </p>
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
