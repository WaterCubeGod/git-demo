package com.wb.web.servlet;

import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.Course;
import com.wb.pojo.Student;
import com.wb.service.ApprovalEventService;
import com.wb.service.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/submitApplication")
public class SubmitApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取id
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("user");
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

        //转发到student.jsp
        request.setAttribute("courses",courses);
        request.getRequestDispatcher("/student.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
