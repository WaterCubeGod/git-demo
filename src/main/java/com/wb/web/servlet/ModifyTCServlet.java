package com.wb.web.servlet;

import com.wb.pojo.Course;
import com.wb.service.CourseService;
import com.wb.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyTC")
public class ModifyTCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String name = request.getParameter("course");

        Course course = CourseService.select(name);

        System.out.println(course);;

        int count = ManagerService.addTeaches(id,course.getCourseId());

        if(count > 0){

        }

        //转发到manageFlow.jsp
        request.getRequestDispatcher("/modifyRelationteacher?id=" + id).forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
