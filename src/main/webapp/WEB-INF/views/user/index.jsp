<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
  <meta charset="UTF-8">
  <title>Login</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/res/css/style.css">
</head>

<body>
    <div class="container">

      <div id="login">

         <form:form id="loginForm" action="/SMS/login" method="post"  modelAttribute="userDto">
          <fieldset class="clearfix">
            <p><span class="fontawesome-user"></span><form:input id="username" name="username" path="username" /> </p> <form:errors path="username" cssClass="errorUserName"/>
            <p><span class="fontawesome-lock"></span><form:password id="password" name="password" path="password" /></p>
			<a class="signInButton"><input type="submit" value="Submit" /></a>
          </fieldset>

        </form:form>

        <!-- <p class="signUpClass">Not a member? <a href="#">Sign up now</a><span class="fontawesome-arrow-right"></span></p> -->

      </div> <!-- end login -->

    </div>

  

</body>

</html>