<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
   <title>Restaurant Managment System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content=""> 
  <link href="${pageContext.request.contextPath}/res/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/res/css/full-slider.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/header.css" media="screen" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap/dist/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/res/css/bootstrap/dist/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/jquery.js"></script> 
  <script src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/jquery-ui/jquery-ui.js"></script>
 
</head>
<body>

    <jsp:include page="header.jsp"></jsp:include>
	
	<header id="myCarousel" class="carousel slide">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('res/image/res3.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Caption 1</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('res/image/res4.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Caption 2</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('res/image/res2.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Caption 3</h2>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>
    <script>
    $('.carousel').carousel({
        interval: 5000 
    })
    </script>
</body>
</html>
