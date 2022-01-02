<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/29
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台</title>
</head>
<body>
<a href="sys_index.jsp"><button>返回</button></a>
<form action="${pageContext.request.contextPath}/staff" method="post">
    <input value="add" name="method" hidden>
    编号：<input name="id">
    <br>
    姓名：<input name="name">
    <br>
    用户名：<input name="account">
    <br>
    密码：<input name="password" type="password">
    <br>
    职位：
    <select name="position">
        <option value="巡检员">巡检员</option>
        <option value="维修员">维修员</option>
        <option value="工程师">工程师</option>
    </select>
    <br>
    电话号码：<input name="phone" type="number">
    <br>
    电子邮件：<input name="email" type="email">
    <br>
    <input type="submit" value="确定">
</form>
</body>
</html>
