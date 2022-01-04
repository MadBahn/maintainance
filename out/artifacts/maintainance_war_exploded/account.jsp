<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/1/4
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号管理</title>
    <link href="css/system.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js" rel="external nofollow" >
    </script>
    <script>
        $(document).ready(function () {
            $("#a").click(function () {
                $("#al").slideToggle("fast")
            })
        })
        $(document).ready(function () {
            $("#b").click(function () {
                $("#af").slideToggle("fast")
            })
        })
    </script>
</head>
<body>
<%@include file="common/navbar_top.jsp"%>

<div class="section-box">
    <h1>账号管理</h1>
    <div style="padding: 20px;border: 1px solid;">
        <span class="abel">真实姓名：</span>
        <%=s.getStaff_name()%>
        <br>
        <span class="abel">职位：</span>
        <%=s.getStaff_position()%>
        <br>
        <span class="abel">电子邮件：</span>
        <%=s.getStaff_email()%>
        <br>
        <span class="abel">电话号码：</span>
        <%=s.getStaff_phone()%>
        <br>
    </div>
    <button id="a">修改资料</button>
    <div class="add" id="al" style="display: none">
        <form method="post" action="${pageContext.request.contextPath}/mod">
            <input name="id" value="<%=s.getStaff_id()%>" hidden>
            <input name="method" value="info" hidden>
            <br>
            <span class="abel">电话号码</span>
            <input name="phone">
            <br>
            <span class="abel">电子邮件</span>
            <input name="email">
            <br>
            <span class="abel">确认密码</span>
            <input name="pwd">
            <br>
            <input type="submit" value="修改">
        </form>
    </div>
    <button id="b">修改密码</button>
    <div class="add" id="af" style="display: none">
        <form method="post" action="${pageContext.request.contextPath}/mod">
            <input name="id" value="<%=s.getStaff_id()%>" hidden>
            <input name="method" value="pwd" hidden>
            <span class="abel">用户名</span>
            <input name="account" value="<%=s.getStaff_account()%>">
            <br>
            <span class="abel">原密码</span>
            <input name="pwd" type="password">
            <br>
            <span class="abel">新密码</span>
            <input name="pwd_r" type="password">
            <br>
            <input type="submit" value="修改">
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</div>

</body>
</html>
