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
<div class="section-box" style="height: 890px;">
    <h1>警告</h1>
    <button id="e">add</button>
    <div class="add" id="aw" hidden>
        <form action="${pageContext.request.contextPath}/warn" method="get">
            <input name="method" value="add" hidden>
            <span class="abel">编号：</span>
            <input name="id"/>
            <br>
            <span class="abel">内容：</span>
            <textarea name="content" style="width: 300px;height: 50px;"></textarea>
            <br>
            <span class="abel">等级：</span>
            <select name="level">
                <option value="普通">普通</option>
                <option value="注意">注意</option>
                <option value="严重">严重</option>
                <option value="灾难">灾难</option>
            </select>
            <br>
            <span class="abel">有效时间：</span>
            <input name="validtime"/>
            <br>
            <span class="abel">日期：</span>
            <input type="date" name="date"/>
            <br>
            <input type="submit" value="添加"/>
        </form>
    </div>
    <div>
        <%for(Warn i : wl){%>
        <%=i.getWarn_id()%>-<%=i.getWarn_content()%>-<%=i.getWarn_grade()%>-<%=i.getWarn_validtime()%>-<%=i.getWarn_date()%>
        <form action="${pageContext.request.contextPath}/warn" style="padding: 10px;border: 1px solid;" method="get">
            <input name="_id" value="<%=i.getWarn_id()%>" hidden>
            <input name="method" value="edit" hidden>
            <span class="abel">编号：</span>
            <input name="id" value="<%=i.getWarn_id()%>"/>
            <br>
            <span class="abel">内容：</span>
            <textarea name="content" style="width: 300px;height: 50px;"><%=i.getWarn_content()%></textarea>
            <br>
            <span class="abel">等级：</span>
            <select name="level">
                <option value="普通" <%=i.getWarn_grade().equals("普通")?"selected":""%>>普通</option>
                <option value="注意" <%=i.getWarn_grade().equals("注意")?"selected":""%>>注意</option>
                <option value="严重" <%=i.getWarn_grade().equals("严重")?"selected":""%>>严重</option>
                <option value="灾难" <%=i.getWarn_grade().equals("灾难")?"selected":""%>>灾难</option>
            </select>
            <br>
            <span class="abel">有效时间：</span>
            <input name="validtime" value="<%=i.getWarn_validtime()%>"/>
            <br>
            <span class="abel">日期：</span>
            <input type="date" name="date" value="<%=i.getWarn_date()%>"/>
            <br>
            <input type="submit" value="修改"/>
        </form>
        <button onclick="del('<%=i.getWarn_id()%>')">删除</button>
        <br>
        <%}%>
    </div>
</div>

</body>
<script>
    function del(id) {
        console.log(id);
        if(confirm("此操作不可逆转，是否继续删除"+id+"？")){
            window.location.href = "${pageContext.request.contextPath}/warn?method=del&_id="+id;
        }
    }
</script>
</html>
