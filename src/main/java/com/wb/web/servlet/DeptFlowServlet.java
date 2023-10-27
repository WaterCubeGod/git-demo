package com.wb.web.servlet;

import com.wb.pojo.WorkFlow;
import com.wb.service.WorkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deptFlowServlet")
public class DeptFlowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        List<WorkFlow> workFlows = WorkService.selectAllFlow();


        //转发到deptFlow.jsp
        request.setAttribute("workFlows",workFlows);
        request.getRequestDispatcher("/deptFlow.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
