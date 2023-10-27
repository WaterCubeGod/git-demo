package com.wb.web.androidServlet;

import com.wb.pojo.ApprovalAll;
import com.wb.pojo.ApprovalComment;
import com.wb.pojo.ApprovalReg;
import com.wb.service.ApprovalEventService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/androidUpdateEvent")
public class AndroidUpdateEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取eventId
        String eventId = request.getParameter("eventId");
        System.out.println(eventId);
        ApprovalReg approvalReg = ApprovalEventService.selectById(eventId);
        ApprovalComment approvalComment = ApprovalEventService.selectComment(eventId);
        ApprovalAll approvalAll = new ApprovalAll(eventId,approvalReg.getName(),approvalReg.getId(),
                approvalReg.getDept_name(),approvalReg.getCourseName(),approvalReg.getReason(),
                approvalComment.getTeacherComment(),approvalComment.getSupervisorComment(),
                approvalComment.getDeanComment());
        //返回数据
        String stringApprovalAll = String.valueOf(JSONObject.fromObject(approvalAll));
        System.out.println(stringApprovalAll);
        PrintWriter pw = response.getWriter();
        pw.print(stringApprovalAll);
        pw.flush();
        pw.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
