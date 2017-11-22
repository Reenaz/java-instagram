<%@ page import="ru.kfu.itis.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: siraziev.r
  Date: 17.11.2017
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user = (User) request.getAttribute("user");
String userName = user.getName();
%>
    <p>User: ${{userName}} </p>
</body>
</html>
