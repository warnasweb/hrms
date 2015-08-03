<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HireMe</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<style type="text/css">
.loginDivClass {
	margin-top: 150px;
	border: 1px solid rgb(235, 150, 150);
	width: 400px;
	height: 150px;
	padding: 2px;
	background-color: rgb(226, 223, 180);
}

.loginTableTd {
	font-size: medium;
	font-weight: bold;
}

</style>
<script type="text/javascript">

function validateAndSubmitForm(){
	if($.trim($("#userId").val())==""){
		alert("Please enter UserId.");
		return true;
	}else if($.trim($("#psword").val())==""){
		alert("Please enter Password");	
		return true;
	}else{
		$("#password").val($("#psword").val());
		if($("#flag").val()=="logout"){
			document.getElementById("loginForm").action="loginProcess.htm";
		}else{
			document.getElementById("loginForm").action="homeController/loginProcess.htm";	
		}
		document.getElementById("loginForm").submit();
	}
}

</script>

</head>
<body style="height:500px; background-image: url('<%=request.getContextPath()%>/img/main_back.jpg'); background-repeat: no-repeat;  background-size: 100% 100%;">
	
	<center>
		<c:if test="${logout ne null }">
			<input type="hidden" id="flag" name="flag" value="${logout }">
			<script type="text/javascript">
      			if(window.history.forward(1) != null)
           		window.history.forward(1);
			</script>
		</c:if>
		<c:if test="${logout eq null }">
			<input type="hidden" name="flag" id="flag" value="">
		</c:if>
		
		<div class="loginDivClass">
		<div style="font-size: x-large; color: green;">Login</div>
			<form id="loginForm" action="" name="loginBean" method="Post">
				<table cellpadding="5" cellspacing="5">
					<tr>
						<td class="loginTableTd">UserId</td>
						<td><input type="text" name="userId" id="userId"></td>
					</tr>

					<tr>
						<td class="loginTableTd">Password</td>
						<td><input type="password" name="psword" id="psword">
						<input type="hidden" name="password" id="password">
						</td>
					</tr>

					<tr>
						<td align="right">
						<input type="reset" value="Reset">&nbsp;&nbsp;
						<button onclick="javascript:validateAndSubmitForm();">Login</button>
						</td>
					</tr>
					<tr>
						<td style="color: red;">
							<c:if test="${message ne null }">
					   			${message }
							</c:if>
						</td>
						</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>