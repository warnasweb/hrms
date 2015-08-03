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

<style>
#d2{
margin-left:-115px;
}


</style>

</head>
<body >
 <form id="candidateForm" action="${pageContext.request.contextPath}/candidateController/updateCandidate.htm" name="CandidateForm" method="Post" enctype="multipart/form-data">
 
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
							  <!--Table for Customer search starts-->
							  <a href="#" onclick="javascript:closeDiv();" class="cls"><img src="<%=request.getContextPath()%>/images/close.png" class="" title="Close Window" alt="Close" /></a>
							  <!--Table for Customer search ends-->
				
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
                              <td width="30%" align="left" class="greybox15text">Name:</td>
                              <td width="70%" align="left" class="redbox15text">${candidate.firstName }&nbsp;${candidate.lastName }
								<input type="hidden" name="id" id="id" value="${candidate.id }">
							  </td>
                            </tr>
                          </table></td>
						 
                        </tr>
						  
						 <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="30%" align="left" class="greybox15text">E-mail: </td>
                              <td width="70%" align="left" class="redbox15text">
								${candidate.email }
							  </td>
                            </tr>
                          </table></td>
                        </tr>
						 
						 <tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="30%" align="left" class="greybox15text">SkillSet: </td>
                              <td width="70%" align="left" class="redbox15text">
								${candidate.skills }
							  </td>
							 
                            </tr>
                          </table></td>
						 
                        </tr>
						<tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="30%" align="left" class="greybox15text">Notice Period:</td>
                              <td width="70%" align="left" class="redbox15text">
								${candidate.noticePeriod } <span class="arial12black" >(days)</span>
							  </td>
                            </tr>
                          </table></td>
						 
                        </tr>
						<tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="30%" align="left" class="greybox15text">Current CTC:</td>
                              <td width="70%" align="left" class="redbox15text">
								${candidate.currentCTC } <span class="arial12black" >(lacs)</span>
							  </td>
                            </tr>
                          </table></td>
						 
                        </tr>
						<tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="30%" align="left" class="greybox15text">Expected CTC:</td>
                              <td width="70%" align="left" class="redbox15text">
								${candidate.expectedCTC } <span class="arial12black" >(lacs)</span>
							  </td>
                            </tr>
                          </table></td>
						 
                        </tr>
						
						<tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="30%" align="left" class="greybox15text">Manager For:</td>
                              <td width="70%" align="left" class="redbox15text">
								${candidate.manager }
							  </td>
                            </tr>
                          </table></td>
						 
                        </tr>
						
						<tr>
                          <td  width="100%" colspan="2" class="box2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="30%" align="left" class="greybox15text">Result:</td>
                              <td width="70%" align="left" class="redbox15text">
								${candidate.result }
							  </td>
                            </tr>
                          </table></td>
						 
                        </tr>
						
                        <tr>
                          
						  <td  class="box1" colspan="2" align="center"><table width="40%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
							<td  align="center">
							
							<div  class="button_red" style="width:80px"><a href="${pageContext.request.contextPath}/interviewController/viewResume.htm?candidateID=${candidate.id}">View Resume</a></div>
							</td>
							<td  align="center">
								<div class="button_red" style="width:50px"><a href="#" onclick="closeDiv()">Close</a></div>
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