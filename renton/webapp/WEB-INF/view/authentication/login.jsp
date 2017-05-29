<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sec:csrfMetaTags />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	if($.cookie('rememberedId') != undefined) {
		$('#userId').val($.cookie('rememberedId'));
		$('#rememberMe').prop('checked', true);
	}
	
	$('#loginForm').bind('submit', function() {
		if($('#rememberMe').prop('checked') == true) {
			$.cookie('rememberedId', $('#userId').val(), { expires : 7 });
		} else {
			$.removeCookie('rememberedId');
		}
	});
});
</script>
<title>Renton</title>
</head>
<body>
	<div class="container">
		<form id="loginForm" class="form-signin" action="${pageContext.request.contextPath}/doLogin" method="post">
			<c:if test="${param.error != null}">
				<div class="alert alert-error">
					Failed to login.
					<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
					Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</c:if>
				</div>
			</c:if>
			
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">ID</label>
			<input
				type="text" id="userId" name="userId" class="form-control"
				placeholder="ID" required autofocus> 
			<label for="inputPassword" class="sr-only">Password</label> 
			<input
				type="password" id="password" name="password" class="form-control"
				placeholder="Password" required>
			<div class="checkbox">
				<label> 
					<input type="checkbox" id="rememberMe" value="remember-me">Remember me
				</label>
			</div>
			<sec:csrfInput />
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign	in</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>