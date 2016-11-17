<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
  <title>Guest Form</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/guestForm.css" media="screen" type="text/css" />
  <script src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/jquery-ui/jquery-ui.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/bootbox.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/bootbox.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/guest/guest.js"></script>
  
  
   <script>   
    $(function() {
         $( "#checkIn" ).datepicker();   
    }); 
</script>
<script>   
    $(function() {
         $( "#checkOut" ).datepicker();   
    }); 
</script>
<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>

</head>
<jsp:include page="header.jsp"></jsp:include>
<body>


<div class="container">
  
  <div class="row addGuestForm">
  
	<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
	</div>
    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
      <div class="panel panel-default">
        <div class="panel-heading clearfix">
          <i class="icon-calendar"></i>
          <h3 class="panel-title">Guest</h3>
          <div id="popUpMessage">
			 <c:if test="${saved != null}">
  			<%-- <div id="status_message">${saved}</div> --%>
  			<div class="successMessageAlert">${saved}.</div>
			</c:if>
		  </div>
        </div>
        
        <div class="panel-body">
          <form:form id="addGuest" method="post"  modelAttribute="guestDto">
			<div class="row">
			<form:hidden id="guestId"  path="guestId" />
			
				<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
					<div class="form-group">
					  <label class="labelWidth">Guest Code</label>
					  <form:input path="guestCode" id="guestCode" name="guestCode" readonly = "true" class="form-control" placeholder="Guest Code"/>				  
							
					</div>
					<div class="form-group">
					  <label class="labelWidth">Name</label>
					  <form:input path="guestName" id="guestName" name="guestName"  class="form-control" placeholder="Guest Name"/>
					</div>
					<div class="form-group">
					  <label class="labelWidth">Check In</label>
					  <form:input type="datetime" path="RmsVisitDomain.checkIn" id="checkIn" name="checkIn"  class="form-control" placeholder="check In"/>
					</div>		
				</div>
				<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
					<div class="form-group">
					  <label class="labelWidth">Contact</label>
					  <form:input path="contactNo" id="contactNo" name="contactNo"  class="form-control" placeholder="contact No."/>
					</div>
					
					<div class="form-group">
						<label class="labelWidth">Room No.</label>
						<form:input path="roomNo" id="roomNo" name="roomNo"  class="form-control" placeholder="room No."/>
					</div>	
					<div class="form-group">
						<label class="labelWidth">Check Out</label>
						<form:input type="datetime" path="RmsVisitDomain.checkOut" id="checkOut" name="checkOut"  class="form-control" placeholder="check Out"/>
					</div>
				</div>
			</div>
			
			
			<div class="row" style="margin-top:20px;">
				<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<label class="labelWidth">BreakFast</label>
					<form:input path="breakFast" id="breakFast" name="breakFast"  class="form-control" placeholder="Limit."/>
				</div>
				
 				<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<label class="labelWidth">Lunch</label>
					<form:input path="lunch" id="lunch" name="lunch"  class="form-control" placeholder="Limit."/>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
					<label class="labelWidth">Dinner</label>
					<form:input path="dinner" id="dinner" name="dinner"  class="form-control" placeholder="Limit."/>
				</div>
			</div>
			<div class="row" style="margin-top:30px; margin-left:278px">
			<!-- <input type="submit" class="btn btn-sm btn-primary"  value="Register"/> -->
			<input type="button" value="Register" class="btn btn-sm btn-primary" onclick="saveGuest()">
			<input type="button" value="Reset" class="btn btn-sm btn-primary" onclick="resetForm()">
			</div>
			
           </form:form>
        </div>
      </div>
    </div>
		<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
	</div>
  </div>

 

  
</div>
</body>
</html>
