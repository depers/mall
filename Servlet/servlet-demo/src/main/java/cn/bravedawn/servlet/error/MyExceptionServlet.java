package cn.bravedawn.servlet.error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/7/9 15:40
 */

@WebServlet("/MyExceptionServlet")
public class MyExceptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw new ServletException("Get method is not supported.");
    }
}
