<%@ page import="org.dao.impl.Mission_impl" %>
<%@ page import="org.dao.impl.Warn_impl" %>
<%@ page import="org.model.Mission" %>
<%@ page import="java.util.List" %>
<%@ page import="org.model.Warn" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/30
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
    <link href="css/system.css" rel="stylesheet" type="text/css">


</head>
<body>
<%@include file="common/navbar_top.jsp"%>
<%
    Mission_impl mi = new Mission_impl();
    Warn_impl wi = new Warn_impl();
    List<Mission> ml = mi.queryAll();
    List<Warn> wl = wi.queryAll();
%>
<div class="section-box" style="height: 890px;">
    <h1>主页</h1>
    <div class="mission">
        当前任务：
        <br>
        <%for(Mission i : ml){%>
        <%=i.getTask_content()%>——<%=i.getTask_date()%>
        <br>
        <%}%>
    </div>
    <div class="warning">
        优先处理警告：
        <br>
        <%for(Warn i : wl){%>
        <%=i.getWarn_content()%>——<%=i.getWarn_grade()%>——<%=i.getWarn_date()%>
        <button>快速处理</button>
        <br>
        <%}%>
    </div>
</div>
</body>
</html>
