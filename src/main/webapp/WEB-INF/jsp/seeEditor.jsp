<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>帖子查看</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="/js/themes/default/default.css" />
<link rel="stylesheet" href="/js/plugins/code/prettify.css" />
<script charset="utf-8" src="/js/kindeditor.js"></script>
<script charset="utf-8" src="/js/lang/zh-CN.js"></script>
<script charset="utf-8" src="/js/plugins/code/prettify.js"></script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content1"]', {
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
		editor1.readonly(true);
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
			<div class="single">
				<div class="mian">
					<form name="example" method="post" action="/message/addMessage">
						<div class="author clear">
							<div class="content1 fr">
								<div class="img fr">
									<c:if test="${not empty userBean.avatar  }">
									<a href="/User/seeUserInfo?uid=${userBean.userId }">
									<img src="${userBean.avatar }" alt="">
									</a>
									</c:if>
									<c:if test="${empty userBean.avatar  }">
									<a href="/User/seeUserInfo?uid=${userBean.userId }">
									<img src="/attach/default.jpg" alt="">
									</a>
									</c:if>
								</div>
								<div class="info fr">
									<c:if test="${message.messageType == '1' }">
									<p>${userBean.sname }</p>
									<p>${userBean.majoy }</p>
									</c:if>
									<c:if test="${message.messageType == '2' }">
									<p>${userBean.cname }</p>
									<p>${userBean.mainBussiness }</p>
									</c:if>
								</div>
							</div>
						</div>
						<div>标题：${message.title }</div>
						<div>&nbsp;</div>
						<textarea name="content1" cols="100" rows="8"
							style="width:1554px;height:400px;visibility:hidden;"
							readonly="readonly">${message.content }</textarea>
						<br />
						<div style="color:  red;">注：登陆以后可以下载附件</div>
						<c:if test="${not empty sessionScope.user && message.status == '0'}">
						<input type="hidden" value="${message.id }" id="messageId">
						<div><button type="button" id="pass">审核通过</button><button id="refuse" style="float:right" type="button">拒绝</button></div>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>




<script type="text/javascript">
	$("#pass").click(function() {
		var mid = $("#messageId").val();
		$.get("/Message/passMessage",{"mid":mid},function(data) {
			if(data == true) {
				alert("审核通过！");
				window.location.reload();
			}
		})
	})
	$("#refuse").click(function() {
		var mid = $("#messageId").val();
		$.get("/Message/refuseMessage",{"mid":mid},function(data) {
			if(data == true) {
				alert("审核拒绝！");
				window.location.reload();
			}
		})
	})
</script>