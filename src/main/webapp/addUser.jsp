<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/26
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
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


        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin: auto;
        }


        input[type="submit"]:hover {
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
        .form-group {
            display: flex;
            align-items: center;
            margin-bottom: 10px; /* 可选，用于设置表单组件之间的间距 */
        }

        .form-reason {
            display: inline-block;
            margin: 10px auto;
            width: 80px;
            text-align: left;
        }

        .form-control {
            width: 210px;
            padding: 10px;
            font-size: 8px;
            line-height: 1.5;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }
    </style>
</head>
<body>
<h1>添加用户</h1>
<center>
    <form action="addUser" method="post" accept-charset=“UTF-8”>
        <label>ID：</label>
        <input type="text" id="id" name="id" >
        <label>姓名：</label>
        <input type="text" id="name" name="name">
        <label>学院：</label>
        <input type="text" id="dept_name" name="dept_name">
        <label>身份：</label>
        <select id="identity" name="identity" required>
            <option value="identity">请选择身份</option>
            <option value="student">学生</option>
            <option value="teacher">教师</option>
            <option value="supervisor">主管</option>
            <option value="dean">院长</option>
        </select>
        <input type="submit" name="add" value="添加用户">
    </form>
</center>

<div class="back-link">
    <a href="userManage">返回</a>
</div>
</body>
</html>
