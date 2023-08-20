package cn.bravedawn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : forward-example
 * @date : Created in 2022/9/8 21:17
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("userName");
        String password = request.getParameter("userPass");

        if (password.equals("servlet")) {
            RequestDispatcher rd = request.getRequestDispatcher("/welcome");
            rd.forward(request, response);
        } else{
            out.print("Sorry UserName or Password Error!");
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.include(request, response);
        }
        out.close();
    }
}
