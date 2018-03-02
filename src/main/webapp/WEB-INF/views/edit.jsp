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
    <div class="container w-70" style="height: 800px;">
		
		<form action="/ush/user/do_edit" method="post">
		  <div class="form-group">
		    <label for="id">编号:</label>
		    <input value="${userModel.id }" type="text" name="userModel.id" class="form-control" id="id" required="required" pattern="[0-9]{4,}" readonly="readonly" >
         
		    <label for="name">用户名:</label>
		    <input value="${userModel.name }" type="text" name="userModel.name" class="form-control" id="name" required="required" pattern="([0-9]|[a-z]|[A-Z]){6,}">
        
        <div class="form-group">
		   <label for="jobid"> 职&nbsp;&nbsp;业：</label>
            <select class="form-control" id="jobid" name="userModel.jobid">
              <c:forEach items="${userJobs }" var="ob">
                   <option   
                    value="${ob.jobid }">${ob.jobname}</option>
                    
              </c:forEach>
            </select> 
          </div> 
          <div class="form-group">
		  <label for="email">邮箱:</label>
		     <input value="${userModel.email }" type="email" name="userModel.email" class="form-control" id="email" required="required">
		    </div>
       
		    <div class="form-group">
		    <label >
		    	男:
		    	<input type="radio"  
		    		<c:if test="${userModel.sex==true }">checked="checked"</c:if>
		    	 class="form-control" name="userModel.sex" value="1">
		    </label>
		    <label >
		    	女:
		    	<input type="radio" 
		    		<c:if test="${userModel.sex==false }">checked="checked"</c:if>
		    	class="form-control" name="userModel.sex" value="0">
		    </label>
		   </div>
	
		    <label for="address">生日:</label>
		    <input value="<fmt:formatDate value='${userModel.birthday }' pattern='yyyy-MM-dd'/>"  type="date" name="userModel.birthday" class="form-control" id="birthday" required="required">
		    
		
		
		   <div class="form-group">
		     <label for="userHobby.name">爱好:</label>
	          <select class="form-control" id="userHobby.id" name="userModel.userHobby.id">
	            <c:forEach items="${list }"  var="obj">
	                <option value="${obj.userModel.userHobby.id }">${obj.userModel.userHobby.name }</option>
	             </c:forEach>
              </select>
	       </div>
	       
		  <button type="submit" class="btn btn-primary">保存</button>
		  <button type="reset" class="btn btn-primary">取消</button>
		  <button type="button" class="btn btn-success" onclick="javascript:history.go(-1)">返回</button>
		 </div>
		</form>
	</div>
</body>
</html>