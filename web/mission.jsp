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
        <form>
            <input/>
            <br>
            <input/>
            <br>
            <input/>
        </form>
    </div>
    <div>
        <%for(Mission i : ml){%>
        <%=i.getTask_id()%>-<%=i.getTask_content()%>-<%=i.getTask_date()%>
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