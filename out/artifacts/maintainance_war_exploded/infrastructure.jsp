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
        <form>
            <input/>
            <br>
            <input/>
            <br>
            <input/>
        </form>
    </div>
    <div>
        <%for (Infrastructure i : il){%>
        <%=i.getFacility_id()%>-<%=i.getFacility_name()%>-<%=i.getFacility_type()%>-<%=i.getFacility_state()%>-<%=i.getFacility_remark()%>
        <br>
        <%}%>
    </div>
</div>
<script>
    function add(al){
        let a = document.getElementById(al)
        a.removeAttribute("hidden")
    }
</script>
</body>
</html>
