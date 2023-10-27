<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/26
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师管理</title>
    <style type="text/css">
        body {
            background-color: #f2f2f2;
        }
        h1 {
            text-align: center;
            margin-top: 50px;
        }
        form {
            text-align: center;
            background-color: #fff;
            width: 400px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        label {
            margin: 10px auto;
            display: inline-block;
            width: 100px;
            text-align: right;
        }
        input[type=text], select {
            margin: 10px auto;
            width: 200px;
            padding: 5px;
            border-radius: 5px;
            border: none;
            box-shadow: 0 0 5px rgba(0,0,0,0.2);
        }

        button[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin: auto;
        }

        button[type="submit"]:hover {
            background-color: #0062cc;
        }

        .back-link {
            margin-top: 20px;
            text-align: center;
        }

        .back-link a {
            color: #007bff;
            text-decoration: none;
        }

        .back-link a:hover {
            text-decoration: underline;
        }



    </style>
</head>
<body>
<h1>修改教师管理</h1>
<center>
    <form action="modifyTM" method="post" accept-charset=“UTF-8”>
        <label>老师id：</label>
        <input type="text" id="id" name="id" value="${teacher.id}">
        <label>老师姓名：</label>
        <input type="text" id="name" name="name" value="${teacher.name}">
        <label>管理者ID：</label>
        <input type="text" id="managerId" name="managerId" value="${managerId}">
        <div class="form-group">
            <label for="course">可选管理者：</label>
            <select id="course" name="curManagerId">
                <c:forEach var="supervisor" items="${supervisors}">
                    <option value="${supervisor.id}">${supervisor.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <button type="submit">修改管理者</button>
        </div>
    </form>
</center>


<div class="back-link">
    <a href="userSearch?identity=teacher">返回</a>
</div>
</body>
</html>
