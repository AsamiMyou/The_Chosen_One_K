<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>修改密码</title>
</head>
<style>
	.change table {
		width:480px;
	}
	.change td {
		width:220px;
	}
</style>
<body class="change">
	<table>
	<tr><td>原密码：</td><td><input type="password" id="oldPass"></td></tr>
	<tr><td>新密码：</td><td><input type="password" id="newPass"></td></tr>
	<tr><td>新密码确认：</td><td><input type="password" id="renewPass"></td></tr>
	</table>
</body>
</html>
