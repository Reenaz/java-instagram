
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE-edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="icon" type="image/png" href="/img/favicon.png">

  <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/login_style.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>">

  </head>
<body>
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

    </div>
  </div>
</nav>

  <main>
    <div class="container">
      <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
          <img src="img/instagram.png" class="img-responsive">
          <div class="account-wall">
            <img class="profile-img" src="img/non-auth-user.png"
                 alt="">
            <form class="form-signin" action="/" method="post">
              <input type="text" name="userName" class="form-control" placeholder="Имя пользователя" required autofocus>
              <input type="password" name="password" class="form-control" placeholder="Пароль" required>
              <button class="btn btn-lg btn-primary btn-block" type="submit">
                Войти</button>
              <label class="checkbox pull-left">
                <input type="checkbox" value="remember-me">
                Запомнить меня
              </label>
              <a href="#" class="pull-right need-help">Помощь </a><span class="clearfix"></span>
              <c:if test="${error == 'true'}"><h5 style="color:red">Неправильный логин или пароль</h5></c:if>

            </form>
          </div>
          <a href="/reg" class="text-center new-account">Создать аккаунт </a>
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


<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/js/jquery.min.js"/>"></script>
  </body>
</html>
