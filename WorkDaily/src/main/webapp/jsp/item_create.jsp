<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="head.jsp" %>
<link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
</head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">工作日志平台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<li><a href="#">${user.userName}</a></li>
            <li><a href="<%=request.getContextPath()%>/user/loginOff">退出</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="<%=request.getContextPath()%>/schedule/itemOngoing?">正在进行</a></li>
            <li><a href="<%=request.getContextPath()%>/schedule/itemPlan?">待办事项</a></li>
            <li><a href="<%=request.getContextPath()%>/schedule/itemComplete?">完成事项</a></li>
            <li class="active"><a href="<%=request.getContextPath()%>/schedule/itemCreate?edit=0">新建事项</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">用户信息</a></li>
            <li><a href="">密码修改</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">管理用户</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<h2 class="sub-header">创建计划事项</h2>
			
			<form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/schedule/itemCreate?edit=1" method="post">
			
			   <div class="form-group">
			      <label for="type" class="col-sm-2 control-label">事项类型</label>
			      <div class="col-sm-8">
			         <select class="form-control" name="type">
				         <option value="正常任务">正常任务</option>
				         <option value="紧急任务">紧急任务</option>
				         <option value="计划任务">计划任务</option>
				         <option value="其他任务">其他任务</option>
				      </select>
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="content" class="col-sm-2 control-label">事项内容</label>
			      <div class="col-sm-8">
			         <input type="text" class="form-control" name="content" 
			            placeholder="请输入待办事项内容">
			      </div>
			   </div>
			   
			   <div class="form-group">
			      <label for="level" class="col-sm-2 control-label">事项级别</label>
			      <div class="col-sm-8">
			         <select class="form-control" name="level">
				         <option value="A">A——处理时间为10个工作日以上的（不含10个工作日）</option>
				         <option value="B">B——处理时间为6—10个工作日的</option>
				         <option value="C">C——处理时间为3—5个工作日的</option>
				         <option value="D">D——处理时间为2个工作日以内的（含2个工作日）</option>
				      </select>
			      </div>
			   </div>
			   
			   <div class="form-group">
			      <label for="operator" class="col-sm-2 control-label">执行人员</label>
			      <div class="col-sm-8">
			         <input type="text" class="form-control" name="operator" value="${user.userName}">
			      </div>
			   </div>
			   
			   <div class="form-group">
			      <label for="note" class="col-sm-2 control-label">事项备注</label>
			      <div class="col-sm-8">
			         <input type="text" class="form-control" name="note" 
			            placeholder="请输入事项备注">
			      </div>
			   </div>
			   
			   <div class="form-group">
			      <div class="col-sm-offset-2 col-sm-8">
			         <button type="submit" class="btn btn-lg btn-primary btn-block">提交</button>
			      </div>
			   </div>
			</form>
          
        </div>
      </div>
    </div>
  </body>
<script type="text/javascript">

</script>
</html>