<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert User</title>
</head>
<body>
<form action="insert" method="POST">
ID : <input type="text" name="userId"/><br/>
Name : <input type="text" name="userName"/><br/>
Email : <input type="text" name="email"/><br/>
Password : <input type="text" name="password"/><br/>
<input type="submit"/>
<sec:csrfInput />
</form>
</body>
</html>