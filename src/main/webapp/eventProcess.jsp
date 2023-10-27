<%--
  Created by IntelliJ IDEA.
  User: 王彬
  Date: 2023/5/7
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>申请进程</title>
    <%-- 引入echarts文件 --%>
    <script src="js/echarts.js"></script>
    <!-- 引入jQuery库 -->
    <script src="js/jquery-3.6.4.js"></script>
</head>
<body>
<div>注：蓝色为未审批，绿色为审批通过，红色为审批不通过</div>
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<center>
    <div id="chart" style="width: 800px; height: 400px;"></div>
    <a href="applicationLookServlet">返回</a>
</center>
</body>
<script type="text/javascript">
    $.ajax({
        type:"get",
        url:"eventProcessServlet?eventId=${eventId}",
        success:function(data){
            var datas = JSON.parse(data);

            console.log(datas[0]);
            console.log(datas[1]);
            console.log(datas[2]);

            // 绘制echarts图表
            var chart = echarts.init(document.getElementById('chart'));

            // 配置图表
            var option = {
                title: {
                    text: '课程审批进度:' + datas[2].courseName,
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
                        itemStyle: {
                            normal: {
                                color: function(param){
                                    return datas[0][param.dataIndex].colors;
                                }
                            }
                        },
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
