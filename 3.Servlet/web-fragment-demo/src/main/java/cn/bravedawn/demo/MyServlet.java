package cn.bravedawn.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : web-fragment-demo
 * @description:
 * @date : Created in 2021/8/8 15:09
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            writer.print("");
            writer.print("");
            writer.print("This response is generated from the Plugged-in servlet");
            writer.print("");
            writer.print("");
            writer.flush();
        } catch (IOException e) {
            System.out.println("IO Exception");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
