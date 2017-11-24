<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Imstagram</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/addPost_style.css"/>">

    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
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
                <li><a href="#">� ���</a></li>
                <li><a href="#">��������</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="feed">�����</a></li>
                <li><a href="add">��������� ����</a></li>
                <li><a href="profile">�������</a></li>
                <li><a href="logout">�����</a></li>
            </ul>
        </div>
    </div>
</nav>

<main>
    <div class="container">
        <div class="row">
            <div class="title col-md-6 col-md-offset-3">
                <h1>���������� ������</h1>
            </div>
            <div class="col-md-6 col-md-offset-3">
                <form action="add" method="post" id="fileForm" role="form" enctype="multipart/form-data">
                    <fieldset>

                        <div class="form-group">
                            <label for="description"><span class="req">* </span> ����������:</label>
                            <input required type="text" name="description" id="description" class="form-control phone" maxlength="100"  />
                        </div>

                        <div class="form-group">
                            <label for="location"><span class="req">* </span> ��������������: </label>
                            <input class="form-control" type="text" name="location" id = "location"  required />
                        </div>

                        <div class="from-group">
                            <label class="control-label">�������� ����</label>
                            <input type="file" name="photo" class="filestyle" data-input="false">
                        </div>

                        <div class="form-group">
                            <input class="btn btn-success reg_btn" type="submit" name="add" value="�������� ������">
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
            <a href='#'>���������</a>
            <a href='#'>����</a>
            <a href='#'>API</a>
            <a href='#'>��������</a>
            <a href='#'>�����</a>
            <a href='#'>�������</a>
            <span id='copyright'>� 2017 INSTAGRAM</span>
        </div>
    </div>
</div>
</footer>


</body>
