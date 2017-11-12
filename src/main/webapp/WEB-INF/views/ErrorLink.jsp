<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Allow/Deny Consent</title>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"></c:url>"></script>


</head>
<body>
			<table>
			
			<tr>
			
				<td><label> <strong><spring:message code="label.allow/deny" /></strong></label></td>
			
			</tr>
			
				<tr>
										
										<td>
											<input type="radio" name="ConsentStatus" value="Allow Consent" checked><spring:message code="label.allow" /><br>
  											<input type="radio" name="ConsentStatus" value="Deny Consent"><spring:message code="label.deny" /><br>
  											<input type="radio" name="ConsentStatus" value="Do Not Disturb"><spring:message code="label.dnd" />  
										</td>
									</tr>
									
									
			
			</table>
			

</body>
</html>