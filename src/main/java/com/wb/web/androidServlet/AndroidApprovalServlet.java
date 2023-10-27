package com.wb.web.androidServlet;

import com.wb.pojo.*;
import com.wb.service.*;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/androidApproval")
public class AndroidApprovalServlet extends HttpServlet {
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
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Teacher teacher = TeacherService.selectUser(id,password);
        Supervisor supervisor = SupervisorService.selectUser(id,password);
        Dean dean = DeanService.selectUser(id,password);
        //查找审批事件
        List<ApprovalReg> approvalRegs = new ArrayList<>();
        if(teacher != null){
            List<String> eventIds = ApprovalTeacherService.selectEventId(teacher.getId());
            //加入老师需要的审批
            for (int i = 0; i < eventIds.size(); i++) {
                ApprovalReg approvalReg = ApprovalEventService.selectById(eventIds.get(i));
                WorkEvent workEvent = WorkService.selectEvent(approvalReg.getEventId());
                if(workEvent.getTeacher() == 0){
                    approvalRegs.add(approvalReg);
                }
            }
        }else if(supervisor != null){
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
        }else if (dean != null) {
            //院长管理的主管的id
            List<String> supervisorIds = DeanService.selectSupervisor(dean.getId());
            System.out.println(supervisorIds);
            for (int i = 0; i < supervisorIds.size(); i++) {
                //主管管理的老师的id
                List<String> teacherIds = SupervisorService.selectTeacher(supervisorIds.get(i));
                System.out.println(teacherIds);
                for (int j = 0; j < teacherIds.size(); j++) {
                    //事件id
                    List<String> eventIds = ApprovalTeacherService.selectEventId(teacherIds.get(j));
                    for(int k = 0; k < eventIds.size(); k ++){
                        ApprovalReg approvalReg = ApprovalEventService.selectById(eventIds.get(k));
                        WorkEvent workEvent = WorkService.selectEvent(approvalReg.getEventId());
                        //主管审批后,院长需要批
                        if(workEvent.getSupervisor() == 1 && workEvent.getDean() == 0){
                            approvalRegs.add(approvalReg);
                        }
                    }
                }
            }
        }
        String approvalRegList = String.valueOf(JSONArray.fromObject(approvalRegs));
        PrintWriter pw = response.getWriter();
        pw.print(approvalRegList);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
