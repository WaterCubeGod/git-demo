package com.wb.web.servlet;

import com.wb.pojo.*;
import com.wb.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        //1.接收用户名和密码
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        //解决中文乱码:GET,获取参数的方式:getQueryString
        id = new String(id.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
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
             //判断用户是否勾选记住该账号
            if("on".equals(saveUsername)){
                //发送cookie
                //创建cookie
                Cookie c_username = new Cookie("id",id);
                Cookie c_password = new Cookie("password",password);
                //设置cookie存活时间
                c_username.setMaxAge(60 * 60 * 24 * 7);
                c_password.setMaxAge(60 * 60 * 24 * 7);
                //发送
                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }
            if(teacher != null){
                //将登陆成功的对象存储在session中
                HttpSession session = req.getSession();
                session.setAttribute("user",teacher);
                //重定向
                String contextPath = req.getContextPath();
                resp.sendRedirect(contextPath+"/approvalServlet");
            }else if(student != null){
                //将登陆成功的对象存储在session中
                HttpSession session = req.getSession();
                session.setAttribute("user",student);
                //重定向
                String contextPath = req.getContextPath();
                resp.sendRedirect(contextPath+"/submitApplication");
            }else if(dean != null){
                //将登陆成功的对象存储在session中
                HttpSession session = req.getSession();
                session.setAttribute("user",dean);
                //重定向
                String contextPath = req.getContextPath();
                resp.sendRedirect(contextPath+"/approvalServlet");
            }else if(supervisor != null){
                //将登陆成功的对象存储在session中
                HttpSession session = req.getSession();
                session.setAttribute("user",supervisor);
                //重定向
                String contextPath = req.getContextPath();
                resp.sendRedirect(contextPath+"/approvalServlet");
            }else if(manager != null){
                //将登陆成功的对象存储在session中
                HttpSession session = req.getSession();
                session.setAttribute("user",manager);
                //重定向
                String contextPath = req.getContextPath();
                resp.sendRedirect(contextPath+"/manageMainServlet");
            }

        }else{
            //登录失败

            //存储错误信息到request中
            req.setAttribute("login_msg","工资号/学号或密码错误");

            //跳转到login.jsp
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

}
