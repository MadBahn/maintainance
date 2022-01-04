<%@ page import="org.dao.impl.Mission_impl" %>
<%@ page import="org.model.Mission" %>
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
    <title>任务</title>
    <link href="css/system.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js" rel="external nofollow" >
    </script>
    <script>
        $(document).ready(function () {
            $("#d").click(function () {
                $("#am").slideToggle("fast")
            })
        })
    </script>

</head>
<body>
<%
    Mission_impl mi = new Mission_impl();
    List<Mission> ml = mi.queryAll();
%>
<%@include file="common/navbar_top.jsp"%>
<div class="section-box">
    <h1>任务</h1>
    <button id="d">add</button>
    <div class="add" id="am" hidden>
        <form action="${pageContext.request.contextPath}/mission" method="get">
            <input name="method" value="add" hidden>
            <span class="abel">编号</span>
            <input name="id"/>
            <br>
            <span class="abel">内容</span>
            <textarea name="content" style="width: 300px;height: 50px;resize: none;"></textarea>
            <br>
            <span class="abel">日期</span>
            <input name="date" type="date"/>
            <br>
            <input type="submit" value="添加">
        </form>
    </div>
    <div>
        <%for(Mission i : ml){%>
        <%=i.getTask_id()%>-<%=i.getTask_content()%>-<%=i.getTask_date()%>
        <br>
        <div style="padding: 10px;border: 1px solid;">
            <form action="${pageContext.request.contextPath}/mission" method="get">
                <input name="_id" value="<%=i.getTask_id()%>" hidden>
                <input name="method" value="edit" hidden>
                <span class="abel">编号</span>
                <input name="id" value="<%=i.getTask_id()%>"/>
                <br>
                <span class="abel">内容</span>
                <textarea name="content" style="width: 300px;height: 50px;resize: none;"><%=i.getTask_content()%></textarea>
                <br>
                <span class="abel">日期</span>
                <input name="date" type="date" value="<%=i.getTask_date()%>"/>
                <br>
                <input type="submit" value="修改">
            </form>
            <button onclick="del('<%=i.getTask_id()%>','${pageContext.request.contextPath}/mission?method=del&_id=')">删除</button>
            <br>
        </div>
        <%}%>
    </div>
</div>
</body>
<script src="js/common/del.js"></script>
</html>
