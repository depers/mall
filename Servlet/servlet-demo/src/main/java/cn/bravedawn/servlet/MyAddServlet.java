package cn.bravedawn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/10/4 9:13
 */
public class MyAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = null;
        try {
            printWriter = resp.getWriter();
            printWriter.println("验证通过“编码注册方式“将Servlet注册到容器中");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }

    }
}
