<%@ page import="ru.kfu.itis.entity.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Instagram</title>

    <link rel="icon" type="image/png" href="/img/favicon.png">

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/profile_style.css"/>">

    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/get_subscribers.js"/>"></script>

</head>
<body>
<% User user = (User) request.getAttribute("user");%>

<div class="modal fade" id="image-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <div class="modal-title"><p><img src="file/${user.getPhoto()}" alt="" class="post_ava img-responsive img-circle pull-left"> <a href="/user?userName=${user.getUserName()}"><strong>${user.getUserName()}</strong></a><br>
                    <small>${post.getLocation()}</small></p></div>
            </div>
            <div class="modal-body">
                <img class="img-responsive center-block" src="" alt="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>

<div id="subsribers_modal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Заголовок модального окна -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Подписчики</h4>
            </div>
            <!-- Основное содержимое модального окна -->
            <div class="modal-body">
                <ul class="subscribers_list">
                    <li><h4>Список</h4></li>

                </ul>
            </div>


        </div>
    </div>
</div>

<div id="subsribed_person_modal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Заголовок модального окна -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Пользователи, на которых вы подписаны</h4>
            </div>
            <!-- Основное содержимое модального окна -->
            <div class="modal-body">

            </div>


        </div>
    </div>
</div>



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

<div class="container">
    <div class="jumbotron">
        <div class="row profile_header">
            <div class="col-lg-3 profile_photo">
                <img src=<c:url value="file/${user.getPhoto()}"/> alt="" class="ava img-responsive img-circle">

            </div>
            <div class="col-lg-7 profile_info">
                <p><h2>${user.getUserName()}<a href="edit" class="btn btn-default edit_profile">Редактировать профиль</a></h2></p>
                <ul class="list-inline">
                    <li><a href="#"><h4><strong>${countOfPosts}</strong> публикаций</h4></a></li>
                    <li><a href="#" id="get_sub" class="get_sub"><h4><strong>${subscribersCount}</strong> подписчиков</h4></a><li>
                    <li><a href="#"><h4>Подписки: <strong>${countOfSignPerson}</strong></h4></a></li></li>
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
                    <a class="thumbnail"><img src="file/${post.getPhoto()}"></a>
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

<script>
    $(function() {
        $('a.thumbnail').click(function(e) {
            e.preventDefault();
            $('#image-modal .modal-body img').attr('src', $(this).find('img').attr('src'));
            $("#image-modal").modal('show');
        });
        $('#image-modal .modal-body img').on('click', function() {
            $("#image-modal").modal('hide')
        });
    });
</script>

</body>
</html>

