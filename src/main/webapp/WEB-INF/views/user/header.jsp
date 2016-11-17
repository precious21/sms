<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title> Managment System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <script src="res/css/bootstrap/dist/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/header.css" media="screen" type="text/css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/res/js/bootbox.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/bootbox.min.js"></script>
<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>
<style>


</style>     


</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">	 
	<div class="navbar-header">	
		<span class="navbar-brand" style="margin-top: 52%; font-size: 40px; color: black; cursor:pointer;" onclick="openNav()">&#9776;</span>	
    </div>
	<ul class="nav navbar-nav navbar-center">
		  <a href="<c:url value='/redirect'/>">Restaurant Managment System</a> 
		
	</ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><i class="fa  fa-sign-out"></i> Logout</a></li>
    </ul>
  </div>
</nav>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()" style="border:none;"><i class="fa fa-arrow-left" aria-hidden="true"></i>
</a>
  <%-- <a class="menuStyling" href="<c:url value='/addGuest' />">Guest Reg</a> --%>
  
  <a style="border-top:1px solid white;" href="<c:url value='/getGuestList' />">Guest</a>
  <a href="<c:url value='/getGuestTransaction' />">Transaction</a>
</div>
</body>
</html>