<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/1
  Time: 15:38
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
    <title>查看申请进程</title>
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
<h1>查看申请进程</h1>
<div id="table-container">
    <!-- 表格代码 -->
    <table>
        <tr>
            <th>申请ID</th>
            <th>课程名称</th>
            <th>申请时间</th>
            <th>审批结束时间</th>
            <th>审批进程</th>
            <th>详情</th>
        </tr>
        <c:forEach var="approvalEvent" items="${approvalEvents}">
            <tr>
                <td>${approvalEvent.eventId}</td>
                <td>${approvalEvent.courseName}</td>
                <td>${approvalEvent.startTime}</td>
                <td>${approvalEvent.endTime}</td>
                <td>${approvalEvent.eventStatus}</td>
                <td><a href="/cc_war_exploded/updateEventServlet?eventId=${approvalEvent.eventId}">查看详情</a></td>
            </tr>
        </c:forEach>
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

<div class="back-link">
    <a href="/cc_war_exploded/submitApplication">返回</a>
</div>
</body>
</html>

