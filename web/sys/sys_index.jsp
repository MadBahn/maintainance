<%@ page import="org.dao.impl.Staff_impl" %>
<%@ page import="org.model.Staff" %>
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
    <title>后台</title>
</head>
<body>
<%
    Staff_impl si = new Staff_impl();
    List<Staff> sl = si.queryAll();
%>
<a href="add.jsp">添加</a>
&nbsp;&nbsp;&nbsp;
<a href="console.jsp">控制台</a>
<ul>
    <%for(Staff i : sl){%>
    <li>
        <%=i.getStaff_id()%>-<%=i.getStaff_name()%>-<%=i.getStaff_account()%>-<%=i.getStaff_password()%>-<%=i.getStaff_position()%>-<%=i.getStaff_phone()%>-<%=i.getStaff_email()%>
        <button onclick="del('<%=i.getStaff_id()%>')">删除</button>
        <br>
    </li>
    <%}%>
</ul>
</body>
<script>
    function del(id) {
        if(confirm("此操作不可逆转，是否继续删除"+id+"？")){
            window.location.href = "${pageContext.request.contextPath}/staff?method=del&_id="+id;
        }
    }
</script>
</html>
