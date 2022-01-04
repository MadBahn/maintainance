<%@ page import="org.dao.impl.Infrastructure_impl" %>
<%@ page import="org.model.Infrastructure" %>
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
    <title>设施</title>
    <link href="css/system.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js" rel="external nofollow" >
    </script>
    <script>
        $(document).ready(function () {
            $("#c").click(function () {
                $("#ai").slideToggle("fast")
            })
        })
    </script>
</head>
<body>
<%
    Infrastructure_impl ii = new Infrastructure_impl();
    List<Infrastructure> il = ii.queryAll();
%>
<%@include file="common/navbar_top.jsp"%>
<div class="section-box">
    <h1>设施</h1>
    <button id="c">add</button>
    <div class="add" id="ai" hidden>
        <form action="${pageContext.request.contextPath}/infrastructure" method="get">
            <input name="method" value="add" hidden>
            <span class="abel">编号</span>
            <input name="id"/>
            <br>
            <span class="abel">名称</span>
            <input name="name"/>
            <br>
            <span class="abel">状态</span>
            <select name="state">
                <option value="使用中">使用中</option>
                <option value="未使用">未使用</option>
            </select>
            <br>
            <span class="abel">类型</span>
            <select name="type">
                <option value="大型">大型</option>
                <option value="小型">小型</option>
            </select>
            <br>
            <span class="abel">备注</span>
            <textarea name="remark" style="width: 300px;height: 50px;resize: none;"></textarea>
            <br>
            <input type="submit" value="添加">
        </form>
    </div>
    <div>
        <%for (Infrastructure i : il){%>
        <%=i.getFacility_id()%>-<%=i.getFacility_name()%>-<%=i.getFacility_type()%>-<%=i.getFacility_state()%>-<%=i.getFacility_remark()%>
        <br>
        <div style="padding: 10px;border: 1px solid;">
            <form action="${pageContext.request.contextPath}/infrastructure" method="get">
                <input name="_id" value="<%=i.getFacility_id()%>" hidden>
                <input name="method" value="edit" hidden>
                <span class="abel">编号</span>
                <input name="id" value="<%=i.getFacility_id()%>"/>
                <br>
                <span class="abel">名称</span>
                <input name="name" value="<%=i.getFacility_name()%>"/>
                <br>
                <span class="abel">状态</span>
                <select name="state">
                    <option value="使用中" <%=i.getFacility_state().equals("使用中")?"selected":""%>>使用中</option>
                    <option value="未使用" <%=i.getFacility_state().equals("未使用")?"selected":""%>>未使用</option>
                </select>
                <br>
                <span class="abel">类型</span>
                <select name="type">
                    <option value="大型" <%=i.getFacility_type().equals("大型")?"selected":""%>>大型</option>
                    <option value="小型" <%=i.getFacility_type().equals("小型")?"selected":""%>>小型</option>
                </select>
                <br>
                <span class="abel">备注</span>
                <textarea name="remark" style="width: 300px;height: 50px;resize: none;"><%=i.getFacility_remark()%></textarea>
                <br>
                <input type="submit" value="修改">
            </form>
            <button onclick="del('<%=i.getFacility_id()%>','${pageContext.request.contextPath}/infrastructure?method=del&_id=')">删除</button>
        </div>
        <%}%>
    </div>
</div>
<script src="js/common/del.js"></script>
</body>
</html>
