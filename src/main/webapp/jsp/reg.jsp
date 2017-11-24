<%@ page import="ru.kfu.itis.entity.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Imstagram</title>
    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg_style.css"/>">

    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>"></script>
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
            <a class="navbar-brand" href="#"><img src="https://www.hyperpalace.com/wp-content/uploads/2017/08/white_instagram_text_logo1.png" class="img-responsive img_title"></a>
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
                            <label for="userName"><span class="req">* </span> Username: <small>This will be your login user name</small> </label>
                            <input required type="text" name="userName" id="userName" class="form-control phone" maxlength="28" onkeyup="validatephone(this);" />
                        </div>

                        <div class="form-group">
                            <label for="phoneNumber"><span class="req">* </span> Phone number: </label>
                            <input class="form-control" type="text" name="phoneNumber" id = "phoneNumber" onkeyup = "Validate(this)" required />
                        </div>

                        <div class="form-group">
                            <label for="email"><span class="req">* </span> E-mail Address: </label>
                            <input class="form-control" type="text" name="email" id = "email" onkeyup = "Validate(this)" required />
                        </div>

                        <div class="form-group">
                            <label for="name"><span class="req">* </span> Name: </label>
                            <input class="form-control" required type="text" name="name" id = "name"  onchange="email_validate(this.value);" />
                        </div>

                        <div class="form-group">
                            <label for="description"><span class="req">* </span> Description:   </label>
                            <input class="form-control" type="text" name="description" id = "description" onkeyup = "Validate(this)" />
                        </div>

                        <div class="form-group">
                            <label for="password"><span class="req">* </span> Password: </label>
                            <input required name="password" type="password" class="form-control inputpass" minlength="4" maxlength="16"  id="password" /> </p>

                            <label for="confirm_password"><span class="req">* </span> Password Confirm: </label>
                            <input required name="password" type="password" class="form-control inputpass" minlength="4" maxlength="16" placeholder="Enter again to validate"  id="confirm_password" />
                        </div>
                        <div class="form-group">
                            <label for="gender">Ваш пол:</label>
                            <fieldset class="choose_set" name="gender" id="gender">
                                <label><input type="radio" name="gender"  value="1" checked>male</label>
                                <label><input type="radio" name="gender" value="2">female</label>
                            </fieldset>
                        </div>
                        <div class="form-group">
                            <label for="type">Тип аккаунта:</label>
                            <fieldset class="choose_set" name="type" id="type">
                                <label><input type="radio" name="type" value="1" checked>открытый</label>
                                <label><input type="radio" name="type" value="2">закрытый</label>
                            </fieldset>
                        </div>

                        <div class="form-group">
                            <input type="checkbox" required name="terms" id="terms">   <label for="terms">I agree with the <a href="#" title="You may read our terms and conditions by clicking on this link">terms and conditions</a> for Registration.</label><span class="req">* </span>
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