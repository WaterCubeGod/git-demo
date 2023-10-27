package com.wb.web.servlet;

import com.wb.pojo.WorkEvent;
import com.wb.service.ApprovalEventService;
import com.wb.service.FileInfoService;
import com.wb.service.WorkService;
import com.wb.utils.UpLoadFileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取eventId
        String modify = request.getParameter("modify");
        String delete = request.getParameter("delete");
        String eventId = request.getParameter("eventId");
        String reason = request.getParameter("reason");
        WorkEvent workEvent = WorkService.selectEvent(eventId);

        if(modify != null){
            Date date =new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startTime = sdf.format(date);
            //修改申请
            ApprovalEventService.updateReason(reason,startTime,eventId);
            ApprovalEventService.updateStatus("未审批",eventId);
            ApprovalEventService.updateEndTime(null,eventId);
            if((workEvent.getTeacher() == 1) || (workEvent.getTeacher() == 2)){
                WorkService.updateTeacher(0,eventId);
            }
            if((workEvent.getSupervisor() == 1) || (workEvent.getSupervisor() == 2)){
                WorkService.updateSupervisor(0,eventId);
            }
            if((workEvent.getDean() == 1) || (workEvent.getDean() == 2)){
                WorkService.updateDean(0,eventId);
            }
        } else if (delete != null) {
            //删除申请
            String fileName = FileInfoService.selectFileName(eventId);
            WorkService.delete(eventId);
            FileInfoService.deleteFile(eventId,fileName);
            ApprovalEventService.deleteTeacher(eventId);
            ApprovalEventService.delete(eventId);
        }
        //转发到student.jsp
        request.getRequestDispatcher("/applicationLookServlet").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
