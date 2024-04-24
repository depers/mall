package cn.bravedawn.servlet;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ServletJNDIByServerContext", urlPatterns = "/ServletJNDIByServerContext")
public class ServletJNDIByServerContext extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context ctx = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/serverContext/userDB");
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, name, email, country, password from users");


            response.setContentType("text/html");

            // 下面的这两句代码是等效的
            //response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");

            PrintWriter out = response.getWriter();
            out.print("<html><meta charset=\"UTF-8\"><body><h2>Employee Details</h2>");
            out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
            out.print("<th>Employee ID</th>");
            out.print("<th>Employee Name</th>");
            out.print("<th>Employee email</th>");
            out.print("<th>Employee country</th>");
            out.print("<th>Employee password</th>");

            while(rs.next()) {
                out.print("<tr>");
                out.print("<td>" + rs.getInt("id") + "</td>");
                out.print("<td>" + rs.getString("name") + "</td>");
                out.print("<td>" + rs.getString("email") + "</td>");
                out.print("<td>" + rs.getString("country") + "</td>");
                out.print("<td>" + rs.getString("password") + "</td>");
                out.print("</tr>");
            }
            out.print("</table></body><br/>");

            //lets print some DB information
            out.print("<h3>Database Details</h3>");
            out.print("Database Product: "+con.getMetaData().getDatabaseProductName()+"<br/>");
            out.print("Database Driver: "+con.getMetaData().getDriverName());
            out.print("</html>");

        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
                ctx.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (NamingException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
