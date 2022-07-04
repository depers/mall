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
 * @date : Created in 2022/6/29 23:35
 */
@WebServlet("/cookie/SetCookie")
public class SetCookieServlet extends HttpServlet {

    private static int count = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Cookie[] requestCookies = request.getCookies();

        out.write("<html><head></head><body>");
        out.write("<h3>Hello Browser!!</h3>");

        if (requestCookies != null) {
            out.write("<h3>Request Cookies:</h3>");

            for (Cookie c : requestCookies) {
                out.write(
                        "Name=" + c.getName()
                        + ", Value=" + c.getValue()
                        + ", Comment=" + c.getComment()
                        + ", Domain=" + c.getDomain()
                        + ", MaxAge=" + c.getMaxAge()
                        + ", Path=" + c.getPath()
                        + ", Version=" + c.getVersion());
                out.write("<br>");
            }
        }

        // Set cookies for counter, accessible to only this servlet
        count++;
        Cookie counterCookie = new Cookie("Counter", String.valueOf(count));
        // add some description to be viewed in browser cookie viewer
        counterCookie.setComment("SetCookie Counter");
        // setting max age to be 1 day
        counterCookie.setMaxAge(24 * 60 * 60);
        // set path to make it accessible to only this servlet
        counterCookie.setPath("/cookie/SetCookie");
        // adding cookie to the response
        response.addCookie(counterCookie);

        // set a domain specific cookie
        Cookie domainCookie = new Cookie("Test", "TestCookie" + String.valueOf(count));
        domainCookie.setComment("Test Cookie");
        response.addCookie(domainCookie);

        out.write("</body></html>");
    }
}
