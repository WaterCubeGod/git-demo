package com.wb.web.filter;

import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求路径
        String url = request.getRequestURI();
        //1.2.3.是登录页面就放行，静态资源（image，js，css文件等，具体需要与目录对应）也放行 登录注册操作也放行
        if(url.contains("/login.jsp") || url.contains(".js") || url.contains(".image") ||
                url.contains(".css") || url.contains("/loginServlet")) {
            filterChain.doFilter(request,response);
            return;
        }
        //获取session,判断其是否登录
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if(user != null){
            filterChain.doFilter(request,response);
        } else{
            String login_msg = "您尚未登录";
            request.setAttribute("login_msg",login_msg);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    @Override
    public void destroy() {

    }
}
