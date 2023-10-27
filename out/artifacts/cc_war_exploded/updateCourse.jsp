<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/6
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改课程申请权限</title>
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
    <h1>修改课程申请权限</h1>
    <center>
        <form action="/cc_war_exploded/modifyCourseServlet" method="post" accept-charset=“UTF-8”>
            <label>课程id：</label>
            <input type="text" id="courseId" name="courseId" value="${courseLicense.courseId}">
            <label>课程名：</label>
            <input type="text" id="name" name="name" value="${courseLicense.name}">
            <div class="form-group">
                <label for="permission">权限：</label>
                <select id="permission" name="permission">
                    <option value="1" ${license1}>可申请</option>
                    <option value="0" ${license2}>不可申请</option>
                </select>
            </div>
            <div class="form-group">
                <button type="submit">保存修改</button>
            </div>
        </form>
    </center>


<div class="back-link">
    <a href="/cc_war_exploded/allCourseServlet">返回</a>
</div>
</body>
</html>
