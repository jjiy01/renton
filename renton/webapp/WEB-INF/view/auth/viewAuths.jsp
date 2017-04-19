<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorities</title>
</head>
<body>
<ol>
<c:forEach var="auth" items="${auths}">
<li><a href="<c:url value="/auth/id/${auth.authId}"/>"><c:out value="${auth.authId}"/></a> <c:out value="${auth.authority}"/><br/>
<c:out value="${auth.description}" /></li>
</c:forEach>
</ol>
<sec:authorize access="hasPermission('AUTH', 'WRITE')">
<button onclick="javascript:location.href='<c:url value="/auth/viewinsert"/>';">생성</button>
</sec:authorize>
</body>
</html>