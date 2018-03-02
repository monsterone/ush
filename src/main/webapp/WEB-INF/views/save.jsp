<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
    <div id="for">
        <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;
	新增&编辑用户信息</h3>
	<div id="file"></div>
	<!-- 文件上传必须 method="post" enctype="multipart/form-data" -->
        <form action="#" method="post" id="file2" enctype="multipart/form-data">
            <input type="file" name="myFile"/>
            <input type="submit" value="上传"/>
        </form>
     <form action="/ush/user/do_save" id="testForm" method="post">
            <div>
                用户名称：
                <input id="name" name="userModel.name" type="text" placeholder="请输入您的用户名！" style="width: 500px;height: 30px;">
            </div>
            <div>
                登录密码：
                <input id="password" name="userModel.password" type="password" placeholder="请输入您的登录密码!" style="width:  500px;height: 30px;">
            </div>
            <div>
                重复密码：
                <input id="repeatPassword" name="userModel.repeatPassword" type="password" placeholder="请输入您的确认密码!" style="width:  500px;height: 30px;">
            </div>
            <div>
                电子邮箱：
                <input id="email" name="userModel.email" type="email" placeholder="请输入您的邮箱!" style="width:  500px;height: 30px;">
            </div>
            <div>
                出生日期：
                <input id="birthday" name="userModel.birthday" type="date" placeholder="请选择您的出生日期!" style="width:  500px;height: 30px;">
            </div>
           <div class="form-group">
               性别：
		    <label >
		    	男:
		    	<input type="radio" checked="checked" class="form-control" name="userModel.sex" value="true">
		    </label>
		    <label >
		    	女:
		    	<input type="radio" checked="checked" class="form-control" name="userModel.sex" value="false">
		    </label>
		   </div>
            <div>
            <label for="jobid"> 职&nbsp;&nbsp;业：</label>
            <select style="width: 500px;height:30px" id="jobid" name="userModel.jobid">
               <c:forEach items="${userJobs }" var="obj">
                     <option value="${obj.jobid }">${obj.jobname}</option>
               </c:forEach>
            </select>                        
            </div>
            <div>
                爱&nbsp;&nbsp;好:
                <!-- 多选框（按住Shift键）-->
                <select class="multiple-select" name="hobby" multiple="multiple" size="4" style="width: 506px;height:70px">
                    <option value="userModel.write">书法</option>
                    <option value="userModel.music">乐器</option>
                    <option value="userModel.sport">运动</option>
                    <option value="userModel.program">编程</option>
                </select>
            </div>
            <hr>
            <div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit" style="width: 70px;height: 30px;">保存</button>&nbsp;&nbsp;
                <button type="reset" style="width: 70px;height: 30px;">重置</button>&nbsp;&nbsp;
                <button style="width: 70px;height: 30px;" onclick="javascript:history.go(-1)">返回</button>
            </div>
        </form>
</body>
</html>