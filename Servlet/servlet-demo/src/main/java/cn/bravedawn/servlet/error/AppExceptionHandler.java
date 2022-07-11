package cn.bravedawn.servlet.error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/7/9 15:28
 */

/**
 * Servlet异常处理
 * 教程地址：https://www.journaldev.com/1973/servlet-exception-and-error-handling-example-tutorial
 */
@WebServlet("/AppExceptionHandler")
public class AppExceptionHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }


    private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // analyze the servlet exception
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {
            servletName = "Unknown";
        }

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        // set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html><head><title>Exception/Error Details</title></head><body>");
        if (statusCode != 500) {
            out.write("<h3>Error Details</h3>");
            out.write("<strong>Status Code</strong>: " + statusCode + "<br>");
            out.write("<strong>Requested URI</strong>: " + requestUri);
        } else {
            out.write("<h3>Exception Details</h3>");
            out.write("<ul><li>Servlet Name: " + servletName + "</li>");
            out.write("<li>Exception Name: " + throwable.getClass().getName() + "</li>");
            out.write("<li>Requested URI: " + requestUri + "</li>");
            out.write("<li>Exception Message: " + throwable.getMessage() + "</li>");
            out.write("</ul>");
        }

        out.write("<br><br>");
        out.write("<a href=\"index.html\">Home Page</a>");
        out.write("</body></html>");

    }
}
