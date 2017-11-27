<%@ page import="ru.kfu.itis.entity.User" %>

<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Imstagram</title>

    <link rel="icon" type="image/png" href="/img/favicon.png">

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="css/edit_profile_style.css">

    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="/js/bootstrap-filestyle.min.js"> </script>

</head>
<body>
<% User user = (User) request.getAttribute("user");%>

!-- Navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarcontent" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="img/logo.png" class="img-responsive img_title"></a>
        </div>

        <div class="collapse navbar-collapse" id="navbarcontent">
            <ul class="nav navbar-nav">
                <li><a href="#">О нас</a></li>
                <li><a href="#">Контакты</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="feed">Лента</a></li>
                <li><a href="add">Загрузить фото</a></li>
                <li><a href="profile">Профиль</a></li>
                <li><a href="logout">Выход</a></li>
            </ul>
        </div>
    </div>
</nav>

<main>
    <div class="container">
        <div class="row">
            <div class="title col-md-6 col-md-offset-3">
                <h1>Редактирование профиля</h1>
            </div>
            <div class="col-md-6 col-md-offset-3">
                <form action="edit" method="post" id="fileForm" role="form" enctype="multipart/form-data">
                    <fieldset>

                        <div class="form-group">

                            <div class="form-group">
                                <label for="phoneNumber"> </span> Номер телефона: </label>
                                <input class="form-control" type="text" name="phoneNumber" id = "phoneNumber" value="${user.getPhoneNumber()}" onkeyup = "Validate(this)" />
                            </div>

                            <div class="form-group">
                                <label for="email"> </span> E-mail: </label>
                                <input class="form-control" type="text" name="email" id = "email" value="${user.getEmail()}" />
                            </div>

                            <div class="form-group">
                                <label for="name"> </span> Имя: </label>
                                <input class="form-control" type="text" name="name" id = "name" value="${user.getName()}" />
                            </div>

                            <div class="form-group">
                                <label for="description"> </span> О себе:   </label>
                                <input class="form-control" type="text" name="description" id = "description" value="${user.getDescription()}" />
                            </div>

                            <div class="form-group">
                                <label for="password"><span class="req">* </span> Пароль: </label>
                                <input required name="password" type="password" class="form-control inputpass" minlength="6" maxlength="16"  id="password" /> </p>
                                <label for="new_password"></span> Новый пароль: </label>
                                <input  name="new_password" type="password" class="form-control inputpass" minlength="6" maxlength="16"  id="new_password" /> </p>

                                <label for="confirm_password"></span> Подтверждение нового пароля: </label>
                                <input  name="confirm_password" type="password" class="form-control inputpass" minlength="4" maxlength="16" id="confirm_password" onkeyup="checkPass(); return false;" />
                                <span id="confirmMessage" class="confirmMessage"></span>
                            </div>
                            <div class="form-group">
                                <label for="gender">Ваш пол:</label>
                                <fieldset class="choose_set" name="gender" id="gender">
                                    <label><input type="radio" name="gender"   value="1" checked> мужской </label>
                                    <label><input type="radio" name="gender" value="2"> женский </label>
                                </fieldset>
                            </div>
                            <div class="form-group">
                                <label for="type">Тип аккаунта:</label>
                                <fieldset class="choose_set" name="type" id="type">
                                    <label><input type="radio" name="type" value="1" checked> открытый </label>
                                    <label><input type="radio" name="type" value="2"> закрытый </label>
                                </fieldset>
                            </div>
                            <div class="from-group">
                                <label class="control-label">Выберите новое фото профиля</label>
                                <input type="file" name="photo" class="filestyle" data-input="false">
                            </div>

                            <div class="form-group">
                                <input class="btn btn-success reg_btn" type="submit" name="submit_reg" value="Обновить профиль">
                            </div>
                        </div>
                    </fieldset>
                </form><!-
            </div>
        </div>
    </div>
</main>

<footer><div class="container-fluid">
    <div class="row">
        <div class="col-sm-12" id="footer">
            <a href='#'>ПОДДЕРЖКА</a>
            <a href='#'>БЛОГ</a>
            <a href='#'>API</a>
            <a href='#'>ВАКАНСИИ</a>
            <a href='#'>ПРАВА</a>
            <a href='#'>УСЛОВИЯ</a>
            <span id='copyright'>© 2017 INSTAGRAM</span>
        </div>
    </div>
</div>
</footer>


</body>
</html>