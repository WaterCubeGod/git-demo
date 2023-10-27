package com.wb.web.servlet;


import com.wb.pojo.WorkFlow;
import com.wb.service.WorkService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/manageFlowServlet")
public class ManageFlowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String deptName = request.getParameter("deptName");
        WorkFlow workFlow = WorkService.selectFlow(deptName);
        //逻辑处理，决定图片
        int teacher = workFlow.getTeacher();
        int supervisor = workFlow.getSupervisor();
        int dean = workFlow.getDean();

        int count = 0;
        int x = 150;
        int y = 300;

        //Map数据转化为json
        Map<String,Object> node0 = new HashMap<>();
        Map<String,Object> node1 = new HashMap<>();
        Map<String,Object> node2 = new HashMap<>();
        Map<String,Object> node3 = new HashMap<>();
        Map<String,String> link1 = new HashMap<>();
        Map<String,String> link2 = new HashMap<>();
        Map<String,String> link3 = new HashMap<>();
        //节点数据与边数据
        List<Object> node = new ArrayList<>();
        List<Object> links = new ArrayList<>();
        Queue<String> nodesLink = new LinkedList<>();

        node0.put("name","提交申请");
        node0.put("x",x + count);
        count +=  75;
        node0.put("y",y);
        node0.put("symbol","roundRect");
        nodesLink.add("提交申请");
        node.add(node0);

        if(teacher == 1){
            node1.put("name","教师");
            node1.put("x",x + count);
            count +=  75;
            node1.put("y",y);
            node1.put("symbol","roundRect");
            nodesLink.add("教师");
            node.add(node1);
        }
        if(supervisor == 1){
            node2.put("name","主管");
            node2.put("x",x + count);
            count +=  75;
            node2.put("y",y);
            node2.put("symbol","roundRect");
            nodesLink.add("主管");
            node.add(node2);
        }
        if(dean == 1){
            node3.put("name","院长");
            node3.put("x",x + count);
            node3.put("y",y);
            node3.put("symbol","roundRect");
            nodesLink.add("院长");
            node.add(node3);
        }

        String nodea = nodesLink.remove();
        String nodeb = null;
        String nodec = null;
        String noded = null;

        if (!nodesLink.isEmpty()){
            nodeb = nodesLink.remove();
        }
        if (!nodesLink.isEmpty()){
            nodec = nodesLink.remove();
        }
        if (!nodesLink.isEmpty()){
            noded = nodesLink.remove();
        }

        if(nodec == null){
            link1.put("source",nodea);
            link1.put("target",nodeb);
            links.add(link1);
        }else{
            if(noded == null){
                link1.put("source",nodea);
                link1.put("target",nodeb);
                link2.put("source",nodeb);
                link2.put("target",nodec);
                links.add(link1);
                links.add(link2);
            }else {
                link1.put("source",nodea);
                link1.put("target",nodeb);
                link2.put("source",nodeb);
                link2.put("target",nodec);
                link3.put("source",nodec);
                link3.put("target",noded);
                links.add(link1);
                links.add(link2);
                links.add(link3);
            }
        }

        JSONArray nodes = JSONArray.fromObject(node);
        JSONArray link = JSONArray.fromObject(links);

        JSONArray data = new JSONArray();
        data.add(nodes);
        data.add(link);

        //转发到manageFlow.jsp
        response.getWriter().write(data.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

}
