package com.wb.web.servlet;

import com.wb.pojo.Dean;
import com.wb.pojo.Student;
import com.wb.pojo.Supervisor;
import com.wb.pojo.Teacher;
import com.wb.service.DeanService;
import com.wb.service.StudentService;
import com.wb.service.SupervisorService;
import com.wb.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userSearch")
public class UserSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String identity = request.getParameter("identity");


        if("student".equals(identity)){
            List<Student> students = StudentService.selectAll();
            request.setAttribute("users",students);
            request.setAttribute("title","学生列表");
            //转发到manageFlow.jsp
            request.getRequestDispatcher("/userSearch.jsp").forward(request,response);
        } else if("teacher".equals(identity)){
            List<Teacher> teachers = TeacherService.selectAll();
            request.setAttribute("users",teachers);
            request.setAttribute("title","老师列表");
            //转发到manageFlow.jsp
            request.getRequestDispatcher("/userSearch.jsp").forward(request,response);
        } else if("supervisor".equals(identity)){
            List<Supervisor> supervisors = SupervisorService.selectAll();
            request.setAttribute("users",supervisors);
            request.setAttribute("title","主管列表");
            //转发到manageFlow.jsp
            request.getRequestDispatcher("/userSearch.jsp").forward(request,response);
        } else if("dean".equals(identity)){
            List<Dean> deans = DeanService.selectAll();
            request.setAttribute("users",deans);
            request.setAttribute("title","院长列表");
            //转发到manageFlow.jsp
            request.getRequestDispatcher("/userSearch.jsp").forward(request,response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
