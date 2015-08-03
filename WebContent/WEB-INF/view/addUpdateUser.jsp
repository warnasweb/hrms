<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/for_you.css" rel="stylesheet" type="text/css" />

<style>
#d2{
//margin-top:200px;
margin-left:-115px;
}


</style>

</head>
<body >
 <form id="UserForm" action="${pageContext.request.contextPath}/userController/saveUser.htm" name="UserForm" method="Post">
 
 <table align="left" border="0" id="d2" cellpadding="0" cellspacing="0" width="50%">
            <tr>
              <td valign="top"><table align="center" id="" border="0" cellpadding="0" cellspacing="0" width="500">
                  <tr>
                    <td><table align="left" border="0" cellpadding="0" cellspacing="0" width="500">
                        <tr>
                          <td><img name="index_r2_c1" src="<%=request.getContextPath()%>/images/index_r2_c1.jpg" width="11" height="39" border="0" id="index_r2_c1" alt="" /></td>
                          <td width="500" background="<%=request.getContextPath()%>/images/index_r2_c2.jpg">
						  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="70%" align="left" valign="middle" >
							  <span class="redbox18text">${pgHead }</span></td>
							  <td valign="middle"  align="right">
							  <a href="#" onclick="javascript:closeDiv();" class="cls"><img src="<%=request.getContextPath()%>/images/close.png" class="" title="Close Window" alt="Close" /></a>
				
							</td>
                            </tr>
                          </table></td>
                          <td><img name="index_r2_c3" src="<%=request.getContextPath()%>/images/index_r2_c3.jpg" width="11" height="39" border="0" id="index_r2_c3" alt="" /></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td width="500"  valign="top" class="csbox1bg" >
					<table width="98%" border="0"  align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td height="10" colspan="2" align="right"></td>
                          </tr>
                        <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="40%" align="left" class="greybox15text">First Name*:</td>
                              <td width="60%" align="left">
								<input type="text" name="firstName" id="firstName" value="${user.firstName }">
								<c:if test="${frmType eq 'edit'}">
									<input type="hidden" name="userID" id="userID" value="${user.userID }">
									<input type="hidden" name="password" id="password" value="${user.password }">
								</c:if>
							  </td>
                            </tr>
                          </table></td>
						 
                        </tr>
						 <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="40%" align="left" class="greybox15text">Last Name: </td>
                              <td width="60%" align="left">
								<input type="text" name="lastName" id="lastName" value="${user.lastName }">
							  </td>
                            </tr>
                          </table></td>
						 
                        </tr>
						 <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="40%" align="left" class="greybox15text">E-mail: </td>
                              <td width="60%" align="left">
								<input type="text" name="email" id="email" value="${user.email }">
							  </td>
                            </tr>
                          </table></td>
                        </tr>
						 <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="40%" align="left" class="greybox15text">Role: </td>
                              <td width="60%" align="left">
								<input type="text" name="role" id="role" value="${user.role }">
							  </td>
							 
                            </tr>
                          </table></td>
						 
                        </tr>
                        <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="40%" align="left" class="greybox15text">UserName: </td>
                              <td width="60%" align="left">
								<input type="text" name="userName" id="userName" value="${user.userName }">
							  </td>
							 
                            </tr>
                          </table></td>
						 
                        </tr>
                        <c:if test="${frmType eq 'new'}">
                        <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="40%" align="left" class="greybox15text">Passowrd *: </td>
                              <td width="60%" align="left">
								<input type="password" name="password" id="password" value="">
							  </td>
							 
                            </tr>
                          </table></td>
						 
                        </tr>
                        <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="40%" align="left" class="greybox15text">Confirm Password *: </td>
                              <td width="60%" align="left">
								<input type="password" name="confirm" id="confirm" value="">
							  </td>
							 
                            </tr>
                          </table></td>
						 
                        </tr>
						</c:if>
                        <tr>
                          
						  <td  class="box1" colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
							<td align="right">
							<input type="button" value="" onclick="saveUser(this.form, '${frmType == 'new' ? 'save' : 'update'}')" style="" class="sub_btn"/>
							</td>
							<td>&nbsp;</td>
							
							<td align="left">
								<input type="reset" value=""  style="" class="csl_btn"/>
							</td>
                              
                            </tr>
                          </table></td>
                        </tr>
                        
                       
                        
                        <tr>
                          <td colspan="2" align="left" ></td>
                        </tr>
                        
                        <tr>
                          <td height="15" align="center" >&nbsp;</td>
                          <td height="15" align="center" >&nbsp;</td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td><img name="index_r6_c1" src="<%=request.getContextPath()%>/images/index_r6_c1.jpg" width="500" height="13" border="0" id="index_r6_c1" alt="" /></td>
                  </tr>
              </table></td>
              
            </tr>
           
           
          </table>
          </form>
</body>
</html>