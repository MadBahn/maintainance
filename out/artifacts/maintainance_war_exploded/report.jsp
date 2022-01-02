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
        <form>
            <input/>
            <br>
            <input/>
            <br>
            <input/>
        </form>
    </div>
    <div>
        <%for(_Record i : rl){%>
        <%=i.getRecord_id()%>-<%=i.getRecord_content()%>-<%=i.getRecord_date()%>-<%=i.getRail_id()%>-<%=i.getFacility_id()%>-<%=i.getEquipment_id()%>
        <br>
        <%}%>
    </div>
</div>
</body>
<script>

</script>
</html>
