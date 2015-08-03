<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty lstReport }">

<table class="box2s" align="center" bgcolor="#e9e9e9" border="0" cellpadding="0" cellspacing="1" width="60%">
<tr class="heading-white-13">
<th>${col0 }</th>
<th>${col1 }</th>
<th>${col2 }</th>
<th>${col3 }</th>
<th>&nbsp;</th>
</tr>
<c:forEach items="${lstReport }" var="panelBean" varStatus="status"> 
			<tr class="${status.index % 2 == 0 ? 'box3Grey' : 'box3White'}">
				<td align="center">${status.count}</td>
				<td align="center">${panelBean.firstName }&nbsp;${panelBean.lastName }</td>
				<td align="center">${panelBean.email }</td>
				<td align="center">${panelBean.designation }</td>
				<td align="center">
				<div class="button_red" style="width:70px"><a href="javascript:openPopup('openUpdatePanel.htm?panelID=${panelBean.id }')" >Update Panel</a></div>
				</td>
			</tr>
</c:forEach>
</table>
</c:if>