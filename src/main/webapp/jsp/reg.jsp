<%@ page import="ru.kfu.itis.entity.User" %>

<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Instagram</title>

    <link rel="icon" type="image/png" href="/img/favicon.png">


    <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg_style.css"/>">

    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap-filestyle.min.js"/>"> </script>
</head>
<body>

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
        </div>
    </div>
</nav>

<main>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <form action="" method="post" id="fileForm" role="form" enctype="multipart/form-data">
                    <fieldset>

                        <div class="form-group">
                            <label for="userName"><span class="req">* </span> Логин: </label>
                            <input required type="text" name="userName" id="userName" class="form-control phone" maxlength="28"  />
                        </div>

                        <div class="form-group">
                            <label for="phoneNumber"><span class="req">* </span> Номер телефона: </label>
                            <input class="form-control" type="text" name="phoneNumber" id = "phoneNumber" pattern="^((\+?7|8)[ \-] ?)?((\(\d{3}\))|(\d{3}))?([ \-])?(\d{3}[\- ]?\d{2}[\- ]?\d{2})$ " required />
                        </div>

                        <div class="form-group">
                            <label for="email"><span class="req">* </span> E-mail: </label>
                            <input class="form-control" type="text" name="email" id = "email"  required />
                        </div>

                        <div class="form-group">
                            <label for="name"><span class="req">* </span> Имя: </label>
                            <input class="form-control" required type="text" name="name" id = "name" />
                        </div>

                        <div class="form-group">
                            <label for="description"><span class="req">* </span> О себе:   </label>
                            <input class="form-control" type="text" name="description" id = "description"/>
                        </div>

                        <div class="form-group">
                            <label for="password"><span class="req">* </span> Пароль: </label>
                            <input required name="password" type="password" class="form-control inputpass" minlength="6" maxlength="20"  id="password" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"/>

                            <label for="confirm_password"><span class="req">* </span> Повтор пароля: </label>
                            <input required name="password" type="password" class="form-control inputpass" minlength="6" maxlength="20" placeholder="Enter again to validate"  id="confirm_password" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"/>
                        </div>
                        <div class="form-group">
                            <label for="gender">Ваш пол:</label>
                            <fieldset class="choose_set" name="gender" id="gender">
                                <label><input type="radio" name="gender"  value="1" checked> мужской </label>
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

                        <div class="form-group">
                            <input type="checkbox" required name="terms" id="terms">   <label for="terms">Я согласен с условиями регистрации</label><span class="req">* </span>
                        </div>
                        <div class="from-group">
                            <label class="control-label">Выберите фото профиля</label>
                            <input type="file" class="filestyle" name="data" data-input="false">
                        </div>

                        <div class="form-group">
                            <input class="btn btn-success reg_btn" type="submit" name="submit_reg" value="Register">
                        </div>
                    </fieldset>
                </form>
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