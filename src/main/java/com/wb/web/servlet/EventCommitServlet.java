package com.wb.web.servlet;

import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.ApprovalReg;
import com.wb.pojo.WorkEvent;
import com.wb.service.ApprovalEventService;
import com.wb.service.WorkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/eventCommitServlet")
public class EventCommitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取参数
        String eventId = request.getParameter("eventId");
        String pass = request.getParameter("pass");
        String reject = request.getParameter("reject");
        String comment = request.getParameter("comment");
        //获取事件
        WorkEvent workEvent = WorkService.selectEvent(eventId);
        //修改事件
        if(pass != null){
            //审批通过
            if(workEvent.getTeacher() == 0){
                workEvent.setTeacher(1);
                //更新数据
                WorkService.updateTeacher(workEvent.getTeacher(),eventId);
                ApprovalEventService.updateStatus("教师审批通过",eventId);
                ApprovalEventService.updateTeacherComment(comment,eventId);
            }else if((workEvent.getSupervisor() == 0) && (workEvent.getTeacher() != 2)){
                workEvent.setSupervisor(1);
                //更新数据
                WorkService.updateSupervisor(workEvent.getSupervisor(),eventId);
                ApprovalEventService.updateStatus("主任审批通过",eventId);
                ApprovalEventService.updateSupervisorComment(comment,eventId);
            }else if((workEvent.getDean() == 0) && (workEvent.getSupervisor() != 2)
                    && (workEvent.getTeacher() != 2)){
                workEvent.setDean(1);
                //更新数据
                WorkService.updateDean(workEvent.getDean(),eventId);
                ApprovalEventService.updateStatus("院长审批通过",eventId);
                ApprovalEventService.updateDeanComment(comment,eventId);
            }
        } else if (reject != null) {
            //审批不通过
            if(workEvent.getTeacher() == 0){
                workEvent.setTeacher(2);
                //更新数据
                WorkService.updateTeacher(workEvent.getTeacher(),eventId);
                ApprovalEventService.updateStatus("教师审批未通过",eventId);
                ApprovalEventService.updateTeacherComment(comment,eventId);
            }else if(workEvent.getSupervisor() == 0){
                workEvent.setSupervisor(2);
                //更新数据
                WorkService.updateSupervisor(workEvent.getSupervisor(),eventId);
                ApprovalEventService.updateStatus("主任审批未通过",eventId);
                ApprovalEventService.updateSupervisorComment(comment,eventId);
            }else if(workEvent.getDean() == 0){
                workEvent.setDean(2);
                //更新数据
                WorkService.updateDean(workEvent.getDean(),eventId);
                ApprovalEventService.updateStatus("院长审批未通过",eventId);
                ApprovalEventService.updateDeanComment(comment,eventId);
            }
            //拒绝，事务直接中止
            Date date =new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String endTime = sdf.format(date);
            ApprovalEventService.updateEndTime(endTime,eventId);
        }
        //查看事务是否完成提交，更改结束事件
        if((workEvent.getTeacher() != 0) && (workEvent.getSupervisor() != 0) && (workEvent.getDean() != 0)){
            Date date =new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String endTime = sdf.format(date);
            ApprovalEventService.updateEndTime(endTime,eventId);
        }

        //转发
        request.getRequestDispatcher("/approvalServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
