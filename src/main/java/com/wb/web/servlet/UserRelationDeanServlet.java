package com.wb.web.servlet;

import com.wb.pojo.Dean;
import com.wb.pojo.Supervisor;
import com.wb.pojo.Teacher;
import com.wb.service.DeanService;
import com.wb.service.SupervisorService;
import com.wb.service.TeacherService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/userRelationdean")
public class UserRelationDeanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        Dean dean = DeanService.selectById(id);

        List<String> supervisorsId = DeanService.selectSupervisor(dean.getId());

        List<Supervisor> supervisors = new ArrayList<>();

        for (String supervisorId : supervisorsId) {
            Supervisor supervisor = SupervisorService.selectById(supervisorId);
            supervisors.add(supervisor);
//            List<String> strings = SupervisorService.selectTeacher(supervisorId);
//            for (String string : strings) {
//                teachersId.add(string);
//            }
        }

//        List<Teacher> teachers = new ArrayList<>();
//
//        for (String teacherId : teachersId) {
//            Teacher teacher = TeacherService.selectById(teacherId);
//            teachers.add(teacher);
//        }

        int size = supervisors.size();

        int x = 800;
        int y = 100;

        List<Map<String,Object>> nodes = new ArrayList<>();
        List<Map<String,Object>> links = new ArrayList<>();

        Map<String,Object> teacherNode = new HashMap<>();

        teacherNode.put("name",dean.getName());
        teacherNode.put("x",x);
        teacherNode.put("y",y);
        teacherNode.put("symbol","roundRect");
        nodes.add(teacherNode);
        if(size !=0){
            x = 600 - (size/2) * (600/size);
            y = 500;
        }


        for (Supervisor supervisor : supervisors) {
            Map<String,Object> node = new HashMap<>();
            //加节点
            node.put("name",supervisor.getName());
            node.put("x",x);
            node.put("y",y);
            node.put("symbol","roundRect");
            nodes.add(node);
            //加连接
            Map<String,Object> link = new HashMap<>();
            link.put("source",dean.getName());
            link.put("target",supervisor.getName());
            links.add(link);

            x = x + 1200/size;
        }

        JSONArray node = JSONArray.fromObject(nodes);
        JSONArray link = JSONArray.fromObject(links);

        JSONArray data = new JSONArray();
        data.add(node);
        data.add(link);


        //转发到manageFlow.jsp
        response.getWriter().write(data.toString());


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
