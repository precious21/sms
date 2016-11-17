<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/guest.css" media="screen"
	type="text/css" />
<jsp:include page="header.jsp"></jsp:include>
<body class="guestBodyClass">

	<section>
		<div class="container-fluid paddingNone">
			<div class="pageHeading">
				<h4>Guest</h4>
			</div>
			<div class="row">
				<div class="guestTableSection">
					<div class="guestSearch">
						<div class="row addGuestButton">
						<a href="<c:url value='/addGuest' />"><input type="button" class="filterButton" value="Add Guest"></input></a>
						</div>
						<div >
							<div class="col-md-2 col-sm-2 col-xs-1">
								<div class="filterCheckbox">
									<input type="checkbox" class="data_check ab" id="selectall1" />
									
								</div>
								<!-- <a class="edit_img" id="editId" title="Edit" href="#"> <img src="images/edit.png" class="right"></a> -->
								<a class="del_img" id="deleteId" title="Disable" href="#"> <img src= "<c:url value="/res/image/delete.png"></c:url>" /> </a>
							    
							</div>
							<div class="col-md-4 col-md-10 col-md-11 pull-right">
								<input type="text" class="searchTextbox" placeholder="Type here"
									id="driver-filter">
								<button type="button" class="filterButton">Filter</button>
								<div class="pagination static" id="pagination-info"></div>
								
							</div>
						</div>
					</div>
					<div class="data_driver">
					<form:form method="post" >
						<table class="database" id="drivers-data-table">
							<thead>
								<tr>
									<th class="fd_col">Actions</th>
									<th class="">Guest Code</th>
									<th class="">Guest Name</th>
									<th class="">Contact No</th>
									<th class="">Room No</th>
									<th class="">Check In</th>
									<th class="">Check Out</th>
									<th class="">Break Fast Limit</th>
									<th class="">Remaining</th>
									<th class="">Lunch Limit</th>
									<th class="">Remaining</th>
									<th class="">Dinner Limit</th>
									<th class="">Remaining</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach  items="${guestDtoList}" var="guestDto" varStatus="status">
        					<tr>
        					<td>
        					<input type="checkbox" name="selectedRecords"
							Class="data_check ab"
							Value=${guestDto.guestId} />
							</td>
        					<td>${guestDto.guestCode}</td>
        					<td>${guestDto.guestName}</td>
        					<td>${guestDto.contactNo}</td>
        					<td>${guestDto.roomNo}</td>
        					<td>${guestDto.rmsVisitDomain.checkIn}</td>
        					<td>${guestDto.rmsVisitDomain.checkOut}</td>
    						<td>${guestDto.breakFast}</td>
    						<td>${guestDto.breakFastRemainig}</td>
    						<td>${guestDto.lunch}</td>
    						<td>${guestDto.lunchRemaining}</td>
    						<td>${guestDto.dinner}</td>
    						<td>${guestDto.dinnerRemaining}</td>
    						</tr>
    						</c:forEach>	
						</tbody>
						</table>
						</form:form>
					</div>
				</div>

			</div>
		</div>
	</section>
</body>

<SCRIPT>
	$(document)
			.ready(
					function() {
						var records = document
								.getElementsByName("selectedRecords");
						var i, id = 0;
						$('#selectall1')
								.click(
										function() {
											$(".data_check.ab").prop('checked',
													$(this).prop("checked"));
											if ($('#selectall1')
													.prop('checked') == true) {
												$(".del_img").css("display",
														"block");
												$("#deleteId")
														.attr("href",
																"javascript: deleteSelectedRecords();");
											} else
												$(".edit_img, .del_img").css(
														"display", "none")
										});
						$('.data_check.ab')
								.click(
										function() {
											if ($('.data_check.ab:checked').length == 1
													&& $('#selectall1').prop(
															'checked') == false) {
												$(".del_img, .edit_img").css(
														"display", "block");
												$("#deleteId")
														.attr("href",
																"javascript: deleteSelectedRecords();");
												for (i = 0; i < records.length; i++) {
													if (records[i].checked) {
														id = records[i].value;
														$("#editId").attr(
																"href",
																"editDriverProfile.action?strDriverId="
																		+ id);
													}
												}
											} else if ($('.data_check.ab:checked').length == 0
													&& $('#selectall1').prop(
															'checked') == false)
												$(".del_img, .edit_img").css(
														"display", "none")
											else
												$(".edit_img").css("display",
														"none")
										});
					});
</SCRIPT>


<!--DATE PICKER OVER-->

<script>
	$(document).ready(function() {
		$('[data-hover="tooltip"]').tooltip();
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var rowCount = $('#drivers-data-table tr').length;
		rowCount = rowCount - 1;
		var txt = "";
		if (rowCount) {
			txt = 1 + " - " + rowCount + " of " + rowCount;
		}
		$("#pagination-info").text(txt);
	});

	/* code for table search */
	$(document).ready(function() {
		$('#driver-filter').keyup(function() {
			searchTable($(this).val());
		});
	});

	function searchTable(inputVal) {
		var table = $('#drivers-data-table');
		table.find('tr').each(function(index, row) {
			var allCells = $(row).find('td');
			if (allCells.length > 0) {
				var found = false;
				allCells.each(function(index, td) {
					var regExp = new RegExp(inputVal, 'i');
					if (regExp.test($(td).text())) {
						found = true;
						return false;
					}
				});
				if (found == true)
					$(row).show();
				else
					$(row).hide();
			}
		});
	}

	//submit grid form with selected records
	function deleteSelectedRecords() {
		bootbox.confirm("Are you sure you want to delete selected driver(s)?",
				function(result) {
					if (result) {
						var form = $("#driver-grid-form-id");
						form.attr("action", "deleteDriverProfile.action");
						form.submit();
					} else {
						console.log("User not delete the Record");
					}
				});
	}
	function disableSelectedRecords() {
		bootbox.confirm("Are you sure you want to disable selected driver(s)?",
				function(result) {
					if (result) {
						var form = $("#driver-grid-form-id");
						form.attr("action", "disableDriverProfile.action");
						form.submit();
					} else {
						console.log("User not disable the driver");
					}
				});
	}
</script>

