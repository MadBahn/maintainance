<%@ page import="org.dao.impl.Record_impl" %>
<%@ page import="java.util.List" %>
<%@ page import="org.model._Record" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/22
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>记录</title>
    <link href="css/system.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js" rel="external nofollow" >
    </script>
    <script>
        $(document).ready(function () {
            $("#c").click(function () {
                $("#ar").slideToggle("fast")
            })
        })
    </script>

</head>
<body>
<%
    Record_impl ri = new Record_impl();
    List<_Record> rl = ri.queryAll();
%>
<%@include file="common/navbar_top.jsp"%>
<div class="section-box">
    <h1>记录</h1>
    <button id="c">add</button>
    <div class="add" id="ar" style="display: none">
        <form action="${pageContext.request.contextPath}/record" method="get">
            <span class="abel">编号</span>
            <input name="method" value="add" hidden>
            <input name="id"/>
            <br>
            <span class="abel">日期</span>
            <input type="date" name="date"/>
            <br>
            <span class="abel">内容</span>
            <input name="content"/>
            <br>
            <span class="abel">对象编号</span>
            <select name="target">
                <option value="rail">线路</option>
                <option value="facility">设备</option>
                <option value="infrastructure">设施</option>
            </select>
            <input name="ref_id">
            <br>
            <input type="submit" value="添加">
        </form>
    </div>
    <div>
        <%for(_Record i : rl){%>
        <br>
        <div style="padding: 10px;border: 1px solid;">
            <form action="${pageContext.request.contextPath}/record" method="get">
                <span class="abel">编号</span>
                <input name="method" value="edit" hidden>
                <input name="_id" value="<%=i.getRecord_id()%>" hidden>
                <input name="id" value="<%=i.getRecord_id()%>"/>
                <br>
                <span class="abel">日期</span>
                <input type="date" name="date" value="<%=i.getRecord_date()%>"/>
                <br>
                <span class="abel">内容</span>
                <input name="content" value="<%=i.getRecord_content()%>"/>
                <br>
                <span class="abel">对象编号</span>
                <input readonly value="<%=(i.getEquipment_id() == null? "":i.getEquipment_id())+(i.getFacility_id() == null? "":i.getFacility_id())+(i.getRail_id() == null ? "":i.getRail_id() )%>">
                <br>
                <input type="submit" value="修改">
            </form>
            <button onclick="del('<%=i.getRecord_id()%>','${pageContext.request.contextPath}/record?method=del&_id=')">删除</button>
        </div>
        <%}%>
    </div>
</div>
</body>
<script src="js/common/del.js"></script>
</html>
