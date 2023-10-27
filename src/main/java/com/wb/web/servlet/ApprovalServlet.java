package com.wb.web.servlet;

import com.wb.pojo.*;
import com.wb.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/approvalServlet")
public class ApprovalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        /**
         * 审批：状态
         * 0：未开始审批
         * -1：不在审批流中
         * 1：审批通过
         * 2：审批不通过
         */

        //获取id
        HttpSession session = request.getSession();
        Object user =  session.getAttribute("user");
        //查找审批事件
        List<ApprovalReg> approvalRegs = new ArrayList<>();
        if(user instanceof Teacher){
            Teacher teacher = (Teacher)user;
            List<String> eventIds = ApprovalTeacherService.selectEventId(teacher.getId());
            //加入老师需要的审批
            for (int i = 0; i < eventIds.size(); i++) {
                ApprovalReg approvalReg = ApprovalEventService.selectById(eventIds.get(i));
                WorkEvent workEvent = WorkService.selectEvent(approvalReg.getEventId());
                if(workEvent.getTeacher() == 0){
                    approvalRegs.add(approvalReg);
                }
            }
        }else if(user instanceof Supervisor){
            Supervisor supervisor = (Supervisor)user;
            List<String> teacherIds = SupervisorService.selectTeacher(supervisor.getId());
            //下属老师
            for (int i = 0; i < teacherIds.size(); i++) {
                List<String> eventIds = ApprovalTeacherService.selectEventId(teacherIds.get(i));
                //加入主管需要的审批
                for (int j = 0; j < eventIds.size(); j++) {
                    ApprovalReg approvalReg = ApprovalEventService.selectById(eventIds.get(j));
                    WorkEvent workEvent = WorkService.selectEvent(approvalReg.getEventId());
                    //老师审批但主管还未审批
                    if(workEvent.getTeacher() == 1 && workEvent.getSupervisor() == 0){
                        approvalRegs.add(approvalReg);
                    }
                }
            }
        }else if (user instanceof Dean) {
            Dean dean = (Dean) user;
            //院长管理的主管的id
            List<String> supervisorIds = DeanService.selectSupervisor(dean.getId());
            for (int i = 0; i < supervisorIds.size(); i++) {
                //主管管理的老师的id
                List<String> teacherIds = SupervisorService.selectTeacher(supervisorIds.get(i));
                for (int j = 0; j < teacherIds.size(); j++) {
                    //事件id
                    List<String> eventIds = ApprovalTeacherService.selectEventId(teacherIds.get(j));
                    for(int k = 0; k < eventIds.size(); k ++){
                        ApprovalReg approvalReg = ApprovalEventService.selectById(eventIds.get(k));
                        WorkEvent workEvent = WorkService.selectEvent(approvalReg.getEventId());
                        //主管审批后,院长需要批
                        if( ((workEvent.getTeacher() == 1) || (workEvent.getTeacher() == -1)) &&
                                ((workEvent.getSupervisor() == 1) || (workEvent.getSupervisor() == -1))
                                && workEvent.getDean() == 0){
                            approvalRegs.add(approvalReg);
                        }
                    }
                }
            }
        }
        request.setAttribute("approvalRegs",approvalRegs);

        request.getRequestDispatcher("/approval.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
