package com.wb.web.servlet;

import com.wb.pojo.CourseLicense;
import com.wb.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String courseName = request.getParameter("courseName");
        CourseLicense courseLicense = CourseService.selectName(courseName);
        String license1 = "";
        String license2 = "";
        if("1".equals(courseLicense.getLicense())){
            license1 = "selected";
        }else{
            license2 = "selected";
        }

        //转发到manageFlow.jsp
        request.setAttribute("license1",license1);
        request.setAttribute("license2",license2);
        request.setAttribute("courseLicense",courseLicense);
        request.getRequestDispatcher("/updateCourse.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
