package com.wb.web.androidServlet;

import com.wb.pojo.WorkFlow;
import com.wb.service.*;
import com.wb.utils.UpLoadFileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/androidApplication")
public class AndroidApplicationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取表单其他参数
        String id = request.getParameter("id");
        String courseName = request.getParameter("courseName");
        String reason = request.getParameter("reason");


        //添加事务
        int eventCount = ApprovalEventService.addApprovalEvent(id,courseName,reason,"未审批");
        System.out.println(eventCount);

        String eventId = ApprovalEventService.selectEventId();

        //查找老师id
        String tId = ApprovalTeacherService.selectId(courseName);

        //加到老师上
        int teacherCount = ApprovalEventService.addApprovalTeacher(ApprovalEventService.selectEventId(),tId);
        //加上工作事件
        WorkFlow workFlow = WorkService.selectFlow(CourseService.selectDept(courseName));
        int workCount = WorkService.addEvent(eventId,workFlow.getTeacher()-1,
                workFlow.getSupervisor()-1,workFlow.getDean()-1);
        //加上评论
        int comment = ApprovalEventService.addComment(eventId);
        if(eventCount !=0 && teacherCount !=0 && workCount != 0 && comment != 0){
            //重定向
            PrintWriter pw = response.getWriter();
            pw.print("success");
            pw.flush();
            pw.close();
        }else{
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
