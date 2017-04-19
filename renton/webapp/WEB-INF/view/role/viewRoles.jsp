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
<c:forEach var="role" items="${roles}">
<li><a href="<c:url value="/role/id/${role.roleId}"/>"><c:out value="${role.roleId}"/></a> <c:out value="${role.roleName}"/><br/>
<c:out value="${role.description}" /></li>
</c:forEach>
</ol>
<sec:authorize access="hasPermission('ROLE', 'WRITE')">
<button onclick="javascript:location.href='<c:url value="/role/insert"/>';">생성</button>
</sec:authorize>
</body>
</html>