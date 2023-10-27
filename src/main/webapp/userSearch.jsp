<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/26
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <style>
        body {
            font-family: "Open Sans", sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            margin-top: 30px;
            margin-bottom: 30px;
            text-align: center;
        }

        table {
            width: 60%;
            margin: 0 auto;
            background-color: #fff;
            border-collapse: collapse;
            border-radius: 5px;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
        }

        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ccc;
            font-size: 16px;
            font-family: "Open Sans", sans-serif;
        }

        th {
            background-color: #4CAF50;
            color: #fff;
            font-weight: bold;
        }

        .back-link {
            display: block;
            margin-top:
                    50px;
            text-align: center;
        }

        .back-link a {
            color: #000;
            text-decoration: none;
        }


        #pagination button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            margin: 0 5px;
            cursor: pointer;
            border-radius: 5px;
        }

        #pagination button:hover {
            background-color: #3e8e41;
        }

    </style>
</head>
<body>
<h1>${title}</h1>
<div id="table-container">
    <!-- 表格代码 -->
    <table>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>学院</th>
            <th>关系</th>
            <th>课程更改</th>
            <th>管理者更改</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.dept_name}</td>
                <td><a href="userRelationId?id=${user.id}&identity=${user.identity}">查看详情</a></td>
                <td><a href="modifyRelation${user.identity}?id=${user.id}">更改</a></td>
                <td><a href="modifyManage?id=${user.id}">更改</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="back-link">
    <a href="userManage">返回</a>
</div>
</body>
</html>
