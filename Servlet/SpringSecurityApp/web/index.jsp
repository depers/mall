<%--
  Created by IntelliJ IDEA.
  User: fengx9
  Date: 2022/7/29
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="https://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="https://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<h3>Home Page</h3>

<p>
    Hello <b><c:out value="${pageContext.request.remoteUser}"/></b><br>
    Roles: <b><sec:authentication property="principal.authorities" /></b>
</p>

<form action="logout" method="post">
    <input type="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
