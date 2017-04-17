<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
<ol>
<c:forEach var="user" items="${users}">
<li><a href="/renton/user/id/${user.userId}"><c:out value="${user.userId}"/></a> <c:out value="${user.userName}"/> <c:out value="${user.email}"/></li>
</c:forEach>
</ol>
<button onclick="javascript:location.href='/renton/user/viewinsert';">생성</button>
</body>
</html>