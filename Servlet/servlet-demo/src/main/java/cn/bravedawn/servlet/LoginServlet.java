package cn.bravedawn.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/6/16 13:19
 */
@WebServlet(urlPatterns = "/LoginServlet",
            initParams = {
                @WebInitParam(name = "user", value = "depers"),
                @WebInitParam(name = "password", value = "fx1212")
            })
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        if(getServletContext().getInitParameter("dbURL").equals("jdbc:mysql://localhost/mysql_db") &&
                getServletContext().getInitParameter("dbUser").equals("mysql_user") &&
                getServletContext().getInitParameter("dbUserPwd").equals("mysql_pwd")) {
            getServletContext().setAttribute("DB_Success", "True");
        } else {
            throw new ServletException("DB Connection error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        //get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        //logging example
        log("User="+user+"::password="+pwd);


        if(userID.equals(user) && password.equals(pwd)){
            response.sendRedirect("LoginSuccess.jsp");
        }else{
            // 获取/login.html Servlet的引用
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            // 在响应中包含资源(servlet、JSP页面、HTML文件)的内容
            rd.include(request, response);

        }
    }
}
