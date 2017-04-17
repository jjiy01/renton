<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	<ul>
		<li>ID : <c:out value="${role.roleId}"/></li>
		<li>Name : <c:out value="${role.roleName}"/></li>
		<li>Description : <c:out value="${role.description}"/></li>
		<li>Authorities</li>
			<ul>
				<c:forEach var="auth" items="${auths}">
					<li><input type="checkbox" name="authorities" disabled id="<c:out value="${auth.authId}"/>"><c:out value="${auth.authority}"/></input></li>
				</c:forEach>
			</ul>
	</ul>
	<button onclick="javascript:location.href='<c:url value="/role"/>';">목록</button>
	<button onclick="javascript:location.href='<c:url value="/role/update/${role.roleId}"/>';">수정</button>
</body>
</html>