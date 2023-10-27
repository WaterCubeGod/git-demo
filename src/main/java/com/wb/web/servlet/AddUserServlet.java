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

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String deptName = request.getParameter("dept_name");
        String identity = request.getParameter("identity");
        int count = 0;

        if(id != null && name != null && deptName != null && identity != null) {
            if("student".equals(identity)){
                Student student = new Student(id,name,"123456",deptName,identity);
                count = StudentService.addUser(student);
            } else if ("teacher".equals(identity)) {
                Teacher teacher = new Teacher(id,name,"123456",deptName,identity);
                count = TeacherService.addUser(teacher);
            } else if ("supervisor".equals(identity)) {
                Supervisor supervisor = new Supervisor(id,name,"123456",deptName,identity);
                count = SupervisorService.addUser(supervisor);
            } else if ("dean".equals(identity)) {
                Dean dean = new Dean(id,name,"123456",deptName,identity);
                count = DeanService.addUser(dean);
            }
        }

        if(count > 0){

        }

        //转发到manageFlow.jsp
        request.getRequestDispatcher("/addUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
