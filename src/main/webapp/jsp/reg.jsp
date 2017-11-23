<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация</h1><br>
<form action="reg" method="post" enctype="multipart/form-data">
    <input name="userName" type="text" placeholder="userName">
    <input name="email" type="text" placeholder="email">
    <input name="password" type="password" placeholder="password">
    <input name="descr" type="text" placeholder="descr">
    <input name="name" type="text" placeholder="name">
    <fieldset> <legend><b>Выберите ваш пол</b></legend>
        <label><input type="radio" name="gender" value="1">male</label>
        <label><input type="radio" name="gender" value="2">female</label>
    </fieldset>
    <fieldset> <legend><b>Тип аккаунта</b></legend>
        <label><input type="radio" name="type" value="1">открытый</label>
        <label><input type="radio" name="type" value="2">закрытый</label>
    </fieldset>
    <input name="phoneNumber" type="text" placeholder="номер телефона">
    <input name="data" type="file"><br>
    <input type="submit"><br>
</form>
</body>
</html>
