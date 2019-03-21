<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>发帖</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="/js/themes/default/default.css" />
	<link rel="stylesheet" href="/js/plugins/code/prettify.css" />
	<script charset="utf-8" src="/js/kindeditor.js"></script>
	<script charset="utf-8" src="/js/lang/zh-CN.js"></script>
	<script charset="utf-8" src="/js/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : '/js/plugins/code/prettify.css',
				uploadJson : '/mainJsp/upload_json.jsp',
				fileManagerJson : '/mainJsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="wrap">
		<div class="total">
			<%@include file="/mainJsp/head.jsp"%>
	  <div class="mian">
	  	<div>&nbsp;&nbsp;</div>
	  	<HR>
    	<form name="example" method="post" action="/Message/modifyMessage">
    	<input type="hidden" value="${message.id }" name="mid">
    	<div>标题：<input type="text" readonly="readonly" name="title" style="float: right;width: 80%;height: 25px;" value="${message.title }"></input></div>
    	<div>&nbsp;&nbsp;</div>
		<textarea name="content" cols="100" rows="8" style="width:1554px;height:400px;visibility:hidden;">${message.content }</textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
		</form>
 	   </div>
 	   </div>
	</div>
</body>
</html>

<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>




<script type="text/javascript">
	
</script>