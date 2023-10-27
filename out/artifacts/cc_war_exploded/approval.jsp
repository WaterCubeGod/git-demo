<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/2
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>审批页面</title>
    <style>
        form {
            display: inline-block;
            margin-right: 10px;
        }

        label {
            display: inline-block;
            margin-right: 5px;
        }

        input[type="text"],
        input[type="submit"] {
            display: inline-block;
            vertical-align: middle;
            margin-right: 5px;
            padding: 5px;
            font-size: 16px;
            line-height: 1.5;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0069d9;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
        }

        #pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
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
<h1>待审批列表</h1>

<form method="get" action="/approvalServlet">
    <label>按学生姓名筛选:</label>
    <input type="text" name="studentName">
    <input type="submit" value="筛选">
</form>
<form method="get" action="/approvalServlet">
    <label>按课程名称筛选:</label>
    <input type="text" name="courseName">
    <input type="submit" value="筛选">
</form>
<form method="get" action="/approvalServlet">
    <label>按审批时间筛选:</label>
    <input type="date" name="approvalTime">
    <input type="submit" value="筛选">
</form>
<br>

<div id="table-container">
    <table>
        <tr>
            <th>学生姓名</th>
            <th>学生号</th>
            <th>学院</th>
            <th>课程</th>
            <th>申请理由</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${approvalRegs}" var="courseLicense">
            <tr>
                <td>${courseLicense.name}</td>
                <td>${courseLicense.id}</td>
                <td>${courseLicense.dept_name}</td>
                <td>${courseLicense.courseName}</td>
                <td>${courseLicense.reason}</td>
                <td><a href="/cc_war_exploded/eandAServlet?eventId=${courseLicense.eventId}">查看详情</a></td>
            </tr>
        </c:forEach>
        <a href="/cc_war_exploded/eventViewServlet">查看审批记录</a>
    </table>
</div>

<div id="pagination"></div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        var table = $('#table-container table');
        var rows = table.find('tr:gt(0)');
        var perPage = 5;
        var totalPages = Math.ceil(rows.length / perPage);

        function showPage(page) {
            var start = (page - 1) * perPage;
            var end = start + perPage;
            rows.hide().slice(start, end).show();
        }

        for (var i = 1; i <= totalPages; i++) {
            $('#pagination').append('<button data-page="' + i + '">' + i + '</button>');
        }

        $('#pagination').on('click', 'button', function() {
            var page = $(this).data('page');
            showPage(page);
        });

        showPage(1);
    });
</script>


</body>
</html>

