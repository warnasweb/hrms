<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HireMe</title>
<link href="<%=request.getContextPath()%>/css/for_you.css" rel="stylesheet" type="text/css" />
<!-- <script src="WEB-INF/js/jquery-1.11.1.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<style type="text/css">
.loginDivClass {
	margin-top: 100px;
	border: 1px solid rgb(235, 150, 150);
	width: 800px;
	padding: 2px;
	background-color: rgb(226, 223, 180);
}

.loginTableTd {
	font-size: medium;
	font-weight: bold;
}

</style>
<script type="text/javascript">

function openThisForm(val){
	var callingUrl="";
	if(val=='user'){
		callingUrl="userRegistrationForm.htm";
	}else if(val=='staff'){
		callingUrl="staffRegistration.htm";
	}else if(val=='stationary'){
		callingUrl="stationaryRecordForm.htm";
	}else if(val=='report'){
		callingUrl="reportForm.htm";
	}
	
	$.ajax({
		type: 'GET',
		url: callingUrl,
		success:function(result){
	    	$("#contentDiv").html(result);
	    	
	    }});

}

</script>
<style type="text/css">
.tdFormat{
font-size: medium;
}

</style>
</head>
<body style="background-color: rgb(225, 248, 237);">
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="redbox18text" align="center">Add New Panel</div>
	<br/>
	<center>
	
	<div id="contentDiv">
	
	<form id="panelForm" action="${pageContext.request.contextPath}/panelController/savePanel.htm" name="PanelForm" method="Post">
				<table class="box2s" cellpadding="5" cellspacing="5">
					
					
					<tr>
						<td >First Name:</td>
						<td><input type="text" name="firstName" id="firstName" value="">
						</td>
					</tr>
					<tr>
						<td >Last Name:</td>
						<td><input type="text" name="lastName" id="lastName" value="">
						</td>
					</tr>
					<tr>
						<td >E-mail:</td>
						<td><input type="text" name="email" id="email" value="">
						</td>
					</tr>
					<tr>
						<td >Designation:</td>
						<td><input type="text" name="designation" id="designation" value=""></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
						<input type="reset" value="Reset">&nbsp;&nbsp;
						<input type="submit" value="Save Panel"/>
						</td>
					</tr>
				</table>
				<br/>
				<div class="button_red" style="width:35px;"><a href="${pageContext.request.contextPath}/panelController/openPanel.htm">Back</a></div>
			</form>
	</div>
	</center>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>