<%--
  Created by IntelliJ IDEA.
  User: Reenaz
  Date: 16.11.2017
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>HELLO MAN!</h1>
  <h3>Login</h3>
  <hr/>
  <form name=”loginForm” method=”POST” action=”LoginServlet”>
    <input type=”hidden” name=”command” value=”login” />
    Login:<br/>
    <input type=”text” name=”login” value=””>
    <br/>
    Password:<br/>
    <input type=”password” name=”password” value=””>
    <br/>
    <input type=”submit” value=”Enter”>
  </form>
  <hr/>
  </body>
</html>
