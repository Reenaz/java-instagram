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
    <link rel="stylesheet" href="<c:url value="ttps://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/profile_style.css"/>">
</head>
<body>

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
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Upload</a></li>
                <li><a href="#">Profile</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<!-- ACTUAL BODY -->
<div class="container">
    <div class="jumbotron">
        <h1><i class="fa fa-user-circle" aria-hidden="true"></i> Reenaz</h1>
        <p>Imaginary website for sharing pics with your imaginary friends!</p>
    </div>


    <div class="row">
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/2PODhmrvLik">
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/jMd3WS9LBcc">
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/AdfaEuotl_Q">
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/AsahNlC0VhQ">
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/mXQyEcINwa8">
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/sf4ihZObGOY">
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/Kwi60PbAM9I">
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/bQxGg8Vx1Vc">
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 ">
            <div class="thumbnail">
                <img src="https://source.unsplash.com/PFxSKx4kc5U">
            </div>
        </div>
    </div>
</div>

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
</footer>



<script
        src="https://code.jquery.com/jquery-3.2.1.js"
        integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</div>
</body>
</html>
