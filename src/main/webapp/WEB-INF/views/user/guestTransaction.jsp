<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content=""> 
  <link href="${pageContext.request.contextPath}/res/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/res/css/full-slider.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="res/css/guestTransaction.css" media="screen" type="text/css" />
  <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script> 
  <script src="${pageContext.request.contextPath}/res/js/guest/guest.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/bootbox.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/bootbox.min.js"></script>
  
</head>
<jsp:include page="header.jsp"></jsp:include>
<body class="guestTransactionBodyClass">
		
		<!-- pageHeading-->		
		<div class="row pageHeading">
			<h4>Guest Transaction</h4>
		</div>
		
		<!--//////////////////////////////-->		
		
		<form:form id="searchGuest" method="post"  modelAttribute="guestDto">
		<div class="row searchSection">
			<form:hidden id="guestId"  path="guestId" />
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				<label class="searchLabels">Guest Code : </label>
				<form:input path="guestCode" id="guestCode" class="guestName" name="guestCode" placeholder="Guest Code" />
			</div>
			<div class="col-xs-12 col-sm-6 col-md-2 col-lg-2">
				<input type="button" value="Search" class="searchButton" onclick="searchGuest()">
			</div>
			<div class="col-xs-12 col-sm-6 col-md-2 col-lg-2">
			</div>
		</div>
		</form:form>
		
		<!--////////////////////////////-->		
		<div class="row tableSection" modelAttribute="guestDto">	
			<div class="col-xs-1 col-sm-1 col-md-2 col-lg-2 ">
			</div>
			<div class="col-xs-11 col-sm-5 col-md-4 col-lg-4">   
				<label class="tableLabels">Guest Code: </label>
				<span class="tableData" id="guestCodeJson"></span>
				 
				<br>
				<label class="tableLabels">Guest Name:</label>
				<span class="tableData" id="guestNameJson"></span>
				<br>
				<label class="tableLabels">Check In:</label>
				<span class="tableData" id="checkInJson"></span>
				<br>
				<label class="tableLabels">Check Out:</label>
				<span class="tableData" id="checkOutJson"></span>
				<br>
			</div>
			<div class="col-xs-12 col-sm-5 col-md-4 col-lg-4">   
				<label class="tableLabels">Breakfast Limit Remaining:</label>
				<span class="tableData" id="RemBreakFastJson"></span>
				<br>
				<label class="tableLabels">Lunch Limit Remaining:</label>
				<span class="tableData" id="RemLunchJson"></span>
				<br>
				<label class="tableLabels">Dinner Limit Remaining:</label>
				<span class="tableData" id="RemDinnerJson"></span>
				<br>
			</div>
			<div class="col-xs-12 col-sm-1 col-md-2 col-lg-2 ">
			</div>
		</div>
		
		<!--/////////////////////////////////////////////////////  -->
		<form:form id="saveTransaction" method="post"  modelAttribute="guestDto">
		<form:hidden id="guestIdd"  path="guestId" />
		<form:hidden id="visitId" path="tmpVisitId"/>
		<div class="row deductionSection">
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				<label class="deductionLabels">Deduction Type</label>
				<select id="foodType"  class="guestName">
					<option>Break Fast</option>
					<option>Lunch</option>
					<option>Dinner</option>
				</select>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				<label class="deductionLabels">No of deductions</label>
				<form:input type="number" path="" id="quantity" class="guestName" name="quantity" min="1" max="10"  />
			</div>
			<div class="col-xs-12 col-sm-6 col-md-2 col-lg-2">
				<input type="button" value="Ok" class="deductionButton" onclick="saveGuestTransaction()">
				
			</div>
			<div class="col-xs-12 col-sm-6 col-md-2 col-lg-2">			
			</div>
		
		</div>
		</form:form>
		
</body>
</html>