<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
<p>
	principal : <sec:authentication property="principal"/><br/>
	principal.userId : <sec:authentication property="principal.userId"/><br/>
	principal.password : <sec:authentication property="principal.password"/><br/>
	principal.email : <sec:authentication property="principal.email"/><br/>
	principal.enabled : <sec:authentication property="principal.enabled"/><br/>
	principal.accountNonExpired : <sec:authentication property="principal.accountNonExpired"/><br/>
</p>

<p>
Sessions
<ul>
<c:forEach items="${sessions}" var="sessionVo">
	<li><c:out value="${sessionVo.principal.userId}"/></li>
	<ul>
	<c:forEach items="${sessionVo.sessions}" var="ss">
		<li><c:out value="${ss.sessionId}"/></li>
	</c:forEach>
	</ul>
</c:forEach>
</ul>
</p>

<form action="<c:url value='/doLogout' />"	method="post">
	<input type="submit" value="Log out" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>