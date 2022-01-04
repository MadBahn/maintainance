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
    <span class="abel">编号：</span>
    <input name="id">
    <br>
    <span class="abel">姓名：</span>
    <input name="name">
    <br>
    <span class="abel">用户名：</span>
    <input name="account">
    <br>
    <span class="abel">密码：</span>
    <input name="password" type="password">
    <br>
    <span class="abel">职位：</span>
    <select name="position">
        <option value="巡检员">巡检员</option>
        <option value="维修员">维修员</option>
        <option value="工程师">工程师</option>
    </select>
    <br>
    <span class="abel">电话号码：</span>
    <input name="phone" type="number">
    <br>
    <span class="abel">电子邮件：</span>
    <input name="email" type="email">
    <br>
    <input type="submit" value="确定">
</form>
</body>
</html>
