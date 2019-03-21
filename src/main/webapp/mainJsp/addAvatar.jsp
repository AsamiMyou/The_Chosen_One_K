<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String uid = request.getParameter("uid");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>添加头像</title>
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
	<form id="addAva" action="/User/addAvatar" method="post" enctype="multipart/form-data">
	<table><input name="uid" value="${param.uid}" type="hidden">
	<tr><td>上传头像</td><td><input type="file" name="avatar" id="avat"></td></tr>
	</table>
	</form>
</body>
</html>
