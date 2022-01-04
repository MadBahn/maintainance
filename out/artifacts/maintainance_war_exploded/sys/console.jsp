<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/1/4
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台</title>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<a href="sys_index.jsp"><button>返回</button></a>
<br>
<textarea name="result" id="result" readonly style="width: 850px;height: 500px;resize: none;"></textarea>
<br>
<input name="command" id="command" type="text" value="" style="width: 800px;">
<button onclick="doCommand()">执行</button>
</body>
<script>
    let result = document.getElementById("result")
    let _command = document.getElementById("command")
    // let _console = document.getElementById("_console")
    // let _command = _console.command.value;

    function doCommand(){
        console.log(_command.value);
        axios.get('${pageContext.request.contextPath}/console?command='+
        _command.value).then(function (respnse) {
            console.log(respnse.data)
            result.value += respnse.data;
            _command.value = "";
        })
    }
</script>
</html>
