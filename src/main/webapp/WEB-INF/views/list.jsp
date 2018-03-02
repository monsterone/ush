<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<!-- 引入Jquery -->
  <script src="https://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 引入css样式 -->
 <link rel="stylesheet" href="/ush/static/css/style.css">
 <!-- 引入js样式 -->
 <script src="/ush/static/js/common.js"></script>
</head>
<body>
  <div id="nav">
        <h2 class="a">用户管理系统</h2>
        <h3 class="b"> 帮助&nbsp;&nbsp;&nbsp;&nbsp;退出</h3>
        <div class="p1"></div>
    </div>
    <div id="bia">
        <h3><a href="http://localhost:8080/ush/user/to_list">用户管理</h3>
        <hr>
        <h3><a href="http://localhost:8080/ush/job/to_list">职业管理</a></h3>
        <hr>
        <h3><a href="http://localhost:8080/ush/hobby/to_list">爱好管理</a></h3>
        <hr>
        <div class="p2"></div>
        <h3 class="c">当前登录用户</h3>
    </div>
    <div class="container w-75">
    <a class="btn btn-primary" href="to_save?id=${obj.id}">用户新增</a>
    <a class="btn btn-danger" href="#=${obj.id}">批量删除</a>
    <a class="btn btn-success" href="#=${obj.id}">导出用户</a>
      用户名称：
    <input name="userModel.name" type="text" value="${userModel.name }"/> 
      <a class="btn btn-primary" href="#=${obj.id}">查询</a>
      <a class="btn btn-primary" href="#=${obj.id}">重置</a>
		<table class="table thead-inverse table-striped table-bordered table-hover table-sm">
			<thead>
				<tr>
					<th>用户名</th>
					<th>职业</th>
					<th>邮箱</th>
					<th>性别</th>
					<th>生日</th>
					<th>爱好</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="obj">
					<tr>
						<td>${obj.name} </td>
						<td>${obj.uesrJob.jobname} </td>
						<td>${obj.email} </td>
						<td>
							<c:if test="${obj.sex}">男</c:if>
							<c:if test="${!obj.sex}">女</c:if>
						</td>
						<td>
							<fmt:formatDate value="${obj.birthday}" pattern="yyyy-MM-dd"/>
						</td>
						<td>${obj.userHobby.name}</td>
						<td>${obj.createDate} </td>
						<td>
							<a class="btn btn-sm btn-info" href="to_info?id=${obj.id}">详情</a>
							<a class="btn btn-sm btn-warning" href="to_edit?id=${obj.id}">编辑</a>
							<a class="btn btn-sm btn-danger" href="delete?id=${obj.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>        
	</div>
</body>
</html>