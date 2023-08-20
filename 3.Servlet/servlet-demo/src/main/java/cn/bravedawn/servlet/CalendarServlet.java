package cn.bravedawn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/4/27 7:54
 */
@WebServlet(name = "CalendarServlet", urlPatterns = {"/CalendarServlet"})
public class CalendarServlet extends HttpServlet {

    /**
     * 在Servlet响应中返回动态内容
     * https://howtodoinjava.com/java/servlets/complete-java-servlets-tutorial/#write_dynamic_content
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> data = getData();


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CalendarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Hello " + data.get("username") + ", " + data.get("message") + "</h2>");
            out.println("<h2>The time right now is : " + new Date() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }


    private Map<String, String> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("username", "Guest");
        data.put("message", "Welcome to my world!!");
        return data;
    }


}
