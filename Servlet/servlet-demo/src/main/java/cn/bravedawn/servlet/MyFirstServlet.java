package cn.bravedawn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : servlet-demo
 * @description: simple servlet page
 * @date : Created in 2021/11/14 17:46
 */
public class MyFirstServlet extends HttpServlet {

    /**
     * 编写第一个Servlet示例
     * link: https://howtodoinjava.com/java/servlets/complete-java-servlets-tutorial/#write_simple_servlet
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            // write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyFirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet MyFirstServlet at " + req.getContextPath() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }


    @Override
    public String getServletInfo() {
        return "MyFirstServlet";
    }
}
