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
        <form>
            编号：<input/>
            <br>
            设备名：<input/>
            <br>
            日期：<input type="date"/>
            <br>
            价格：<input/>
        </form>
    </div>
    <div>
        <%for(Facility i : fl){%>
        <%=i.getEquipment_id()%>-<%=i.getEquipment_name()%>-<%=i.getEquipment_type()%>-<%=i.getEquipment_date()%>-<%=i.getEquipment_price()%>
        <br>
        <%}%>
    </div>
</div>


</body>
<script>

</script>
</html>
