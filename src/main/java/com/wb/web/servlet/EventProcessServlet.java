package com.wb.web.servlet;

import com.wb.pojo.ApprovalReg;
import com.wb.pojo.WorkEvent;
import com.wb.service.ApprovalEventService;
import com.wb.service.WorkService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/eventProcessServlet")
public class EventProcessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //根据进度确定样式
        String eventId = request.getParameter("eventId");
        ApprovalReg approvalReg = ApprovalEventService.selectById(eventId);
        WorkEvent workEvent = WorkService.selectEvent(eventId);
        //逻辑处理，决定图片
        int teacher = workEvent.getTeacher();
        int supervisor = workEvent.getSupervisor();
        int dean = workEvent.getDean();
        int count = 0;
        int x = 300;
        int y = 300;

        //Map数据转化为json
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
        //提交申请节点
        Map<String,Object> node0 = new HashMap<>();
        node0.put("name","提交申请");
        node0.put("x",x + count);
        count +=  150;
        node0.put("y",y);
        node0.put("symbol","roundRect");
        nodesLink.add("提交申请");
        node0.put("colors","#4CAF50");
        node.add(node0);

        if(teacher != -1){
            node1.put("name","教师");
            node1.put("x",x + count);
            count +=  150;
            node1.put("y",y);
            node1.put("symbol","roundRect");
            nodesLink.add("教师");
            node.add(node1);
            if(teacher == 1){
                node1.put("colors","#4CAF50");
            } else if (teacher == 2) {
                node1.put("colors","#DC143C");
            } else if (teacher == 0) {
                System.out.println(1);
                node1.put("colors","#a5e7f0");
            }
        }
        if(supervisor != -1){
            node2.put("name","主管");
            node2.put("x",x + count);
            count +=  150;
            node2.put("y",y);
            node2.put("symbol","roundRect");
            nodesLink.add("主管");
            node.add(node2);
            if(supervisor == 1){
                node2.put("colors","#4CAF50");
            } else if (supervisor == 2) {
                node2.put("colors","#DC143C");
            } else if (supervisor == 0) {
                node2.put("colors","#a5e7f0");
            }
        }
        if(dean != -1){
            node3.put("name","院长");
            node3.put("x",x + count);
            node3.put("y",y);
            node3.put("symbol","roundRect");
            nodesLink.add("院长");
            node.add(node3);
            if(dean == 1){
                node3.put("colors","#4CAF50");
            } else if (dean == 2) {
                node3.put("colors","#DC143C");
            } else if (dean == 0) {
                node3.put("colors","#a5e7f0");
            }
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
        JSONObject approval = JSONObject.fromObject(approvalReg);
        JSONArray data = new JSONArray();


        data.add(nodes);
        data.add(link);
        data.add(approval);

        //转发到manageFlow.jsp
        response.getWriter().write(data.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
