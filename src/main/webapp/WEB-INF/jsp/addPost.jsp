<%--
  Created by IntelliJ IDEA.
  User: siraziev.r
  Date: 17.11.2017
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Добавление поста</h1><br>
<form action="add" method="post" enctype="multipart/form-data">
    <input name="description" type="text" placeholder="description">
    <br>
    <input name="location" type="text" placeholder="location">
    <br>
    <input name="photo" type="file"><br>
    <input type="submit"><br>
</form>

</body>
</html>
