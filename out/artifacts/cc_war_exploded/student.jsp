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
    <form action="/cc_war_exploded/applicationServlet" method="post">
        <label for="id">学号：</label>
        <input type="text" id="id" name="id" value="${user.id}" required>
        <label for="name">姓名：</label>
        <input type="text" id="name" name="name" value="${user.name}" required>
        <label for="dept_name">学院：</label>
        <input type="text" id="dept_name" name="dept_name" value="${user.dept_name}" required>
        <label for="course">选择课程：</label>
        <select id="course" name="courseName" required>
        <option value="course">请选择课程</option>
            <c:forEach var="course" items="${courses}">
                <option value="${course.name}">${course.name}</option>
            </c:forEach>
        </select>
        <div class="form-group">
            <label for="reason">申请理由:</label>
            <textarea class="form-control" id="reason" name="reason" rows="5"></textarea>
        </div>
        <div>
            <!-- 文件选择和上传按钮 -->
            <input type="file" id="fileSelecter"><button onclick="uploadFile()">上传</button>

            <!-- 上传逻辑 -->
            <script>
                function uploadFile() {
                    // 找到文件文件选择框
                    var fileInput = document.querySelector("#fileSelecter");
                    // 获取选择的文件
                    // (因为input是支持选择多个文件的，所以获取文件通过files字段，如果单个文件也是在这个files列表里。)
                    var file = fileInput.files.item(0);

                    // 判断一下
                    if (file == null) {
                        // 没有选择文件。就什么都不处理。
                        return;
                    }

                    // 使用FileReader读取文件。
                    var fileReader = new FileReader();

                    fileReader.addEventListener("error", function (ev) {
                        // 文件读取出错时，执行此方法。
                        // 通过 fileReader.error 可以获取到错误信息。
                        alert('文件上传失败！');
                    });

                    fileReader.addEventListener("load", function (ev) {
                        // 文件读取成功后调用此方法。
                        // 通过 fileReader.result 即可获取到文件内容。
                        alert('文件上传成功！');
                    });

                    fileReader.addEventListener("loadstart", function (ev) {
                        // 读取开始时此方法被调用。

                    });

                    fileReader.addEventListener("loadend", function (ev) {
                        // 文件读取结束时执行此方法。
                        // 无论读取成功，还是读取失败。
                        // 总之，在结束读文件操作时，此方法都会调用。

                    });

                    fileReader.addEventListener("abort", function (ev) {
                        // 文件读取被中断时，此方法调用。
                        // 你可以通过 fileReader.abort() 方法随时中断文件的读取。
                    });

                    fileReader.addEventListener("progress", function (ev) {
                        // 读取文件过程不是一次性读完的，会进行多次读取。
                        // 没读取一次，本方法执行一次。
                    });

                    // 将文件内容读取为 base64 内容。通过 fileReader.result 即可返回base64的数据内容。
                    fileReader.readAsDataURL(file);
                }
            </script>
        </div>

<%--        <div class="form-group">--%>
<%--            <label for="file">上传文件:</label>--%>
<%--            <input type="file" class="form-control-file" id="file" name="file">--%>
<%--        </div>--%>
        <input type="submit" value="提交申请">
    </form>
    <a href="/cc_war_exploded/applicationLookServlet">查看申请进度</a>
    <div class="back-link">
        <a href="login.jsp">返回</a>
    </div>
</body>
</html>

