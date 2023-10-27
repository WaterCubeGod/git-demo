package com.wb.web.servlet;

import com.wb.pojo.WorkFlow;
import com.wb.service.WorkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/flowServlet")
public class FlowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String deptName = request.getParameter("deptName");

        WorkFlow workFlow = WorkService.selectFlow(deptName);
        String strTeacher = request.getParameter("teacher");
        String strSupervisor = request.getParameter("supervisor");
        String strDean = request.getParameter("dean");

        int teacher = 0;
        int supervisor = 0;
        int dean = 0;

        if(strTeacher == null){
            teacher = workFlow.getTeacher();
            supervisor = workFlow.getSupervisor();
            dean = workFlow.getDean();
        }else {
            if("1".equals(strTeacher)){
                teacher = 1;
            }

            if("1".equals(strSupervisor)){
                supervisor = 1;
            }

            if("1".equals(strDean)){
                dean = 1;
            }
        }


        int flow = WorkService.updateFlow(teacher,supervisor,dean,deptName);


        String teacher1 = "";
        String teacher2 = "";
        String supervisor1 = "";
        String supervisor2 = "";
        String dean1 = "";
        String dean2 = "";

        if(teacher == 1){
            teacher1 = "selected";
        }else{
            teacher2 = "selected";
        }

        if(supervisor == 1){
            supervisor1 = "selected";
        }else{
            supervisor2 = "selected";
        }

        if(dean == 1){
            dean1 = "selected";
        }else{
            dean2 = "selected";
        }


        //转发到manageFlow.jsp
        request.setAttribute("deptName",deptName);
        request.setAttribute("teacher1",teacher1);
        request.setAttribute("teacher2",teacher2);
        request.setAttribute("dean1",dean1);
        request.setAttribute("dean2",dean2);
        request.setAttribute("supervisor1",supervisor1);
        request.setAttribute("supervisor2",supervisor2);

        request.getRequestDispatcher("/manageFlow.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
