<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE>
<html lang="zh-CN">
<head>
<%@ include file="head.jsp" %>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="<%=request.getContextPath()%>/user/login?" method="post">
			<h2 class="form-signin-heading">登录系统</h2>
			<input type="text" name="username" class="form-control"
				placeholder="用户名" required autofocus> <input type="password"
				name="password" class="form-control" placeholder="密码" required>
			<div class="checkbox">
				<label><input type="checkbox" value="remember-me">记住我</label>
			</div>
			<button id="login" class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>
</body>
</html>