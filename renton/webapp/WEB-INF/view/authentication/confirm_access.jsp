<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ page
	import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page
	import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<title>REST</title>
</head>

<body>

	<h1>REST</h1>

	<div id="content">

			<h2>Please Confirm</h2>

			<p>
				You hereby authorize "
				<c:out value="${client.clientId}" />
				" to access your protected resources with scopes :
			</p>
			<ul>
				<c:forEach var="scope" items="${auth_request.scope}">
					<li>${scope}</li>
				</c:forEach>
			</ul>



			<form id="confirmationForm" name="confirmationForm"
				action="<%=request.getContextPath()%>/auth/oauth/authorize" method="post">
				<input name="user_oauth_approval" value="true" type="hidden" /> <label><input
					name="authorize" value="Authorize" type="submit"></label>
			</form>
			<form id="denialForm" name="denialForm"
				action="<%=request.getContextPath()%>/auth/oauth/authorize" method="post">
				<input name="user_oauth_approval" value="false" type="hidden" /> <label><input
					name="deny" value="Deny" type="submit"></label>
			</form>
	</div>

	<div id="footer">
		Sample application for <a
			href="http://github.com/SpringSource/spring-security-oauth"
			target="_blank">Spring Security OAuth</a>
	</div>


</body>
</html>
