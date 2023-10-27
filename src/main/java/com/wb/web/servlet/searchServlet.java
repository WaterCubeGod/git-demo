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

@WebServlet("/search")
public class searchServlet extends HttpServlet {

    //查找审批事件
    List<ApprovalReg> approvalRegs = new ArrayList<>();

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
        approvalRegs.clear();
        //获取搜索内容
        String text = request.getParameter("search");

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
                        if(workEvent.getSupervisor() == 1 && workEvent.getDean() == 0){
                            approvalRegs.add(approvalReg);
                        }
                    }
                }
            }
        }

        List<ApprovalReg> approvalRegList = filterList(text);

        request.setAttribute("approvalRegs",approvalRegList);

        request.getRequestDispatcher("/approval.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }



    //过滤搜索
    private List<ApprovalReg> filterList(String text) {
        String[] words = text.split("\\s+");
        int count = 0;

        List<ApprovalReg> approvalRegList = new ArrayList<>();
        for(ApprovalReg approvalReg : approvalRegs){
            for(String word : words){
                if(approvalReg.getId().toLowerCase().contains(word.toLowerCase())){
                    count ++;
                    continue;
                }
                if(approvalReg.getName().toLowerCase().contains(word.toLowerCase())){
                    count ++;
                    continue;
                }
                if(approvalReg.getDept_name().toLowerCase().contains(word.toLowerCase())){
                    count ++;
                    continue;
                }
                if(approvalReg.getEventId().toLowerCase().contains(word.toLowerCase())){
                    count ++;
                    continue;
                }
                if(approvalReg.getCourseName().toLowerCase().contains(word.toLowerCase())){
                    System.out.println(approvalReg.getCourseName());
                    count ++;
                }
            }
            if(count == words.length){
                approvalRegList.add(approvalReg);
                System.out.println(approvalReg);
            }
            count = 0;
        }

        return approvalRegList;
    }
}
