//reset book Form
function resetForm() {
	$('#guestId').val('');
	$('#guestName').val('');
	$('#checkIn').val('');
	$('#contactNo').val('');
	$('#roomNo').val('');
	$('#checkOut').val('');
	$('#breakFast').val('');
	$('#lunch').val('');
	$('#dinner').val('');
}

setTimeout(function() {//this method will auto remove message div after some seconds
	  $('#popUpMessage').fadeOut('fast');
}, 3000); // <-- time in milliseconds

function saveGuest() {
	try{
		
	if($('#guestCode').val()=="")
	{
		bootbox.alert("Please Enter Guest Code");
		document.getElementById("guestCode").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{
		document.getElementById("guestCode").style="border:1px solid #ccc; border-radius: 5px;";}
	
	if($('#guestName').val()=="")
	{
		bootbox.alert("Please Enter Guest Name");
		document.getElementById("guestName").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("guestName").style = style="border:1px solid #ccc; border-radius: 5px;";}
	
	if($('#contactNo').val()=="")
	{
		bootbox.alert("Please Enter Contact No.");
		document.getElementById("contactNo").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("contactNo").style="border:1px solid #ccc; border-radius: 5px;";}
	

	if($('#roomNo').val()=="")
	{
		bootbox.alert("Please Enter Room No.");
		document.getElementById("roomNo").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("roomNo").style="border:1px solid #ccc; border-radius: 5px;";}
	
	
	if($('#checkIn').val()=="")
	{
		bootbox.alert("Please Select Check-In date");
		document.getElementById("checkIn").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("checkIn").style = style="border:1px solid #ccc; border-radius: 5px;";}
	
	if($('#checkOut').val()=="")
	{
		bootbox.alert("Please Select Check-Out date");
		document.getElementById("checkOut").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("checkOut").style = style="border:1px solid #ccc; border-radius: 5px;";}
	
	
	
	
	var guestCode=$('#guestCode').val();
	var guestName=$('#guestName').val();
	var checkIn=$('#checkIn').val();
	var contactNo=$('#contactNo').val();
	var roomNo=$('#roomNo').val();
	var checkOut=$('#checkOut').val();
	var breakFast=$('#breakFast').val();
	var lunch=$('#lunch').val();
	var dinner=$('#dinner').val();
	
	$.ajax({
		type : "POST",
		url  : "addGuest",  
		data : "guestCode="+guestCode
				+"&guestName="+guestName
				+"&contactNo="+contactNo
				+"&roomNo="+roomNo
				+"&breakFast="+breakFast 
				+"&lunch="+lunch
				+"&dinner="+dinner
				+"&RmsVisitDomain.checkIn="+checkIn
				+"&RmsVisitDomain.checkOut="+checkOut,
		success : function(response) {
			bootbox.alert("Guest "+guestName+" registered Successfully");
			window.location='/RestuarantManagementSystem/getGuestList'
//			var d = new Date();
//			var year = d.getFullYear();
//			$('#guestCode').val(year+"-"+ Math.floor((Math.random() * 20) + 1));
		}, error: function(ee){
			bootbox.alert("Error while saving. Contact to Administrator" + ee);
		  }
			});
	
	}catch(e){
		bootbox.alert("error Guest.js method = saveGuest"+e);
	}
   
}

function searchGuest() {
	try{
		
	if($('#guestCode').val()=="")
	{
		bootbox.alert("Please Enter Guest Code");
		document.getElementById("guestCode").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{
		document.getElementById("guestCode").style="border:1px solid #ccc; border-radius: 5px;";
	}
	var guestCode=$('#guestCode').val();
	
	$.ajax({
		type : "GET",
		contentType: "application/json",
		url  : "searchGuestForTransaction",  
		data : "guestCode="+guestCode,
		success : function(data) {
			
			$("#guestId").val(data.guestId !=null ?data.guestId :"" );
			$("#guestIdd").val(data.guestId !=null  ? data.guestId :"");
			$('#guestCodeJson').text(data.guestCode !=null ? data.guestCode : "");
			$('#guestNameJson').text(data.guestName !=null ? data.guestName : "");
			$('#RemBreakFastJson').text(data.breakFastRemainig !=null ? data.breakFastRemainig : "" );
			$('#RemLunchJson').text(data.lunchRemaining !=null ? data.lunchRemaining :"");
			$('#RemDinnerJson').text(data.dinnerRemaining !=null ? data.dinnerRemaining : "");
			$('#checkInJson').text(data.tmpCheckIn !=null ? data.tmpCheckIn : "" );
			$('#checkOutJson').text(data.tmpCheckOut !=null ? data.tmpCheckOut : "");
			$('#visitId').val(data.rmsVisitDomain.visitId !=null ? data.rmsVisitDomain.visitId : "");
		}, error: function(ee){      
			   bootbox.alert("Error while searching. Contact to Administrator"+ ee);
		  }
			});
	
	}catch(e){
		bootbox.alert("error Guest.js method = saveGuest"+e);
	}
   
}

function saveGuestTransaction() {
	try{
		
	if($('#guestIdd').val()=="" || $('#visitId').val()=="")
	{
		bootbox.alert("Please Search guest again or contact to administrator");
		document.getElementById("guestCode").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("guestCode").style="border:1px solid #ccc; border-radius: 5px;";}
	
	if($('#quantity').val()=="" || $('#quantity').val()=="0")
	{
		
		bootbox.alert("Quantity Can not be null or empty .Please enter correct value");
		document.getElementById("quantity").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("quantity").style="border:1px solid #ccc; border-radius: 5px;";}
	
	if($("#foodType option:selected" ).text()=="Break Fast" &&  parseInt($('#quantity').val())  > parseInt($('#RemBreakFastJson').text() )){
		bootbox.alert("Your deduction limit exceeding actual break fast limit ");
		document.getElementById("quantity").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("quantity").style="border:1px solid #ccc; border-radius: 5px;";}
	
	if($("#foodType option:selected" ).text()=="Lunch" &&  parseInt($('#quantity').val()) > parseInt($('#RemLunchJson').text() )){
		bootbox.alert("Your deduction limit exceeding actual lunch limit ");
		document.getElementById("quantity").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("quantity").style="border:1px solid #ccc; border-radius: 5px;";}
	
	if($("#foodType option:selected" ).text()=="Dinner" && parseInt($('#quantity').val()) > parseInt($('#RemDinnerJson').text() )){
		bootbox.alert("Your deduction limit exceeding actual Dinner limit ");
		document.getElementById("quantity").style = "border:1px solid red; border-radius: 5px;";
		return false;
	}else{document.getElementById("quantity").style="border:1px solid #ccc; border-radius: 5px;";}
	
	
	var foodType=$( "#foodType option:selected" ).text();
	var qty=$('#quantity').val();
	var guestId=$('#guestIdd').val();
	var visitId=$('#visitId').val();	
	$.ajax({
		type : "POST",
		url  : "saveGuestTransaction",  
		data : "guestId="+guestId
				+"&tmpVisitId="+visitId
				+"&rmsVisitDomain.visitId="+visitId
				+"&tmpFoodTypeName="+foodType
				+"&tmpQuantity="+qty
				,
		success : function(response) {
			bootbox.alert("Record Added Successfully");
			resetGuestTransaction();
		}, error: function(ee){      
			bootbox.alert("Error while saving transaction. Contact to Administrator" + ee);
		  }
			});
	
	}catch(e){
		bootbox.alert("error Guest.js method = saveGuest"+e);
	}
   
	function resetGuestTransaction(){
		$("#guestId").val("" );
		$("#guestIdd").val("");
		$('#guestCodeJson').text("");
		$('#guestNameJson').text("");
		$('#RemBreakFastJson').text("" );
		$('#RemLunchJson').text("");
		$('#RemDinnerJson').text("");
		$('#checkInJson').text("");
		$('#checkOutJson').text("");
		$('#visitId').val("");
		$('#guestCode').val("");
		$('#quantity').val("");
	}
}