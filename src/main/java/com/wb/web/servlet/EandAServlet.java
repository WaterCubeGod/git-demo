package com.wb.web.servlet;

import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.ApprovalReg;
import com.wb.pojo.FileInfo;
import com.wb.service.ApprovalEventService;
import com.wb.service.FileInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eandAServlet")
public class EandAServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取参数
        String eventId = request.getParameter("eventId");
        //获取文件名
        String fileName = FileInfoService.selectFileName(eventId);
        System.out.println(fileName);
        //获取事件
        ApprovalReg approvalReg = ApprovalEventService.selectById(eventId);
        //转发
        request.setAttribute("approvalReg",approvalReg);
        request.setAttribute("fileName",fileName);
        request.getRequestDispatcher("/approvalDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
