<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE>
<html lang="zh-CN">
<head>
<%@ include file="/head.jsp" %>
</head>
<body>
	<div class="container">
		<form class="form-signin">
			<h2 class="form-signin-heading">登录系统</h2>
			<input type="text" id="username" class="form-control"
				placeholder="用户名" required autofocus> <input type="password"
				id="password" class="form-control" placeholder="密码" required>
			<div class="checkbox">
				<label><input type="checkbox" value="remember-me">记住我</label>
			</div>
			<button id="login" class="btn btn-lg btn-primary btn-block">登录</button>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#login").click(function() {
				/* $.post("http://localhost:8080/WorkDaily/user/login?", {
					suggest : txt
				}, function(result) {
					//$("span").html(result);
				}); */
				
				$.ajax({
			        url: '/user/login?',
			        async: true,
			        dataType: 'json',
			        type: 'PUT',
			        //data: JSON.stringify({status:cur_status}),
			        success: function(data , textStatus){
			          console.log("success");
			        },
			        error: function(jqXHR , textStatus , errorThrown){
			          console.log("error");
			        },
			      });
			});
		});
	</script>
</body>
</html>