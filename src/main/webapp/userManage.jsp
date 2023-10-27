<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/26
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理首页</title>
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
<h1>用户管理首页</h1>
<div id="table-container">
    <!-- 表格代码 -->
    <table>
        <tr>
            <th>身份</th>
            <th>人数</th>
            <th>详情</th>
        </tr>
            <tr>
                <td>学生</td>
                <td>${students}</td>
                <td><a href="userSearch?identity=student">查看详情</a></td>
            </tr>
        <tr>
            <td>老师</td>
            <td>${teachers}</td>
            <td><a href="userSearch?identity=teacher">查看详情</a></td>
        </tr>
        <tr>
            <td>主管</td>
            <td>${supervisors}</td>
            <td><a href="userSearch?identity=supervisor">查看详情</a></td>
        </tr>
        <tr>
            <td>院长</td>
            <td>${deans}</td>
            <td><a href="userSearch?identity=dean">查看详情</a></td>
        </tr>
    </table>
</div>

<div class="back-link">
    <a href="addUser.jsp">添加用户</a>
    <a href="manageMain.jsp">返回</a>
</div>
</body>
</html>
