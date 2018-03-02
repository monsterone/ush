<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入css样式 -->
 <link rel="stylesheet" href="/ush/static/css/login.css">
 <!-- 引入js样式 -->
 <script src="/ush/static/js/login.js"></script>
</head>
<body>

		<div id="container">
        <div class="line"></div>
        <div id="picture"></div>
        <div id="content_1">
            <h2>系统登陆</h2>
            <div class="elepant"></div>
        </div>
        <form action="/ush/user/login" method="post" name="form"  onsubmit="return checkForm(this)">
            <div id="content">
                <p class="c1">
                                         用户名：
                    <input type="text" style="width: 230px;height:23px" name="username" placeholder="请输入您的用户名！">
                </p>
                <p class="c2">
                                            密　码：
                    <input type="password" style="width: 230px;height:23px" name="password" placeholder="请输入您的登陆密码！">
                </p>
                <p class="c3">
                    <input type="checkbox" name="checked">记住密码
                </p>
                <p class="c4">
                    <button style="submit" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登陆&nbsp;&nbsp;&nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button style="reset">&nbsp;&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button style="button">&nbsp;&nbsp;&nbsp;&nbsp;注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                </p>
            </div>
           
        </form>
    </div>
     ${mav }
</body>
</html>