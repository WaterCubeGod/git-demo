package com.wb.web.androidServlet;

import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.Course;
import com.wb.pojo.Student;
import com.wb.service.ApprovalEventService;
import com.wb.service.CourseService;
import com.wb.service.StudentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/androidSubmitApplication")
public class AndroidSubmitApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取id
        //1.接收用户名和密码
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Student student = StudentService.selectUser(id,password);
        System.out.println(student);
        //查找该学生已申请的项目
        List<ApprovalEvent> approvalEvents = ApprovalEventService.selectApprovalEvent(student.getId(),null,null);
        //查找courses
        List<Course> courses = CourseService.selectCourse(student.getId());
        for(int i=0;i<approvalEvents.size();i++){
            for (int j = 0; j < courses.size(); j++) {
                if(courses.get(j).getName().equals(approvalEvents.get(i).getCourseName())){
                    courses.remove(courses.get(j));
                    j--;
                }
            }
        }

        //重定向
        String coursesMsg = String.valueOf(JSONArray.fromObject(courses));
        System.out.println(coursesMsg);
        PrintWriter pw = response.getWriter();
        pw.print(coursesMsg);
        pw.flush();
        pw.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
