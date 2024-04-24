package cn.bravedawn.servlet.session.cookies;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/6/18 17:32
 */
@WebServlet("/LoginSessionServlet")
public class LoginSessionServlet extends HttpServlet {

    private final String userID = "fx";
    private final String password = "123";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get request parameter for user and pwd
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");


        if (userID.equals(user) && password.equals(pwd)) {
            Cookie loginCookie = new Cookie("user", user);
            loginCookie.setMaxAge(30 * 60);
            resp.addCookie(loginCookie);
            resp.sendRedirect("LoginSessionSuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginSession.html");
            PrintWriter out= resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req, resp);
        }
    }
}
