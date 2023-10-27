<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/3/19
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
  <head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="css/LoginStyle.css">
  </head>
  <body>
  <div class="loginbox">
    <h1>账号登录</h1>
    <form action="/cc_war_exploded/loginServlet" method="get">
      <div id="user-error" class="error-message">${login_msg}</div>
      <p>账号</p>
      <input type="text" name="id" id="id" value="${cookie.id.value}" placeholder="工资号/学号">
      <p>密码</p>
      <input type="password" name="password" value="${cookie.password.value}" placeholder="输入密码">
      <div class="remember-me">
        <input type="checkbox" id="saveUsername" name="saveUsername">
        <label for="saveUsername">记住该账号</label>
      </div>
      <input type="submit" name="" value="登录">
      <a href="#">忘记密码</a>
    </form>
  </div>
  </body>
</html>
