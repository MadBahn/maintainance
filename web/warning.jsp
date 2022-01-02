<%@ page import="org.dao.impl.Warn_impl" %>
<%@ page import="org.model.Warn" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/29
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>警告</title>
    <link href="css/system.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js" rel="external nofollow" >
    </script>
    <script>
        $(document).ready(function () {
            $("#e").click(function () {
                $("#aw").slideToggle("fast")
            })
        })
    </script>
</head>
<body>
<%
    Warn_impl wi =new Warn_impl();
    List<Warn> wl = wi.queryAll();
%>
<%@include file="common/navbar_top.jsp"%>
<div class="section-box">
    <h1>警告</h1>
    <button id="e">add</button>
    <div class="add" id="aw" hidden>
        <form action="" method="get">
            <input name="method" value="add" hidden>
            <span class="abel">编号：</span>
            <input name="id"/>
            <br>
            <span class="abel">内容：</span>
            <input name="content">
            <br>
            <span class="abel">等级：</span>
            <select name="level">
                <option value="normal">普通</option>
                <option value="caution">注意</option>
                <option value="serious">严重</option>
                <option value="disaster">灾难</option>
            </select>
            <br>
            <span class="abel">有效时间：</span>
            <input name="validtime"/>
            <br>
            <span class="abel">日期：</span>
            <input type="date"/>
            <br>
            <input type="submit" value="添加"/>
        </form>
    </div>
    <div>
        <%for(Warn i : wl){%>
        <%=i.getWarn_id()%>-<%=i.getWarn_content()%>-<%=i.getWarn_grade()%>-<%=i.getWarn_validtime()%>-<%=i.getWarn_date()%>
        <br>
        <%}%>
    </div>
</div>


</body>
<script>
    function add(al){
        let a = document.getElementById(al)
        a.removeAttribute("hidden")
    }
</script>
</html>
