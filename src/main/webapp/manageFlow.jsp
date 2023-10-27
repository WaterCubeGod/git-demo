<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/4
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改审批流</title>

    <%-- 引入echarts文件 --%>
    <script src="js/echarts.js"></script>
    <!-- 引入jQuery库 -->
    <script src="js/jquery-3.6.4.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<center>
    <form action="flowServlet" method="post" accept-charset=“UTF-8”>
        <input name="deptName" value=${deptName}>
        <div class="form-group">
            <label for="teacher">老师：</label>
            <select id="teacher" name="teacher">
                <option value="1" ${teacher1}>参与审批</option>
                <option value="0" ${teacher2}>不参与审批</option>
            </select>
        </div>
        <div class="form-group">
            <label for="supervisor">主管：</label>
            <select id="supervisor" name="supervisor">
                <option value="1" ${supervisor1}>参与审批</option>
                <option value="0" ${supervisor2}>不参与审批</option>
            </select>
        </div>
        <div class="form-group">
            <label for="dean">院长：</label>
            <select id="dean" name="dean">
                <option value="1" ${dean1}>参与审批</option>
                <option value="0" ${dean2}>不参与审批</option>
            </select>
        </div>
        <div class="form-group">
            <label for="supervisorName">已参与审批主管：</label>
            <select id="supervisorName" name="supervisorName">
                <c:forEach var="user" items="${users}">
                        <td>${user.name}</td>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <button type="submit">保存修改</button>
        </div>
    </form>



    <div id="chart" style="width: 800px; height: 600px;"></div>
    <a href="deptFlowServlet">返回</a>
</center>

</body>
<script type="text/javascript">
    $.ajax({
        type:"get",
        url:"manageFlowServlet?deptName=${deptName}",
        success:function(data){

            var datas = JSON.parse(data);
            console.log(datas[0]);
            console.log(datas[1]);
            // 绘制echarts图表
            var chart = echarts.init(document.getElementById('chart'));

            // 配置图表
            var option = {
                title: {
                    text: '审批流程设计',
                    left: 'center'
                },
                tooltip: {},
                legend: {
                    data: ['教师', '主管', '院长'],
                    top: 30,
                    left: 'left'
                },
                series: [
                    {
                        name: '审批流程',
                        type: 'graph',
                        layout: 'none',
                        symbolSize: 50,
                        roam: true,
                        label: {
                            show: true
                        },
                        edgeSymbol: ['roundRect', 'arrow'],
                        edgeSymbolSize: [4, 10],
                        edgeLabel: {
                            fontSize: 20
                        },
                        data: datas[0],
                        links: datas[1],
                        lineStyle: {
                            opacity: 0.9,
                            width: 2,
                            curveness: 0
                        }
                    }
                ]
            };
            // 渲染图表
            chart.setOption(option);

        }
    });
</script>
</html>
