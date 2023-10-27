package com.wb.web.androidServlet;

import com.wb.pojo.*;
import com.wb.service.*;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/androidLoginServlet")
public class AndroidLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");//跨域访问
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        //1.接收用户名和密码
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        //获取checkbox数据
        String saveUsername = req.getParameter("saveUsername");
        //查找user
        Teacher teacher = TeacherService.selectUser(id,password);
        Student student = StudentService.selectUser(id,password);
        Dean dean = DeanService.selectUser(id,password);
        Supervisor supervisor = SupervisorService.selectUser(id,password);
        Manager manager = ManagerService.selectUser(id,password);

        if(teacher != null || student !=null || dean != null || supervisor != null || manager != null){
            //登录成功
            if(teacher != null){
                //将登陆成功的对象存储在session中
                String StringTeacher = String.valueOf(JSONObject.fromObject(teacher));
                //重定向
                PrintWriter pw = resp.getWriter();
                pw.print(StringTeacher);
                pw.flush();
                pw.close();
            }else if(student != null){
                //将登陆成功的对象存储在session中
                String StringStudent = String.valueOf(JSONObject.fromObject(student));
                //重定向
                PrintWriter pw = resp.getWriter();
                pw.print(StringStudent);
                pw.flush();
                pw.close();
            }else if(dean != null){
                //将登陆成功的对象存储在session中
                String StringDean = String.valueOf(JSONObject.fromObject(dean));
                //重定向
                PrintWriter pw = resp.getWriter();
                pw.print(StringDean);
                pw.flush();
                pw.close();
            }else if(supervisor != null){
                //将登陆成功的对象存储在session中
                String StringSupervisor = String.valueOf(JSONObject.fromObject(supervisor));
                //重定向
                PrintWriter pw = resp.getWriter();
                pw.print(StringSupervisor);
                pw.flush();
                pw.close();
            }
        }else{
            //登录失败

            PrintWriter pw = resp.getWriter();
            pw.print("defeat");
            pw.flush();
            pw.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
