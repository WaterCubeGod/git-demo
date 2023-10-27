package com.wb.web.androidServlet;

import com.wb.pojo.ApprovalReg;
import com.wb.service.ApprovalEventService;
import com.wb.service.FileInfoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/androidEandA")
public class AndroidEandAServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取参数
        String eventId = request.getParameter("eventId");
        System.out.println(eventId);
        //获取事件
        ApprovalReg approvalReg = ApprovalEventService.selectById(eventId);
        //转发
        String StringApprovalReg = String.valueOf(JSONObject.fromObject(approvalReg));
        System.out.println(StringApprovalReg);
        PrintWriter pw = response.getWriter();
        pw.print(StringApprovalReg);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
