package com.wb.web.servlet;

import com.wb.pojo.*;
import com.wb.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/eventViewServlet")
public class EventViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取id
        HttpSession session = request.getSession();
        Object user =  session.getAttribute("user");
        List<ApprovalReg> approvalRegs = new ArrayList<>();
        if(user instanceof Teacher){
            Teacher teacher = (Teacher)user;
            List<String> eventIds = ApprovalTeacherService.selectEventId(teacher.getId());

            for(int i = 0; i < eventIds.size(); i ++){
                ApprovalReg approvalReg = ApprovalEventService.selectById(eventIds.get(i));
                WorkEvent workEvent = WorkService.selectEvent(approvalReg.getEventId());
                //已审批的查看
                if(workEvent.getTeacher() == 1){
                    approvalReg.setResult("通过");
                    approvalRegs.add(approvalReg);
                } else if (workEvent.getTeacher() == 2) {
                    approvalReg.setResult("不通过");
                    approvalRegs.add(approvalReg);
                }
            }
        } else if (user instanceof Supervisor) {
            Supervisor supervisor = (Supervisor) user;
            //supervisor管理的老师的id
            List<String> teacherIds = SupervisorService.selectTeacher(supervisor.getId());
            for(int i = 0; i < teacherIds.size(); i ++){
                List<String> eventIds = ApprovalTeacherService.selectEventId(teacherIds.get(i));
                //事件id
                for(int j = 0; j < eventIds.size(); j ++){
                    ApprovalReg approvalReg = ApprovalEventService.selectById(eventIds.get(j));
                    WorkEvent workEvent = WorkService.selectEvent(approvalReg.getEventId());
                    //老师审批后,主管需要批
                    if(workEvent.getSupervisor() == 1){
                        approvalReg.setResult("通过");
                        approvalRegs.add(approvalReg);
                    }else if(workEvent.getSupervisor() == 2){
                        approvalReg.setResult("不通过");
                        approvalRegs.add(approvalReg);
                    }
                }
            }
            System.out.println(approvalRegs);
        } else if (user instanceof Dean) {
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
                        //老师审批后,主管需要批
                        if(workEvent.getDean() == 1){
                            approvalReg.setResult("通过");
                            approvalRegs.add(approvalReg);
                        }else if(workEvent.getDean() == 2){
                            approvalReg.setResult("不通过");
                            approvalRegs.add(approvalReg);
                        }
                    }
                }
            }
        }
        //转发到eventView.jsp
        request.setAttribute("approvalRegs",approvalRegs);
        request.getRequestDispatcher("/eventView.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
