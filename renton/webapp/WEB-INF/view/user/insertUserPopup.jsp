<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/common.jsp"%>

<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">Register User</h4>
</div>

<div class="modal-body">
	<form>
	ID : <input type="text" name="userId"/><br/>
	Name : <input type="text" name="userName"/><br/>
	Email : <input type="text" name="email"/><br/>
	Password : <input type="text" name="password"/><br/>
	<sec:csrfInput />
	</form>
</div>

<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	<button id="userSubmit" type="button" class="btn btn-primary">Save changes</button>
</div>

<script type="text/javascript">
$(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$('#userSubmit').bind('click', function() {
		console.log('click');
		$.ajax({
			url : '${pageContext.request.contextPath}/user/insert',
			type : 'POST',
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify({
				"userId" : $('[name="userId"]').val(),
				"userName" : $('[name="userName"]').val(),
				"email" : $('[name="email"]').val(),
				"password" : $('[name="password"]').val()
			}),
			beforeSend : function(request) {
				request.setRequestHeader(header, token);
			},
			success : function(data) {
				$('#userCreateModal').modal('hide');
				
				if(data.result == '0') {
					$('successAlert').removeClass('hidden');
				} else {
					
				}
			},
			error : function(request, status, error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
});
</script>