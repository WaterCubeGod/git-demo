<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/12
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="androidLoginServlet" method="post" accept-charset=“UTF-8”>

    <label>学号：</label>
    <input type="text" id="id" name="id" value="">
    <label>密码：</label>
    <input type="text" id="password" name="password" value="">

    <input type="submit" name="pass" value="同意申请">
</form>
</body>
</html>
