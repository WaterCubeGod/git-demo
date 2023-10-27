package com.wb.web.servlet;

import com.wb.pojo.Supervisor;
import com.wb.pojo.Teacher;
import com.wb.service.ManagerService;
import com.wb.service.SupervisorService;
import com.wb.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/modifyManage")
public class ModifyManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        Teacher teacher = TeacherService.selectById(id);

        List<Supervisor> supervisors = SupervisorService.selectAll();

        String managerId = ManagerService.selectId(id);

        request.setAttribute("teacher",teacher);
        request.setAttribute("managerId",managerId);
        request.setAttribute("supervisors",supervisors);
        //转发到manageFlow.jsp
        request.getRequestDispatcher("/teacherTable.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
