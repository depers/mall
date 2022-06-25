package cn.bravedawn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/6/21 22:05
 */

//@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.context.log("-----------------[AuthenticationFilter]-----------------start");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("[AuthenticationFilter] Request Resource--" + uri);

        HttpSession session = req.getSession(false);

        if (session == null && !(uri.endsWith("html") || uri.endsWith("LoginFilterServlet"))) {
            this.context.log("[AuthenticationFilter] Unauthorized access request");
            res.sendRedirect("LoginFilter.html");
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
        this.context.log("-----------------[AuthenticationFilter]-----------------end");
    }

    @Override
    public void destroy() {
        // close any resources here
    }
}
