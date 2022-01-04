<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/22
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>登录</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%--%>
<%--    String error = (String) request.getAttribute("error");--%>
<%--%>--%>
<%--<form method="post" action="${pageContext.request.contextPath}/login">--%>
<%--    用户名：<input name="account">--%>
<%--    <br>--%>
<%--    密码：<input name="pwd" type="password">--%>
<%--    <br>--%>
<%--    <%= (error == null ? "":error)%>--%>
<%--    <br>--%>
<%--    <input type="submit" value="登录">--%>
<%--</form>--%>
<%--<a href="main.jsp">登录</a>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
            background: url(img/bg.png);
            background-size: 100%;
        }
        #login{
            width: 400px;
            height: 280px;
            float: right;
            margin-top: 150px;
            margin-right: 80px;
            background: rgba(241,243,244,0.4);
            border-radius:50px;
        }
        tbody{
            font-size: 20px;
            color: rgba(1,3,24,0.6);
            display: block;
            margin-left: 60px;
            margin-top: 20px;
        }
        .button{
            width: 60px;
            height: 30px;
            border-radius: 10px;
            color: rgba(1,3,24,0.6);
            border:rgba(1,3,24,0.6);
            font-size: 18px;
            font-weight: 600;
        }
    </style>
</head>
<body>
<div id="login">
    <center><h1>铁路维护系统登录</h1></center>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table>
            <tbody>
            <tr>
                <td align="right">账号：</td>
                <td><input style="WIDTH: 160px; HEIGHT: 26px" name="account" id="account"/></td>
            </tr>
            <tr>
                <td align="right">密码：</td>
                <td><input style="WIDTH: 160px; HEIGHT: 26px" type="password" name="password" id="password"/> </td>
            </tr>
            <tr>
                <td align="right">验证码：</td>
                <td>
                    <input style="WIDTH: 160px; HEIGHT: 26px;" type="text" width="100px" name="code" autocomplete="off" maxlength="4" placeholder="请输入验证码" id="passcode" tabindex="2">
                    <img src="${pageContext.request.contextPath}/code" onclick="this.src='${pageContext.request.contextPath}/code?'+Math.random();">
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="登录" class="button"/> <input type="reset" value="重置" class="button"/> </td>
            </tr>
            <% if(request.getAttribute("error") != null){%>
            <tr>
                <td align="right">
                    <p class="error"style="color: red;font-size: 10px;">
                        <%=request.getAttribute("error")%>
                    </p>
                    <%}%>
                    <% if(request.getAttribute("error_code") != null){%>
                    <p class="error"style="color: red;font-size: 10px;">
                        <%=request.getAttribute("error_code")%>
                    </p>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
