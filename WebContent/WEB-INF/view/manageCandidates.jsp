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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/jq/jquery.bgiframe-2.1.2.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.ui.core.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.ui.widget.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.ui.mouse.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.ui.button.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.ui.draggable.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.ui.position.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.ui.resizable.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.ui.dialog.js"></script>
	<script src="<%=request.getContextPath()%>/jq/jquery.effects.core.js"></script> 
	
	  

<script type="text/javascript">
function closeDiv(){
	$("#roundDiv").hide("slow");
	$("#roundDiv").dialog( "destroy" )
	$("#roundDiv").html('');
	$("#maintbl").css({opacity: 1.0});
	$("#cdDetails :input").attr("disabled", false);
	$('a').live('click', function() { return true;});
}

function checkCtrl(){
	$("#cdDetails :input").attr("disabled", true);
	//$('a').live('click', function() { return false;});

}

function openThisForm(val){
	var callingUrl="";
	if(val==''){
		alert("Please select a Condidate");
		return false;
	}else{
		callingUrl="viewCandidate.htm?type=details&candidateID="+val;
	}
	
	$.ajax({
		type: 'POST',
		url: callingUrl,
		success:function(result){
			$("#detailDiv").html('');
			$("#roundDiv").html('');
	    	$("#detailDiv").html(result);
	    	
	    }});

}

function openPopup(ctrl){
	var callingUrl=ctrl;
	$("#roundDiv").show();
	$("#maintbl").css({opacity: 0.1});
	$("#roundDiv").load(callingUrl).dialog({ closeOnEscape: false ,position:"top",modal: true,draggable: false,show: { effect: 'drop', direction: "up"},closeText: ''}); 
	$("#roundDiv").css({opacity: 1.0});
	$("#roundDiv").css('margin-top',100);
	checkCtrl();
}

function saveCandi(frm, type){
	$(frm).submit();
	

}


function saveCandidate(frm, type){
	var callingUrl="";
	if(type=='save'){
		callingUrl="saveCandidate.htm"//?candidateID="+val;
	}else if(type=='update'){
		callingUrl="updateRound.htm"//?candidateID="+val;
	}
	//$("#candidateID").val($("#cdID").val());
	var strFrm = $(frm).serialize();
	$.ajax({
		type: 'POST',
		data:strFrm,
		url: callingUrl,
		contentType: false,
		success:function(result){
	    	$("#detailDiv").html(result);
	    	$("#roundDiv").html('');
	    	closeDiv();
	    }});

}

</script>




</head>
<body >
	<jsp:include page="header.jsp"/>
	<center>
	<div id="maintbl">
	<div class="redbox18text">${reportTitle }</div>
	<form id="cdDetails" action="" name="cdDetails" method="Post">
	<table class="" align="center" bgcolor="" border="0" cellpadding="5" cellspacing="1" width="60%">
	<tr>
	<td colspan="4" width="80%">&nbsp;</td>
	<td width="20%" align="center"><div class="button_red"><a href="javascript:openPopup('openNewCandidate.htm');" >Add New Candidate</a></div></td></tr>
	</table>
	<div id="detailDiv">
			<jsp:include page="candidateList.jsp"/>		
			<br/>
				<div class="button_red" style="width:35px;"><a href="${pageContext.request.contextPath}/homeController/home.htm">Back</a></div>
	</div>
	</form>
	</div>
	<div id="roundDiv"></div>
	</center>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>