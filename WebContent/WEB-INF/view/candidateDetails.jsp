<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HireMe</title>
<link href="<%=request.getContextPath()%>/css/for_you.css" rel="stylesheet" type="text/css" />
<!-- <script src="WEB-INF/js/jquery-1.11.1.min.js"></script> -->
<!-- <script src="//code.jquery.com/jquery-1.11.0.min.js"></script> -->
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

</script>
<style type="text/css">
.tdFormat{
font-size: medium;
}

</style>
</head>
<body style="background-color: rgb(225, 248, 237);">
	<center>
	
	<form id="interviewForm" action="${pageContext.request.contextPath}/candidateController/saveCandidate.htm" name="InterviewForm" method="Post" enctype="multipart/form-data">
				<table class="box2s" cellpadding="0" cellspacing="0" width="60%">
						<tr class="heading-white-13">
							<td colspan="7" align="center" >Candidate Details</td>
						</tr>
						<tr><td colspan="7">&nbsp;</td></tr>
					<tr >
						<td width="2%">&nbsp;</td>
						<td width="15%" >Candidate Name:</td>
						<td width="33%" style="color:#DF0418">${candidate.firstName}&nbsp;${candidate.lastName}</td>
						<td width="2%">&nbsp;</td>
						<td width="15%">E-Mail:</td>
						<td width="31%" style="color:#DF0418">${candidate.email}</td>
						<td width="2%">&nbsp;</td>
					</tr>
					<tr><td colspan="7">&nbsp;</td></tr>
					<tr>
						<td>&nbsp;</td>
						<td >Skill Set:</td>
						<td  style="color:#DF0418">${candidate.skills}</td>
						<td>&nbsp;</td>
						<td >Notice Period:</td>
						<td  style="color:#DF0418">${candidate.noticePeriod} (days)</td>
						<td>&nbsp;</td>
					</tr>
					<tr><td colspan="7">&nbsp;</td></tr>
					<tr>
						<td>&nbsp;</td>
						<td >Current CTC:</td>
						<td  style="color:#DF0418">${candidate.currentCTC} (lacs)</td>
						<td>&nbsp;</td>
						<td >Expected CTC:</td>
						<td  style="color:#DF0418">${candidate.expectedCTC} (lacs)</td>
						<td>&nbsp;</td>
					</tr>
					<tr><td colspan="7">&nbsp;</td></tr>
					<tr >
						<td>&nbsp;</td>
						<td >For Manager:</td>
						<td  style="color:#DF0418">${candidate.manager}</td>
						<td>&nbsp;</td>
						<td >Result:</td>
						<td  style="color:#DF0418">${candidate.result}</td>
						<td>&nbsp;</td>
					</tr>
					<tr><td colspan="7">&nbsp;</td></tr>
					<tr>
						<td colspan="2" align="center">
						<div  class="button_red" style="margin-bottom:5px"><a href="${pageContext.request.contextPath}/interviewController/viewResume.htm?candidateID=${candidate.id}">View Resume</a></div>
						</td>
						<td colspan="5">&nbsp;</td>
					</tr>
					
					</table>
					
					<c:forEach items="${candidate.rounds}" var="iRounds" > 
					<table class="box2s" cellpadding="0" cellspacing="0" width="60%">
						<tr class="heading-white-13">
							<td colspan="7" align="center" >Interview Details</td>
						</tr>
					<tr><td colspan="7">&nbsp;</td></tr>
						<tr>
							<td width="2%">&nbsp;</td>
							<td width="15%">Round:</td>
							<td width="33%" style="color:#DF0418">${iRounds.round}</td>
							<td width="2%">&nbsp;</td>
							<td width="15%">Date of Interview:</td>
							<td width="31%" style="color:#DF0418">${iRounds.dateOfInterview}</td>
							<td width="2%">&nbsp;</td>
						</tr>
					<tr><td colspan="7">&nbsp;</td></tr>
						<tr>
							<td >&nbsp;</td>
							<td >Remarks:</td>
							<td  style="color:#DF0418">${iRounds.remarks}</td>
							<td >&nbsp;</td>
							<td >Result:</td>
							<td  style="color:#DF0418">${iRounds.result}</td>
							<td >&nbsp;</td>
						</tr>
						<tr><td colspan="7">&nbsp;</td></tr>
						<tr class="heading-white-13">
							<td colspan="7" align="center" >Panel Details</td>
						</tr>
						<tr><td colspan="7">&nbsp;</td></tr>
						<tr>
							<td >&nbsp;</td>
							<td >Name:</td>
							<td  style="color:#DF0418">${iRounds.panelBean.firstName}&nbsp;${iRounds.panelBean.lastName}</td>
							<td >&nbsp;</td>
							<td >Designation:</td>
							<td  style="color:#DF0418">${iRounds.panelBean.designation}</td>
							<td >&nbsp;</td>
						</tr>
						<tr><td colspan="7">&nbsp;</td></tr>
						<tr>
							<td >&nbsp;</td>
							<td >E-mail:</td>
							<td colspan="3" style="color:#DF0418">${iRounds.panelBean.email}</td>
							<td align="center">
							<div  class="button_red" style="width:60px"><a href="#" onclick="openRoundPanel('openUpdateRound.htm?roundID=${iRounds.id}')">Update</a></div>
							</td>
							<td >&nbsp;</td>
						</tr>
						<tr><td colspan="7">&nbsp;</td></tr>
					<tr>
						
					</table>
				</c:forEach>
				<table class="" align="center" bgcolor="" border="0" cellpadding="1" cellspacing="1" width="60%">
				<tr>
				<!-- -->
				<td width="20%" align="center">
				<div class="button_red" ><a href="#" onclick="openRoundPanel('openNewRound.htm')">Schedule Next Round</a></div>
				</td>
				 <td colspan="4" width="80%">&nbsp;</td>
				 </tr>
				</table>
			</form>
	</center>
</body>
</html>