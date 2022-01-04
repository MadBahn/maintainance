<%@ page import="org.dao.impl.Rail_impl" %>
<%@ page import="org.model.Rail" %>
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
    <title>线路</title>
    <link href="css/system.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js" rel="external nofollow" >
    </script>
    <script>
        $(document).ready(function () {
            $("#a").click(function () {
                $("#al").slideToggle("fast")
            })
        })
    </script>
</head>
<body>
<%@include file="common/navbar_top.jsp"%>
<%
    Rail_impl ri = new Rail_impl();
    List<Rail> rl = ri.queryAll();
%>
<div class="section-box" style="height: 890px;">
    <h1>线路</h1>
    <button id="a">add</button>
    <div class="add" id="al" style="display: none">
        <form method="get" action="line">
            <input name="method" value="add" hidden/>
            <span class="abel">编号：</span>
            <input name="id"/>
            <br>
            <span class="abel">线路名：</span>
            <input name="name"/>
            <br>
            <span class="abel">等级：</span>
            <select name="grade">
                <option value="普速" selected>普速</option>
                <option value="高速">高速</option>
            </select>
            <br>
            <span class="abel">类型：</span>
            <select name="level">
                <option value="干线" selected>干线</option>
                <option value="支线">支线</option>
                <option value="联络线">联络线</option>
            </select>
            <br>
            <span class="abel">轨距：</span>
            <select name="gauge">
                <option value="准轨" selected>准轨</option>
                <option value="窄轨">窄轨</option>
            </select>
            <br>
            <span class="abel">长度：</span>
            <input name="length"/>
            <br>
            <span class="abel">路基：</span>
            <select name="subgrade">
                <option value="有砟" selected>有砟</option>
                <option value="无砟">无砟</option>
            </select>
            <br>
            <span class="abel">架设：</span>
            <select name="position">
                <option value="地面" selected>地面</option>
                <option value="地下">地下</option>
                <option value="高架/桥梁">高架/桥梁</option>
            </select>
            <br>
            <span class="abel">是否电气化：</span>
            <input type="checkbox" name="electrification"/>
            <br>
            <span class="abel">备注：</span>
            <br>
            <textarea name="remark" style="width: 300px;height: 50px;resize: none;"></textarea>
            <br>
            <input type="submit" value="添加">
        </form>
    </div>
    <div class="display">
        <%for(Rail i : rl){%>
        <%=i.getRail_id()%>-<%=i.getRail_name()%>-<%=i.getRail_grade()%>-<%=i.getRail_gauge()%>-<%=i.getRail_type()%>-<%=i.getRail_length()%>-<%=i.getRail_subgrade()%>-<%=i.getRail_position()%>-<%=i.getRail_electrification()%>-<%=i.getRail_remark()%>
        <br>
<%--        <a href="#"><button>修改</button></a>--%>
<%--        <button id="ee">修改</button>--%>
        <div style="padding: 10px;border: 1px solid;">
            <form method="get" action="${pageContext.request.contextPath}/line" id="ee_f">
                <input name="method" value="edit" hidden/>
                <span class="abel">编号：</span>
                <input name="id" value="<%=i.getRail_id()%>"/>
                <br>
                <span class="abel">线路名：</span>
                <input name="name" value="<%=i.getRail_name()%>"/>
                <br>
                <span class="abel">等级：</span>
                <select name="grade">
                    <option value="普速" <%=i.getRail_grade().equals("普速")?"selected":""%>>普速</option>
                    <option value="高速" <%=i.getRail_grade().equals("高速")?"selected":""%>>高速</option>
                </select>
                <br>
                <span class="abel">类型：</span>
                <select name="level">
                    <option value="干线" <%=i.getRail_type().equals("干线")?"selected":""%>>干线</option>
                    <option value="支线" <%=i.getRail_type().equals("支线")?"selected":""%>>支线</option>
                    <option value="联络线" <%=i.getRail_type().equals("联络线")?"selected":""%>>联络线</option>
                </select>
                <br>
                <span class="abel">轨距：</span>
                <select name="gauge">
                    <option value="准轨" <%=i.getRail_gauge().equals("准轨")?"selected":""%>>准轨</option>
                    <option value="窄轨" <%=i.getRail_gauge().equals("窄轨")?"selected":""%>>窄轨</option>
                </select>
                <br>
                <span class="abel">长度：</span>
                <input name="length" value="<%=i.getRail_length()%>"/>
                <br>
                <span class="abel">路基：</span>
                <select name="subgrade">
                    <option value="有砟" <%=i.getRail_subgrade().equals("有砟")?"selected":""%>>有砟</option>
                    <option value="无砟" <%=i.getRail_subgrade().equals("无砟")?"selected":""%>>无砟</option>
                </select>
                <br>
                <span class="abel">架设：</span>
                <select name="position">
                    <option value="地面" <%=i.getRail_position().equals("地面")?"selected":""%>>地面</option>
                    <option value="地下" <%=i.getRail_position().equals("地下")?"selected":""%>>地下</option>
                    <option value="高架/桥梁" <%=i.getRail_position().equals("高架/桥梁")?"selected":""%>>高架/桥梁</option>
                </select>
                <br>
                <span class="abel">是否电气化：</span>
                <input type="checkbox" <%=i.getRail_electrification().equals("是")?"checked":""%> name="electrification"/>
                <br>
                <span class="abel">备注：</span>
                <br>
                <textarea name="remark" style="width: 300px;height: 50px;resize: none;"><%=i.getRail_remark()%></textarea>
                <br>
                <input type="submit" value="修改">
            </form>
            <button onclick="del('<%=i.getRail_id()%>','${pageContext.request.contextPath}/line?method=del&id=')">删除</button>
            <br>
        </div>
        <%}%>
    </div>
</div>
</body>
<script src="js/common/del.js"></script>
<%--${pageContext.request.contextPath}/mission?method=del&_id=--%>
</html>
