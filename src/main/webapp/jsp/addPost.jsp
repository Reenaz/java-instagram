
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Imstagram</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/addPost_style.css"/>">
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap-filestyle.min.js"/>"> </script>

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
            <div class="title col-md-6 col-md-offset-3">
                <h1>Добавление записи</h1>
            </div>
            <div class="col-md-6 col-md-offset-3">
                <form action="add" method="post" id="fileForm" role="form" enctype="multipart/form-data">
                    <fieldset>

                        <div class="form-group">
                            <label for="description"><span class="req">* </span> Description:</label>
                            <input required type="text" name="description" id="description" class="form-control phone" maxlength="28" onkeyup="validatephone(this);" />
                        </div>

                        <div class="form-group">
                            <label for="location"><span class="req">* </span> Location: </label>
                            <input class="form-control" type="text" name="location" id = "location" onkeyup = "Validate(this)" required />
                            <div id="errFirst"></div>
                        </div>

                        <div class="from-group">
                            <label class="control-label">Выберите фото</label>
                            <input type="file" name="photo" class="filestyle" data-input="false">
                        </div>

                        <div class="form-group">
                            <input class="btn btn-success reg_btn" type="submit" name="add" value="Добавить запись">
                        </div>
                    </fieldset>
                </form><!-- ends register form -->

                <script type="text/javascript">
                    document.getElementById("field_terms").setCustomValidity("Please indicate that you accept the Terms and Conditions");
                </script>

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
