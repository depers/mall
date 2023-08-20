<%--
  Created by IntelliJ IDEA.
  User: depers
  Date: 2022/6/19
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<%
    // allow access only if session exists
    String user = null;
    // 我们使用会话属性来验证用户是否已经登录
    if (session.getAttribute("user") == null) {
        response.sendRedirect("LoginUrlWriting.html");
    } else {
        user = (String) session.getAttribute("user");
    }

    String userName = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                userName = cookie.getValue();
            }
            if (cookie.getName().equals("JSESSIONID")) {
                sessionId = cookie.getValue();
            }
        }
    } else {
        sessionId = session.getId();
    }
%>

<h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionId %></h3>
<br>
User=<%=user %>
<br>

<!-- need to encode all the URLs where we want session information to be passed -->
<a href="<%=response.encodeURL("CheckoutPageUrlWriting.jsp") %>">Checkout Page</a>
<form action="<%=response.encodeURL("LogoutUrlWritingServlet") %>" method="post">
    <input type="submit" value="Logout" >
</body>
</html>
