package cn.bravedawn.servlet.cookie;

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
 * @date : Created in 2022/6/29 23:36
 */

@WebServlet("/cookie/GetCookie")
public class GetCookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static int count = 0;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Cookie[] requestCookies = req.getCookies();

        out.write("");
    }
}
