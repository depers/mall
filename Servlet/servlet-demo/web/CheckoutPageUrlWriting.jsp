<%--
  Created by IntelliJ IDEA.
  User: depers
  Date: 2022/6/18
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<%
    //allow access only if session exists
    if(session.getAttribute("user") == null){
        response.sendRedirect("LoginHttpSession.html");
    }
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) {
                userName = cookie.getValue();
            }
        }
    }
%>
<h3>Hi <%=userName %>, do the checkout.</h3>
<br>
<form action="<%=response.encodeURL("LogoutUrlWritingServlet") %>" method="post">
    <input type="submit" value="Logout" >
</form>
</body>
</html>
