<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>

<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal">&times;</button>
	<h4 class="modal-title">Authorities</h4>
</div>
<div class="modal-body">
	<ol>
		<c:forEach var="auth" items="${auths}">
			<li><c:out value="${auth.authority}" /></li>
		</c:forEach>
	</ol>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>