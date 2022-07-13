<%@ page import="cn.bravedawn.servlet.model.User" %><%--
  Created by IntelliJ IDEA.
  User: fengx9
  Date: 2022/7/13
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<% User user = (User) session.getAttribute("User"); %>
<h3>Hi <% user.getName(); %></h3>
<strong>Your Email</strong>: <%=user.getEmail() %><br>
<strong>Your Country</strong>: <%=user.getCountry() %><br>
<br>
<form action="logout" method="post">
    <input type="submit" value="logout" >
</form>
</body>
</html>
