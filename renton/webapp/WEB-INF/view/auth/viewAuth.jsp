<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<ul>
<li>ID : <c:out value="${auth.authId}"/></li>
<li>Name : <c:out value="${auth.authority}"/></li>
<li>Description : <c:out value="${auth.description}"/></li>
</ul>
<button onclick="javascript:location.href='<c:url value="/auth"/>';">목록</button>
</body>
</html>