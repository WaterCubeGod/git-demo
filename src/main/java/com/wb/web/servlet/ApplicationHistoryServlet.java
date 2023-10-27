package com.wb.web.servlet;

import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.Student;
import com.wb.pojo.WorkEvent;
import com.wb.service.ApprovalEventService;
import com.wb.service.WorkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/applicationHistory")
public class ApplicationHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取session
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("user");
        //获取申请记录
        List<ApprovalEvent> approvalEvents = ApprovalEventService.selectApprovalEvent(student.getId(),null,null);

        List<ApprovalEvent> approvalEventList = new ArrayList<>();

        for (ApprovalEvent approvalEvent : approvalEvents) {
            WorkEvent workEvent = WorkService.selectEvent(approvalEvent.getEventId());
            if(workEvent.getTeacher() == 2 || workEvent.getSupervisor() == 2 || workEvent.getDean() == 2){
                approvalEventList.add(approvalEvent);
            }
        }



        //转发到viewApplications.jsp中
        request.setAttribute("approvalEvents",approvalEventList);

        request.getRequestDispatcher("/viewHistoryApplication.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
