package com.wb.web.androidServlet;

import com.wb.pojo.WorkEvent;
import com.wb.service.ApprovalEventService;
import com.wb.service.FileInfoService;
import com.wb.service.WorkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/androidUpdate")
public class AndroidUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取eventId
        String eventId = request.getParameter("eventId");
        String reason = request.getParameter("reason");
        WorkEvent workEvent = WorkService.selectEvent(eventId);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sdf.format(date);
        //修改申请
        int flag1 = ApprovalEventService.updateReason(reason, startTime, eventId);
        int flag2 = ApprovalEventService.updateStatus("未审批", eventId);
        if ((workEvent.getTeacher() == 1) || (workEvent.getTeacher() == 2)) {
            WorkService.updateTeacher(0, eventId);
        }
        if ((workEvent.getSupervisor() == 1) || (workEvent.getSupervisor() == 2)) {
            WorkService.updateSupervisor(0, eventId);
        }
        if ((workEvent.getDean() == 1) || (workEvent.getDean() == 2)) {
            WorkService.updateDean(0, eventId);
        }
        System.out.println(1111111);
        if(flag1 != 0 && flag2 != 0){
            PrintWriter pw = response.getWriter();
            pw.print("success");
            pw.flush();
            pw.close();
        }else {
            PrintWriter pw = response.getWriter();
            pw.print("defeat");
            pw.flush();
            pw.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
