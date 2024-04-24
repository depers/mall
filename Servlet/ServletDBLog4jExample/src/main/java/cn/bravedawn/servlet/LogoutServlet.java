package cn.bravedawn.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Logout", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    static Logger log = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    log.info("JSESSIONID = " + cookie.getValue());
                    break;
                }
            }
        }

        HttpSession session = request.getSession(false);
        log.info("User = " + session.getAttribute("User"));
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.html");
    }
}
