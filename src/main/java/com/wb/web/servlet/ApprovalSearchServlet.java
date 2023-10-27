package com.wb.web.servlet;

import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.Student;
import com.wb.service.ApprovalEventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/approvalSearchServlet")
public class ApprovalSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取申请记录
        List<ApprovalEvent> approvalEvents = ApprovalEventService.selectAllEvent();

        //转发到viewApplications.jsp中
        request.setAttribute("approvalEvents",approvalEvents);

        request.getRequestDispatcher("/approvalSearch.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
