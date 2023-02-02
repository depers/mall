package cn.bravedawn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/6/21 21:53
 */

@WebFilter(filterName = "RequestLoggingFilter", urlPatterns = "/*")
public class RequestLoggingFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.context.log("-----------------[RequestLoggingFilter]-----------------start");
        HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> params = req.getParameterNames();
        while (params.hasMoreElements()) {
            String name = params.nextElement();
            String value = request.getParameter(name);
            this.context.log("[RequestLoggingFilter] " + req.getRemoteAddr() + "--Request Params--{" + name + "=" + value + "}");
        }

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                this.context.log("[RequestLoggingFilter] " + req.getRemoteAddr() + "--Cookie--{" + cookie.getName() + "," + cookie.getValue() + "}");
            }
        }

        // pass the request along the filter chain
        chain.doFilter(request, response);
        this.context.log("-----------------[RequestLoggingFilter]-----------------end");
    }

    @Override
    public void destroy() {
       // close any resources here
    }
}
