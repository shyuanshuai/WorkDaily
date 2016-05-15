<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <li class="active"><a href="<%=request.getContextPath()%>/schedule/itemOngoing?">正在进行</a></li>
            <li><a href="<%=request.getContextPath()%>/schedule/itemPlan?">待办事项</a></li>
            <li><a href="<%=request.getContextPath()%>/schedule/itemComplete?">完成事项</a></li>
            <li><a href="<%=request.getContextPath()%>/schedule/itemCreate?edit=0">新建事项</a></li>
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

          <h2 class="sub-header">正在进行事项</h2>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>事项类型</th>
                  <th>事项内容</th>
                  <th>状态</th>
                  <th>级别</th>
                  <th>执行人员</th>
                  <th>下发人员</th>
                  <th>创建时间</th>
                  <th>执行时间</th>
                  <th>备注</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${schedules}" var="schedule" varStatus="xh">
					<tr>
					  <td>${xh.count}</td>
	                  <td>${schedule.type}</td>
	                  <td>${schedule.content}</td>
	                  <td>${schedule.status}</td>
	                  <td>${schedule.level}</td>
	                  <td>${schedule.operator}</td>
	                  <td>${schedule.assignUser}</td>
	                  <td><fmt:formatDate value="${schedule.createTime}" type="date"/></td>
	                  <td><fmt:formatDate value="${schedule.executeTime}" type="date"/></td>
	                  <td>${schedule.note}</td>
	                  <td><button type="button" class="btn btn-primary btn-xs"
											onclick="javascript:window.location.href='<%=request.getContextPath()%>/schedule/updateItemToComplete?id=${schedule.id}';">完成任务</button></td>
	                </tr>
			 	</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>