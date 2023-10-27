package com.wb.web.servlet;

import com.wb.pojo.Teacher;
import com.wb.service.ManagerService;
import com.wb.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/modifyTM")
public class ModifyTMServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String preManagerId = request.getParameter("managerId");
        String curManagerId = request.getParameter("curManagerId");
        String employeeId = request.getParameter("id");

        int delete = ManagerService.delete(preManagerId,employeeId);
        int add = ManagerService.add(curManagerId,employeeId);

        if(delete > 0 && add > 0){
            //转发到manageFlow.jsp
            request.getRequestDispatcher("/modifyManage?id=" + employeeId).forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
