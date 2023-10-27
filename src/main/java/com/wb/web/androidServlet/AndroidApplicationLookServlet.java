package com.wb.web.androidServlet;

import com.wb.pojo.ApprovalEvent;
import com.wb.pojo.Student;
import com.wb.service.ApprovalEventService;
import com.wb.service.StudentService;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Select;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/androidApplicationLook")
public class AndroidApplicationLookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取session
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Student student = StudentService.selectUser(id,password);
        System.out.println(student);
        //获取申请记录
        List<ApprovalEvent> approvalEvents = ApprovalEventService.selectApprovalEvent(student.getId(),null,null);

        //返回数据
        String approvalEventMsg = String.valueOf(JSONArray.fromObject(approvalEvents));
        System.out.println(approvalEventMsg);
        PrintWriter pw = response.getWriter();
        pw.print(approvalEventMsg);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
