package com.wb.web.servlet;

import com.wb.pojo.CourseLicense;
import com.wb.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyCourseServlet")
public class ModifyCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String courseId = request.getParameter("courseId");
        String license = request.getParameter("permission");

        int count = CourseService.updateLicense(license,courseId);

        if(count == 1){
            //转发到UpdateCourseServlet
            request.getRequestDispatcher("/allCourseServlet").forward(request,response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
