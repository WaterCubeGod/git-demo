<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/6
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html>
<head>
  <title>管理员首页</title>
  <link rel="stylesheet" type="text/css" href="css/manageMain.css">
</head>
<body>
<header>
  <h1>管理员首页</h1>
</header>
<nav>
  <ul>
    <li><a href="allCourseServlet">修改课程申请权限</a></li>
    <li><a href="approvalSearchServlet">查看审批记录</a></li>
    <li><a href="deptFlowServlet">修改审批流程</a></li>
    <li><a href="userManage">管理用户</a></li>
  </ul>
</nav>
<footer>
  <p>版权所有 &copy; 2023</p>
</footer>
</body>
</html>
