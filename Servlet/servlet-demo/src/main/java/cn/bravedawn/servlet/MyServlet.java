package cn.bravedawn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : fengx9
 * @program : servlet-demo
 * @date : Created in 2022/05/27 5:02 PM
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet/my/a.html"})
public class MyServlet extends HttpServlet {

    /**
     * 为监听器编写的Servlet
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext ctx = req.getServletContext();
        ctx.setAttribute("User", "fengxiao");
        String user = (String) ctx.getAttribute("User");
        ctx.removeAttribute("User");

        HttpSession session = req.getSession();
        session.invalidate();

        PrintWriter out = resp.getWriter();
        out.write("Hi " + user);
    }
}
