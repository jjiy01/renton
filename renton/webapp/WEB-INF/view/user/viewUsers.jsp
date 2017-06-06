<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>
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
$(function() {
	$('.alert').alert('close');
	
	$('#userCreateBtn').on('click', function() {
		$('#userCreateModal').modal();
	});
	
	$('#userCreateModal').on('show.bs.modal', function(e) {
		$('#userCreateModalContent').load('${pageContext.request.contextPath}/user/insertPopup');
	});
});
</script>
<title>Users</title>
</head>
<body>
<div id="successAlert" class="alert alert-success" role="alert">
  <strong>User Registered!</strong></a>.
</div>

<ol>
<c:forEach var="user" items="${users}">
<li><a href="/renton/user/id/${user.userId}"><c:out value="${user.userId}"/></a> <c:out value="${user.userName}"/> <c:out value="${user.email}"/></li>
</c:forEach>
</ol>
<!-- <button onclick="javascript:location.href='/renton/user/viewinsert';">생성</button> -->
<button id="userCreateBtn">생성</button>

<div id="userCreateModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div id="userCreateModalContent" class="modal-content">
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>