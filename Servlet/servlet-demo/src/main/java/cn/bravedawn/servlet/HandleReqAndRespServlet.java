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
 * @date : Created in 2022/04/27 10:04 AM
 */
@WebServlet(name = "HandleReqAndRespServlet", urlPatterns = {"/handleReqAndResp"})
public class HandleReqAndRespServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean success = false;
        if (username != null && password != null) {
            success = true;
        }

        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");

            if(success) {
                out.println("<h2>Welcome Friend </h2>");
                out.println("<h3 style=\"color:red\">" + username + "</h3>");
            }else{
                out.println("<h2>Validate your self again.</h2>");
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
