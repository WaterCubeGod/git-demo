<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/3/28
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>申请免修不免考</title>
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

        /*.form-reason {*/

        /*    display: inline-block;*/
        /*    margin: 10px auto;*/
        /*    width: 100px;*/
        /*    text-align: left;*/

        /*}*/

        /*.form-control {*/
        /*    margin: 10px auto;*/
        /*    width: 200px;*/
        /*    padding: 5px;*/
        /*    border-radius: 5px;*/
        /*    border: none;*/
        /*    box-shadow: 0 0 5px rgba(0,0,0,0.2);*/
        /*}*/

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
    <center>
        <form action="/cc_war_exploded/eventCommitServlet" method="post" accept-charset=“UTF-8”>
            <label>事件号：</label>
            <input type="text" id="eventId" name="eventId" value="${approvalReg.eventId}">
            <label>学号：</label>
            <input type="text" id="id" name="id" value="${approvalReg.id}">
            <label>姓名：</label>
            <input type="text" id="name" name="name" value="${approvalReg.name}">
            <label>学院：</label>
            <input type="text" id="dept_name" name="dept_name" value="${approvalReg.dept_name}">
            <label>课程：</label>
            <input type="text" id="course" name="courseName" value="${approvalReg.courseName}">
            <div class="form-group">
                <label class = "form-reason" for="reason">申请理由:</label>
                <textarea class="form-control" id="reason" name="reason" rows="5">${approvalReg.reason}</textarea>
            </div>

            <%--        <div class="form-group">--%>
            <%--            <label for="file">上传文件:</label>--%>
            <%--            <input type="file" class="form-control-file" id="file" name="file">--%>
            <%--        </div>--%>
            <input type="submit" name="pass" value="同意申请">
            <input type="submit" name="reject" value="拒绝申请">
        </form>
    </center>

<div class="back-link">
    <a href="/cc_war_exploded/approvalServlet">返回</a>
</div>
</body>
</html>
