<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>登陆</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="wrap">
		<div class="total">
			<%@include file="/mainJsp/head.jsp"%>
			<div class="mian">
				<form id="loginForm" action="/Login/login" method="post" onsubmit="return check()">
					<div class="section group">
						<div style="float:left;width:40%">
							<img src="../images/timg.jpg">
						</div>
						<div class="desc span_3_of_2" style="float:right">
							<div class="options">
								<h3>登陆</h3>
								<ul class="ofh contact-form">
									<li class="first"><label>账号名：</label> <input type="text"
										id="account" name="account"></li>
									<li class="last"><label>密码:</label> <input type="password"
										id="pwd" name="password">
									<li class="last"><label>验证码:</label>
										<div>
											<input type="text" style="width: 40%;display:inline"
												id="code"><img id="codePic" src="/Login/getCode"
												style="height:31px;float:right;width:30%">
										</div></li>
								</ul>
							</div>
							<h2 class="price">
								<span id="Message" style="color:red"></span> <input id="canSub"
									type="hidden">
							</h2>
							<input type="submit" value="登陆" class="button1" id="submit">
						</div>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


<script type="text/javascript">
	var loginMessage = "<%=request.getAttribute("loginMessage")%>"; 
   　　if(loginMessage == "null" || loginMessage == undefined || loginMessage == null) {
   	
   	} else {
   		alert(loginMessage);
   	}
   	
   	function check() {
   		if($("#account").val() == '' || $("#account").val() == undefined ||$("#pwd").val() == '' || $("#pwd").val() == undefined ) {
			$("#Message").html("请填写账号密码").css("color","red");
			return false;
		}
		if($("#canSub").val() == 'y') {
			return true;
		} else {
			alert("请检查验证码是否正确");
			return false;
		}
   	}
$("#codePic").click(function() {
	$(this).attr("src","/Login/getCode?dt=" + new Date().getTime());
})
$("#code").change(function() {
	$.get("/Login/checkCode",{code:$(this).val()},function(data) {
		if(data ==true) {
			$("#canSub").val("y");
			$("#Message").html("验证码正确").css("color","green");
		} else {
			$("#Message").html("验证码错误").css("color","red");
			$("#canSub").val("n");
		}
	})
})
</script>