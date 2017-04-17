<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Role</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value="/lib/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" ></link>
<script type="text/javascript" src="<c:url value="/lib/jquery/jquery-3.2.1.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/lib/bootstrap/js/bootstrap.min.js"/>" ></script>
<script type="text/javascript">
$(document).ready(function(){

	<c:forEach var="auth" items="${role.authorities}">
	$('#<c:out value="${auth}"/>').attr('checked', true);
	</c:forEach>

});
</script>
</head>
<body>
	<form action="<c:url value='/role/update'/>" method="POST">
		Name : <input type="text" name="roleName" value="<c:out value="${role.roleName}"/>"></input><br/>
		Description : <textarea rows="4" cols="10" name="description"><c:out value="${role.description}"/></textarea><br/>
		Authorities<br/>
		<c:forEach var="auth" items="${auths}">
		<input type="checkbox" id="<c:out value="${auth.authId}"/>" name="authorities" value="<c:out value="${auth.authId}"/>"><c:out value="${auth.authority}"/></input><br/>
		</c:forEach>
		<input type="submit"/>
		<input type="hidden" name="roleId" value="<c:out value="${role.roleId}"/>"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>