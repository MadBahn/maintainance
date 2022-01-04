<%@ page import="org.dao.impl.Facility_impl" %>
<%@ page import="org.model.Facility" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/22
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设备</title>
    <link href="css/system.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js" rel="external nofollow" >
    </script>
    <script>
        $(document).ready(function () {
            $("#b").click(function () {
                $("#af").slideToggle("fast")
            })
        })
    </script>
</head>
<body>
<%@include file="common/navbar_top.jsp"%>
<%
    Facility_impl fi = new Facility_impl();
    List<Facility> fl = fi.queryAll();
%>
<div class="section-box">
    <h1>设备</h1>
    <button id="b">add</button>
    <div class="add" id="af" style="display: none">
        <form action="${pageContext.request.contextPath}/facility" method="get">
            <input name="method" value="add" hidden>
            <span class="abel">编号：</span>
            <input name="id"/>
            <br>
            <span class="abel">设备名：</span>
            <input name="name"/>
            <br>
            <span class="abel">类型：</span>
            <select name="type">
                <option value="小型">小型</option>
                <option value="大型">大型</option>
            </select>
            <br>
            <span class="abel">日期：</span>
            <input type="date" name="date"/>
            <br>
            <span class="abel">价格：</span>
            <input name="price"/>
            <br>
            <input type="submit" value="添加">
        </form>
    </div>
    <div>
        <%for(Facility i : fl){%>
        <%=i.getEquipment_id()%>-<%=i.getEquipment_name()%>-<%=i.getEquipment_type()%>-<%=i.getEquipment_date()%>-<%=i.getEquipment_price()%>
        <br>
        <div style="padding: 10px;border: 1px solid;">
            <form action="${pageContext.request.contextPath}/facility" method="get">
                <input name="method" value="edit" hidden>
                <input name="_id" value="<%=i.getEquipment_id()%>" hidden>
                <span class="abel">编号：</span>
                <input name="id" value="<%=i.getEquipment_id()%>"/>
                <br>
                <span class="abel">设备名：</span>
                <input name="name" value="<%=i.getEquipment_name()%>"/>
                <br>
                <span class="abel">类型：</span>
                <select name="type">
                    <option value="小型" <%=i.getEquipment_type().equals("小型")?"selected":""%>>小型</option>
                    <option value="大型" <%=i.getEquipment_type().equals("大型")?"selected":""%>>大型</option>
                </select>
                <br>
                <span class="abel">日期：</span>
                <input type="date" name="date" value="<%=i.getEquipment_date()%>"/>
                <br>
                <span class="abel">价格：</span>
                <input name="price" value="<%=i.getEquipment_price()%>"/>
                <br>
                <input type="submit" value="修改">
            </form>
            <button onclick="del('<%=i.getEquipment_id()%>','${pageContext.request.contextPath}/facility?method=del&_id=')">删除</button>
            <br>
        </div>
        <%}%>
    </div>
</div>


</body>
<script src="js/common/del.js"></script>
</html>
