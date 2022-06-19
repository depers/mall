package cn.bravedawn.servlet.session.httpsession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/6/18 18:12
 */
@WebServlet("/LoginHttpSessionServlet")
public class LoginHttpSessionServlet extends HttpServlet {

    private final String userID = "fx";
    private final String password = "123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if (userID.equals(user) && password.equals(pwd)) {
            HttpSession session = request.getSession();
            // 设置会话属性
            session.setAttribute("user", "我叫冯晓");
            // setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30 * 60);

            Cookie userNameCookie = new Cookie("user", user);
            userNameCookie.setMaxAge(30*60);
            response.addCookie(userNameCookie);
            response.sendRedirect("LoginHttpSessionSuccess.jsp");

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/LoginHttpSession.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }

    }
}
