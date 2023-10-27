<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/3/28
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>申请免修不免考</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #F2F2F2;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #006699;
            color: #FFFFFF;
            margin: 0;
            padding: 20px;
            text-align: center;
        }

        form {
            background-color: #FFFFFF;
            border-radius: 5px;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
            margin: 30px auto;
            padding: 20px;
            max-width: 500px;
        }

        label {
            display: block;
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"], select {
            border: 1px solid #CCCCCC;
            border-radius: 3px;
            font-size: 16px;
            padding: 5px;
            width: 100%;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: #006699;
            border: none;
            border-radius: 5px;
            color: #FFFFFF;
            font-size: 16px;
            padding: 10px;
            width: 100%;
            cursor: pointer;
        }

        .back-link {
            margin-top: 30px;
            margin-bottom: 50px;
            text-align: center;
        }

        .back-link a, .view-progress a {
            color: #000;
            font-size: 14px;
            text-decoration: none;
            text-align: center;
        }

        .form-control {
            display: block;
            width: 472px;
            height: calc(1.5em + .75rem + 2px);
            padding: .375rem .75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            background-clip: padding-box;
            border: 1px solid #ced4da;
            border-radius: .25rem;
            transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
        }

        .form-control-file {
            display: block;
            width: 472px;
            padding: .375rem .75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            background-clip: padding-box;
            border: 1px solid #ced4da;
            border-radius: .25rem;
            transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
        }

        label {
            text-align: left;
        }

        .form-control:focus {
            color: #495057;
            background-color: #fff;
            border-color: #80bdff;
            outline: 0;
            box-shadow: 0 0 0 .2rem rgba(0,123,255,.25);
        }

        .form-control-file:focus {
            color: #495057;
            background-color: #fff;
            border-color: #80bdff;
            outline: 0;
            box-shadow: 0 0 0 .2rem rgba(0,123,255,.25);
        }
    </style>
</head>
<body>
<h1>申请免修不免考</h1>
<form action="/cc_war_exploded/updateServlet" method="post">
    <input type="text" name="eventId" value="${approvalReg.eventId}">
    <label >申请课程：</label>
    <input type="text" id="name" name="name" value="${approvalReg.courseName}" required>
    <div class="form-group">
        <label for="reason">申请理由:</label>
        <textarea class="form-control" id="reason" name="reason" rows="5">${approvalReg.reason}</textarea>
    </div>

    <%--        <div class="form-group">--%>
    <%--            <label for="file">上传文件:</label>--%>
    <%--            <input type="file" class="form-control-file" id="file" name="file">--%>
    <%--        </div>--%>
    <input type="submit" name = "modify" value="修改申请">
    <input type="submit" value="删除申请" name = "delete">
</form>
<div class="back-link">
    <a href="/cc_war_exploded/applicationLookServlet">返回</a>
</div>
</body>
</html>
