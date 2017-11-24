<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Imstagram</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/feed_style.css">

</head>
<body>

!-- Navbar -->
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

<main>
    <div class="container">
        <div class="row">
            <c:forEach items="${posts}" var="post">
                <c:set var="user" value="${users.get(post.getUserId())}" />
                <div class="post col-md-6 col-md-offset-3">
                    <div class="row">
                        <div class="post_header col-md-12">


                            <p><img src="file/${user.getPhoto()}" alt="" class="ava img-responsive img-circle pull-left"> <a href="/user?userName=${user.getUserName()}"><strong>${user.getUserName()}</strong></a><br>
                                <small>${post.getLocation()}</small></p>


                        </div>
                        <div class="post_image col-md-12">
                            <img src="file/${post.getPhoto()}" class="img-responsive">
                        </div>
                        <div class="post_info col-md-12">
                            <c:if test="${likeMap.get(post.getId()) == 'unlike'}"><a href="like?postId=${post.getId()}&action=add"><img src="https://avatanplus.com/files/resources/original/57487beed2bb4154f3241d0f.png" class="img-responsive post_like_icon"></a></c:if>

                            <c:if test="${likeMap.get(post.getId()) == 'like'}"><a href="like?postId=${post.getId()}&action=delete"><img src="http://walljozz.com/images/instagram-heart-png-18.jpg" class="img-responsive post_like_icon"></a></c:if>

                            <p class="likes_count">${post.getLikesCount()}<strong> отметок "Нравится"</strong></p>
                            <p><strong>${user.getUserName()}: </strong>${post.getDescription()}</p>
                            <p class="post_date">${post.getDate()}</p>

                        </div>
                        <div class="comments col-md-12">
                            <c:forEach items="${post.getComments()}" var="comment">
                                <p><strong>${commentUserNameMap.get(comment.getId())}:</strong>${comment.getText()}<a class="del_comment" href="/comment?commentId=${comment.getId()}">удалить</a></p>
                            </c:forEach>
                        </div>
                        <div class="comment_area col-md-12">
                            <form action="/comment" method="POST" >
                                <input type="hidden" name="postId" value="${post.getId()}">
                                <div class="textarea col-md-8">
                                    <textarea name="comment" class="text_form form-control" placeholder="добавьте комментарий.." rows="2"></textarea>
                                </div>
                                <div class="send_btn_div col-md-4">
                                    <input type="submit" value="Отправить" class="send_btn form-control btn btn-default btn-lg btn-block">
                                </div>
                            </form>
                        </div>



                </div>
            </div>

            </c:forEach>


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