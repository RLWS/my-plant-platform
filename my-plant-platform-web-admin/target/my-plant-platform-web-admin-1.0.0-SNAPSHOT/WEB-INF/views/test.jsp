<%--
  Created by IntelliJ IDEA.
  User: RLWS_5871
  Date: 2019/2/10
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>启动成功</h2>
<form action="/test" method="get">
    <input type="text" name="email" onclick="btn()">
    <button>提交</button>
</form>

<script type='text/javascript' src='static/js/jquery-1.8.3.min.js'></script>
<script>

    $.ajax({
        url:'/test',
        dataType:'json',
        data:{email:'123@qq.com'},
        success:function (response) {

        }
    })
</script>
</body>
</html>
