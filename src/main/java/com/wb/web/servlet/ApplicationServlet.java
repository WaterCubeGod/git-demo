package com.wb.web.servlet;

import com.wb.pojo.WorkFlow;
import com.wb.service.*;
import com.wb.utils.UpLoadFileUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;;


@WebServlet("/applicationServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ApplicationServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        // 获取上传文件的存储路径
        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        System.out.println(uploadFilePath);
        //获取表单其他参数
        String id = request.getParameter("id");
        String courseName = request.getParameter("courseName");
        String reason = request.getParameter("reason");



        //添加事务
        int eventCount = ApprovalEventService.addApprovalEvent(id,courseName,reason,"未审批");

        String eventId = ApprovalEventService.selectEventId();
        // 获取文件数据
        Part part = request.getPart("fileName");
        String fileName = UpLoadFileUtil.extractFileName(eventId,part);

        // 创建上传目录
        File fileUploadDirectory = new File(uploadFilePath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }

        // 获取文件大小
        long fileSizel = part.getSize();
        double fileSizeInDB = fileSizel / (1024.0 * 1024.0);
        String result = String.format("%.1f",fileSizeInDB);
        String fileSize = result + "MB";

        // 将文件保存到指定路径中
        String filePath = uploadFilePath + File.separator + fileName;
        part.write(filePath);



        //查找老师id
        String tId = ApprovalTeacherService.selectId(courseName);

        //加到老师上
        int teacherCount = ApprovalEventService.addApprovalTeacher(ApprovalEventService.selectEventId(),tId);
        //添加文件
        int fileCount = FileInfoService.addFile(ApprovalEventService.selectEventId(),fileName,fileSize);
        //加上工作事件
        WorkFlow workFlow = WorkService.selectFlow(CourseService.selectDept(courseName));
        int workCount = WorkService.addEvent(eventId,workFlow.getTeacher()-1,
                workFlow.getSupervisor()-1,workFlow.getDean()-1);
        //加上评论
        int comment = ApprovalEventService.addComment(eventId);
        if(eventCount !=0 && teacherCount !=0 && workCount != 0 && fileCount != 0 && comment != 0){
            //重定向
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/success.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}

