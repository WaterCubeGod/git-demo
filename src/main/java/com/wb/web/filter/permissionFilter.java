package com.wb.web.filter;

import com.wb.pojo.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("")
public class permissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取请求路径
        String url = request.getRequestURI();

        //1.2.3.是登录页面就放行，静态资源（image，js，css文件等，具体需要与目录对应）也放行 登录注册操作也放行
        if(url.contains("/login.jsp") || url.contains(".js") || url.contains(".image") ||
                url.contains(".css") || url.contains(".login") || url.contains("/reg")) {
            filterChain.doFilter(request,response);
            return;
        }

        //登录成功，根据用户类型分类
        Object user = request.getSession().getAttribute("user");
        //不同用户权限区分
        if(user instanceof Student) {
            if (url.contains("/approval.jsp") || url.contains("/eandAServlet") || url.contains("/eventView.jsp") ||
                    url.contains("/eventViewServlet") || url.contains("/approvalDetail.jsp") ||
                    url.contains("/eventCommitServlet") || url.contains("/manageFlowServlet") || url.contains("/manageFlow.jsp")) {
                response.getWriter().print("<script language='javascript'>" +
                        "alert('此用户无权访问该页面！');" +
                        "window.location.href='login.jsp';</script>')");
                System.out.println("此用户无权访问该页面！");
                return;
            }
        } else if(user instanceof Teacher || user instanceof Supervisor || user instanceof Dean) {
            if (url.contains("/student.jsp") || url.contains("/applicationServlet") || url.contains("/success.jsp") ||
                    url.contains("/applicationLookServlet") || url.contains("/viewApplications.jsp") ||
                    url.contains("/updateEventServlet") || url.contains("/updateEvent.jsp") ||
                    url.contains("/updateServlet") || url.contains("/manageFlowServlet") || url.contains("/manageFlow.jsp")) {
                response.getWriter().print("<script language='javascript'>" +
                        "alert('此用户无权访问该页面！');" +
                        "window.location.href='login.jsp';</script>')");
                System.out.println("此用户无权访问该页面！");
                return;
            }
        } else if(user instanceof Manager){
            if(url.contains("/approval.jsp") || url.contains("/eandAServlet") || url.contains("/eventView.jsp") ||
                    url.contains("/eventViewServlet") || url.contains("/approvalDetail.jsp") ||
                    url.contains("/eventCommitServlet") || url.contains("/student.jsp") ||
                    url.contains("/applicationServlet") || url.contains("/success.jsp") ||
                    url.contains("/applicationLookServlet") || url.contains("/viewApplications.jsp") ||
                    url.contains("/updateEventServlet") || url.contains("/updateEvent.jsp") ||
                    url.contains("/updateServlet")){
                response.getWriter().print("<script language='javascript'>" +
                        "alert('此用户无权访问该页面！');" +
                        "window.location.href='login.jsp';</script>')");
                System.out.println("此用户无权访问该页面！");
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
