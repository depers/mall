package cn.bravedawn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : fengx9
 * @program : servlet-demo
 * @date : Created in 2022/04/22 11:23 AM
 */

@WebServlet(name = "MySecondServlet", urlPatterns = {"/MySecondServlet"})
public class MySecondServlet extends HttpServlet {

    /**
     * 使用 @WebServlet注解声明取代 web.xml的配置
     * https://howtodoinjava.com/java/servlets/complete-java-servlets-tutorial/#webservlet_annotation
     *
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            // write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MySecondServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet MySecondServlet at " + req.getContextPath() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }


    // 返回一个String类型的字符串，其中包括了关于Servlet的信息，例如，作者、版本和版权。该方法返回的应该是纯文本字符串，而不是任何类型的标记。
    @Override
    public String getServletInfo() {
        return "MySecondServlet";
    }
}
