<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/2/10
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>test json</h2>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script>
        function ajaxTest() {
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/json/test2",
                data:'[{"age":18,"date":"2020-19-10","id":1,"name":"张三"},{"age":28,"date":"2020-19-10","id":2,"name":"李四"}]',
                dataType:"json",
                contentType:"application/json",
                success:function (ret) {
                    console.log(ret)
                }
            })
        }
    </script>
    <input type="button" value="向/json/test2提交一个json" onclick="ajaxTest()">
</body>
</html>
