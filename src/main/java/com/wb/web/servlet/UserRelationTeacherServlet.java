package com.wb.web.servlet;

import com.wb.pojo.Teacher;
import com.wb.service.CourseService;
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

@WebServlet("/userRelationteacher")
public class UserRelationTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        Teacher teacher = TeacherService.selectById(id);

        List<String> courseIds = TeacherService.selectCourseName(id);

        List<String> courseNames = new ArrayList<>();

        int size = courseIds.size();

        for (String courseId:courseIds) {
            String courseName = CourseService.selectById(courseId);
            courseNames.add(courseName);
        }

        int x = 800;
        int y = 100;

        List<Map<String,Object>> nodes = new ArrayList<>();
        List<Map<String,Object>> links = new ArrayList<>();

        Map<String,Object> teacherNode = new HashMap<>();

        teacherNode.put("name",teacher.getName());
        teacherNode.put("x",x);
        teacherNode.put("y",y);
        teacherNode.put("symbol","roundRect");
        nodes.add(teacherNode);
        if(size !=0){
            x = 600 - (size/2) * (600/size);
            y = 500;
        }


        for (String courseName : courseNames) {
            Map<String,Object> node = new HashMap<>();
            //加节点
            node.put("name",courseName);
            node.put("x",x);
            node.put("y",y);
            node.put("symbol","roundRect");
            nodes.add(node);
            //加连接
            Map<String,Object> link = new HashMap<>();
            link.put("source",teacher.getName());
            link.put("target",courseName);
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
