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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="chart" style="width: 800px; height: 600px;"></div>

<script>
    $(function() {
        // 使用axios从后端获取数据
        axios.get('/cc_war_exploded/manageFlowServlet')
            .then(function(response) {
                // 解析数据
                var data = response.data;

                // 绘制echarts图表
                var chart = echarts.init(document.getElementById('chart'));

                // 配置图表
                var option = {
                    title: {
                        text: '审批流程设计',
                        left: 'center',
                    },
                    tooltip: {},
                    legend: {
                        data: ['教师', '主管', '院长'],
                        top: 30,
                        left: 'left',
                    },
                    series: [
                        {
                            name: '审批流程',
                            type: 'graph',
                            layout: 'none',
                            symbolSize: 50,
                            roam: true,
                            label: {
                                show: true,
                            },
                            edgeSymbol: ['circle', 'arrow'],
                            edgeSymbolSize: [4, 10],
                            edgeLabel: {
                                fontSize: 20,
                            },
                            data: data.nodes,
                            links: data.links,
                            lineStyle: {
                                opacity: 0.9,
                                width: 2,
                                curveness: 0,
                            },
                        },
                    ],
                };

                // 渲染图表
                chart.setOption(option);
            })
            .catch(function(error) {
                console.log(error);
            });
    });
</script>




<%--<div id="main" style="width: 1000px;height:400px;">--%>
<%--    <script type="text/javascript">--%>
<%--        // 基于准备好的dom，初始化echarts实例--%>
<%--        var chartDom = document.getElementById('main');--%>
<%--        var myChart = echarts.init(chartDom);--%>
<%--        var option;--%>
<%--        option = {--%>
<%--            title: {--%>
<%--                text: '审批流程'--%>
<%--            },--%>
<%--            tooltip: {},--%>
<%--            animationDurationUpdate: 1500,--%>
<%--            animationEasingUpdate: 'quinticInOut',--%>
<%--            series: [--%>
<%--                {--%>
<%--                    type: 'graph',--%>
<%--                    layout: 'none',--%>
<%--                    symbolSize: 50,--%>
<%--                    roam: true,--%>
<%--                    label: {--%>
<%--                        show: true--%>
<%--                    },--%>


<%--                    edgeSymbol: ['roundRect', 'arrow'],--%>
<%--                    edgeSymbolSize: [4, 10],--%>
<%--                    edgeLabel: {--%>
<%--                        fontSize: 20--%>
<%--                    },--%>

<%--                    data: [--%>
<%--                        {--%>
<%--                            name: 'Node 1',--%>
<%--                            x: 300,--%>
<%--                            y: 300--%>
<%--                        },--%>
<%--                        {--%>
<%--                            name: 'Node 2',--%>
<%--                            x: 800,--%>
<%--                            y: 300--%>
<%--                        },--%>
<%--                        {--%>
<%--                            name: 'Node 3',--%>
<%--                            x: 550,--%>
<%--                            y: 300--%>
<%--                        },--%>
<%--                        {--%>
<%--                            name: 'Node 4',--%>
<%--                            x: 550,--%>
<%--                            y: 300--%>
<%--                        }--%>
<%--                    ],--%>
<%--                    // links: [],--%>
<%--                    links: [--%>
<%--                        {--%>
<%--                            source: 0,--%>
<%--                            target: 1,--%>
<%--                            symbolSize: [5, 20],--%>
<%--                            label: {--%>
<%--                                show: true--%>
<%--                            },--%>
<%--                            lineStyle: {--%>
<%--                                width: 5,--%>
<%--                                curveness: 0.2--%>
<%--                            }--%>
<%--                        },--%>
<%--                        {--%>
<%--                            source: 'Node 2',--%>
<%--                            target: 'Node 1',--%>
<%--                            label: {--%>
<%--                                show: true--%>
<%--                            },--%>
<%--                            lineStyle: {--%>
<%--                                curveness: 0.2--%>
<%--                            }--%>
<%--                        },--%>
<%--                        {--%>
<%--                            source: 'Node 1',--%>
<%--                            target: 'Node 3'--%>
<%--                        },--%>
<%--                        {--%>
<%--                            source: 'Node 2',--%>
<%--                            target: 'Node 3'--%>
<%--                        },--%>
<%--                        {--%>
<%--                            source: 'Node 2',--%>
<%--                            target: 'Node 4'--%>
<%--                        },--%>
<%--                        {--%>
<%--                            source: 'Node 1',--%>
<%--                            target: 'Node 4'--%>
<%--                        }--%>
<%--                    ],--%>
<%--                    lineStyle: {--%>
<%--                        opacity: 0.9,--%>
<%--                        width: 2,--%>
<%--                        curveness: 0--%>
<%--                    }--%>
<%--                }--%>
<%--            ]--%>
<%--        };--%>
<%--        // 使用刚指定的配置项和数据显示图表。--%>
<%--        myChart.setOption(option);--%>
<%--    </script>--%>
<%--</div>--%>
</body>
</html>
