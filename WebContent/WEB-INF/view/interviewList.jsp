<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br/>
<div class="redbox18text">${reportTitle }</div>
<table class="" align="center" bgcolor="" border="0" cellpadding="1" cellspacing="1" width="80%">
<tr>
<td colspan="4" width="90%">&nbsp;</td>
<td width="10%" align="center"><div class="button_red"><a href="${pageContext.request.contextPath}/interviewController/openNewInterview.htm">Add New Interview</a></div></td></tr>
</table>
<c:if test="${not empty lstReport }">
<form id="resultSubmissionForm" action="" name="panelForm" method="Post">



<table class="box2s" align="center" bgcolor="#e9e9e9" border="0" cellpadding="0" cellspacing="1" width="80%">
<tr class="heading-white-13">
<th>${col0 }</th>
<th>${col1 }</th>
<th>${col2 }</th>
<th>${col3 }</th>
<th>${col4 }</th>
<th>${col5 }</th>
<th>&nbsp;</th>
</tr>
<c:forEach items="${lstReport }" var="interviewBean" varStatus="status"> 
			<tr class="${status.index % 2 == 0 ? 'box3Grey' : 'box3White'}">
				<td align="center">${status.count}</td>
				<td align="center">${interviewBean.firstName }&nbsp;${interviewBean.lastName }</td>
				<td align="center">${interviewBean.skills }</td>
				<td align="center">${interviewBean.status }</td>
				<td align="center">${interviewBean.round }</td>
				<td align="center"><a href="${pageContext.request.contextPath}/interviewController/viewInterview.htm?type=view&interviewID=${interviewBean.id }">View Profile</a>
				&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/interviewController/viewInterview.htm?type=edit&interviewID=${interviewBean.id }">Edit</a></td>
			</tr>
</c:forEach>
</table>
</form>
</c:if>