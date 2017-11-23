<%--
  Created by IntelliJ IDEA.
  User: Reenaz
  Date: 16.11.2017
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE-edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/login_style.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>">



  </head>
<body>
  <nav class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarcontent" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#"><img src="https://www.hyperpalace.com/wp-content/uploads/2017/08/white_instagram_text_logo1.png" class="img-responsive img_title"></a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="navbarcontent">
        <ul class="nav navbar-nav">
          <li><a href="#">About</a></li>
          <li><a href="#">Contact</a></li>
        </ul>

      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>

  <main>
    <div class="container">
      <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
          <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/640px-Instagram_logo.svg.png" class="img-responsive">
          <div class="account-wall">
            <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
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
        <a href='#'>ABOUT US</a>
        <a href='#'>SUPPORT</a>
        <a href='#'>BLOG</a>
        <a href='#'>PRESS</a>
        <a href='#'>API</a>
        <a href='#'>JOBS</a>
        <a href='#'>PRIVACY</a>
        <a href='#'>TERMS</a>
        <a href='#'>DIRECTORY</a>
        <a href='#'>LANGUAGE</a>
        <span id='copyright'>© 2017 INSTAGRAM</span>
      </div>
    </div>
  </div>
  </footer>

  <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/js/jquery.min.js"/>"></script>
  </body>
</html>
