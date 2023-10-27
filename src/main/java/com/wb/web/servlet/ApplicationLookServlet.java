package com.wb.web.servlet;

import com.wb.pojo.ApprovalComment;
import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.Student;
import com.wb.service.ApprovalEventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/applicationLookServlet")
public class ApplicationLookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取session
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("user");
        String page_str = request.getParameter("page");
        String page_Size = request.getParameter("pageSize");
        //默认页数
        Integer page = 1;
        //默认条数
        Integer pageSize = 10;
        //查找该学生已申请的项目
        List<ApprovalEvent> approvalEvents = new ArrayList<>();
        //总条数
        Integer total = ApprovalEventService.selectApprovalEvent(student.getId(),null,null).size();
        if(page_str == null||page_Size == null){
            approvalEvents = ApprovalEventService.selectApprovalEvent(student.getId(),page-1,pageSize);
        }else{
            page = Integer.valueOf(page_str);
            pageSize = Integer.valueOf(page_Size);
            if(page > total/pageSize){
                page--;
            }
            if(page < 1){
                page ++;
            }
            //获取开始条数
            Integer start = page;
            //获取截止条数
            Integer end =  pageSize;
            //获取最大页数
            Integer maxpage = total/pageSize;
            if(page>0&&pageSize>0){
                start = (page-1)*pageSize;
                end = start+pageSize;
            }
            if(page>maxpage){
                start = maxpage*pageSize;
                end = start+pageSize;
            }
            approvalEvents = ApprovalEventService.selectApprovalEvent(student.getId(),start,end);
        }
        //转发到viewApplications.jsp中
        request.setAttribute("approvalEvents",approvalEvents);
        request.setAttribute("page",page);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("total",total);
        request.getRequestDispatcher("/viewApplications.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
