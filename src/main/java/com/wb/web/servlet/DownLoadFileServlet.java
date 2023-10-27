package com.wb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/downLoadFileServlet")
public class DownLoadFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads"; // 上传文件保存的目录
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String fileName = request.getParameter("fileName"); // 获取请求参数中的文件名

        // 获取上传文件的存储路径
        String applicationPath = request.getServletContext().getRealPath("");
        String downloadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        System.out.println(downloadFilePath + File.separator + fileName);

        // 读取文件数据
        File file = new File(downloadFilePath + File.separator + fileName);
        FileInputStream inputStream = new FileInputStream(file);

        // 设置响应内容类型
        response.setContentType("application/octet-stream");
        // 设置响应头信息
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader(headerKey, headerValue);


        // 将文件内容写入响应输出流中
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();


        //转发到manageFlow.jsp
        request.getRequestDispatcher("/manageMain.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
