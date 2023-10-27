package com.wb.web.servlet;

import com.wb.pojo.*;
import com.wb.service.ApprovalEventService;
import com.wb.service.WorkService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/updateEventServlet")
public class UpdateEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取eventId
        String eventId = request.getParameter("eventId");
        ApprovalReg approvalReg = ApprovalEventService.selectById(eventId);
        ApprovalComment approvalComment = ApprovalEventService.selectComment(eventId);
        //转发到student.jsp
        request.setAttribute("approvalReg",approvalReg);
        request.setAttribute("approvalComment",approvalComment);
        request.getRequestDispatcher("/updateEvent.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
