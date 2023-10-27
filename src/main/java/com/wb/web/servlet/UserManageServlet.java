package com.wb.web.servlet;

import com.wb.pojo.*;
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

@WebServlet("/userManage")
public class UserManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        List<Student> students = StudentService.selectAll();
        List<Teacher> teachers = TeacherService.selectAll();
        List<Supervisor> supervisors = SupervisorService.selectAll();
        List<Dean> deans = DeanService.selectAll();

        int countStudent = students.size();
        int countTeacher = teachers.size();
        int countSupervisor = supervisors.size();
        int countDean = deans.size();

        request.setAttribute("students",countStudent);
        request.setAttribute("teachers",countTeacher);
        request.setAttribute("supervisors",countSupervisor);
        request.setAttribute("deans",countDean);
        //转发到manageFlow.jsp
        request.getRequestDispatcher("/userManage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
