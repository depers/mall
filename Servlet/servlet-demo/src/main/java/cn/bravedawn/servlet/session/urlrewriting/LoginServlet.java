package cn.bravedawn.servlet.session.urlrewriting;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/6/19 15:49
 */

@WebServlet("/LoginUrlWritingServlet")
public class LoginServlet extends HttpServlet {

    private final String userID = "fx";
    private final String password = "123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");


        if(userID.equals(user) && password.equals(pwd)){
            // 1.使用session
            HttpSession session = request.getSession();
            session.setAttribute("user", "我是冯晓2");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);

            // 2.使用cookie
            Cookie userName = new Cookie("user", user);
            response.addCookie(userName);

            // 3.使用url writing
            //Get the encoded URL string
            String encodedURL = response.encodeRedirectURL("LoginUrlWritingSuccess.jsp");
            response.sendRedirect(encodedURL);
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/LoginUrlWriting.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
