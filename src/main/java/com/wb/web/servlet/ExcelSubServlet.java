package com.wb.web.servlet;

import com.alibaba.excel.EasyExcel;
import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.ExcelSub;
import com.wb.service.ApprovalEventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/excelSub")
public class ExcelSubServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName= URLEncoder.encode("审批记录.xlsx","utf-8");
        response.setHeader("Content_disposition","attachment;filename="+fileName);

        List<ApprovalEvent> submissions = ApprovalEventService.selectAllEvent();
        ArrayList<ExcelSub> excelSubs=new ArrayList<>();
        for(int i=0;i<submissions.size();i++){
            ExcelSub excelSub=new ExcelSub();
            excelSub.setSubid(submissions.get(i).getEventId()+"");
            excelSub.setStuName(submissions.get(i).getId());
            excelSub.setCourseName(submissions.get(i).getCourseName());
            excelSub.setStartTime(submissions.get(i).getStartTime());
            excelSub.setEndTime(submissions.get(i).getEndTime());
            excelSub.setEventStatus(submissions.get(i).getEventStatus());
            excelSubs.add(excelSub);
        }
        System.out.println(excelSubs);
        EasyExcel.write(response.getOutputStream(),ExcelSub.class)
                .sheet("审批记录")
                .doWrite(excelSubs);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
