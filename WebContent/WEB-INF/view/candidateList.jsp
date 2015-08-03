<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty candidateList }">

<table class="box2s" align="center" bgcolor="#e9e9e9" border="0" cellpadding="0" cellspacing="1" width="60%">
<tr class="heading-white-13">
<th width="5%">${col0 }</th>
<th width="5%">${col1 }</th>
<th width="5%">${col4 }</th>
<th width="5%">${col2 }</th>
<th width="5%">${col3 }</th>
<th width="5%">&nbsp;</th>
<th width="5%">&nbsp;</th>
</tr>
<c:forEach items="${candidateList }" var="candidate" varStatus="status"> 
			<tr class="${status.index % 2 == 0 ? 'box3Grey' : 'box3White'}">
				<td align="center">${status.count}</td>
				<td align="center">${candidate.firstName }&nbsp;${candidate.lastName }</td>
				<td align="center">${candidate.email }</td>
				<td align="center">${candidate.skills }</td>
				<td align="center">${candidate.result }</td>
				<td align="center">
				<div class="button_red" style="width:70px"><a href="javascript:openPopup('viewCandidate.htm?type=view&candidateID=${candidate.id }')" >View Profile</a></div>
				</td>
				<td align="center">
				<div class="button_red" style="width:100px"><a href="javascript:openPopup('viewCandidate.htm?type=edit&candidateID=${candidate.id }')" >Update Profile</a></div>
				
				</td>
			</tr>
</c:forEach>
</table>
</c:if>