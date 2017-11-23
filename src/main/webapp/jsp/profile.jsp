<%@ page import="ru.kfu.itis.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: siraziev.r
  Date: 17.11.2017
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: siraziev.r
  Date: 17.11.2017
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Imstagram</title>
    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/profile_style.css"/>">
</head>
<body>
<% User user = (User) request.getAttribute("user");%>

<!-- Navbar -->
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
                <li><a href="#">О нас</a></li>
                <li><a href="#">Контакты</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="feed">Лента</a></li>
                <li><a href="add">Загрузить фото</a></li>
                <li><a href="profile">Профиль</a></li>
                <li><a href="logout">Выход</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<!-- ACTUAL BODY -->
<div class="container">
    <div class="jumbotron">
        <div class="row profile_header">
            <div class="col-lg-3 profile_photo">
                <img src=<c:url value="file/${user.getPhoto()}"/> alt="" class="ava img-responsive img-circle">

            </div>
            <div class="col-lg-7 profile_info">
                <p><h2>Reenaz<a href="edit" class="btn btn-default edit_profile">Редактировать профиль</a></h2></p>
                <ul class="list-inline">
                    <li><h4><strong>${countOfPosts}</strong> публикаций</h4></li>
                    <li><h4><strong>${subscribersCount}</strong> подписчиков</h4><li>
                    <li><h4>Подписки: <strong>${countOfSignPerson}</strong></h4></li>
                </ul>
                <ul class="list-inline">
                    <li><h4><strong>${user.getName()}</strong></h4></li>
                    <li><h4>${user.getDescription()}</h4></li>
                </ul>
            </div>

        </div>
    </div>


    <div class="row">
        <c:forEach items="${posts}" var="post">
            <div class="col-lg-4 col-sm-6 ">
                <div class="thumbnail">
                    <img src="file/${post.getPhoto()}">
                </div>
            </div>
        </c:forEach>
    </div>
</div>

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



<script
        src="https://code.jquery.com/jquery-3.2.1.js"
        integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</div>
</body>
</html>

