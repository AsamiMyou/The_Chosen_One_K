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

<title>首页</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>

<body>
	<div class="wrap">
		<div class="total">
			<%@include file="/mainJsp/head.jsp"%>
			<div class="banner">
				<div class="header-para">
					<ul class="customcontent-top">
						<li class="item  first_item">
							<div class="item_html">
								<a href="#">
									<div class="banner1">
										<span class="text10">Never</span> <span class="text11">Give
											Up </span>
									</div>
								</a>
							</div>
						</li>
						<li class="item  last_item">
							<div class="item_html">
								<a href="#">
									<div class="banner2">
										<span class="text13">NEVER </span> <span class="text14">SETTLLE</span>
									</div>
								</a>
							</div>
						</li>
					</ul>
				</div>
				<div class="slider">
					<div id="slideshow">
						<ul class="slides">
							<div class="swiper-container">
								<div class="swiper-wrapper">
									<div class="swiper-slide">
										<img src="images/index-1.jpg">
									</div>
									<div class="swiper-slide">
										<img src="images/index-2.jpg">
									</div>
									<div class="swiper-slide">
										<img src="images/index-3.jpg">
									</div>
								</div>
								<!-- Add Arrows -->
								<div class="swiper-button-next"></div>
								<div class="swiper-button-prev"></div>
							</div>
						</ul>

					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="mian">
				<div class="content-top">
					<div class="sellers">
						<h4>
							<span><span>毕业生信息</span> 展示</span>
						</h4>
					</div>
					<div class="section group t1" id="stuDiv">
					</div>
				</div>
				<div class="content-top">
					<div class="sellers">
						<h4>
							<span><span>企业信息</span> 展示</span>
						</h4>
					</div>
					<div class="section group t1" id="comDiv">
					</div>
				</div>
			</div>
		</div>
		<script>
			var swiper = new Swiper('.swiper-container', {
				navigation : {
					nextEl : '.swiper-button-next',
					prevEl : '.swiper-button-prev',
				},
			});
		</script>
		<script>
			$(function() {
				var stustr = "";
				var comstr = "";
				$.ajax({
					type : "get",
					url : "/User/getStuCom",
					async : false,
					success : function(data) {
						var comlt = data.comlist;
						var stult = data.stulist;
						for (var i = 0; i < stult.length; i++) {
							stustr += '<div class="col_1_of_4 span_1_of_4"><div class="product-desc">';
							if(stult[i].avatar != '' && stult[i].avatar != null) {
								stustr += '<a href="/User/seeUserInfo?uid=' +stult[i].userId+ '"><img src="'+stult[i].avatar+'" alt="" /></a>';
							} else {
								stustr += '<a href="/User/seeUserInfo?uid=' +stult[i].userId+ '"><img src="images/default.jpg" alt="" /></a>';
							}
							stustr += '<h4>'+stult[i].sname+'</h4></div><div class="prod-inner">';
							stustr += '<span class="price">'+stult[i].majoy+'</span>';
							stustr += '<a href="/User/seeUserInfo?uid='+stult[i].userId+'" class="button" rel="nofollow">查看详情</a>';
							stustr += '<div class="clear"></div></div></div>';
						}
						stustr += '<div class="clear"></div>';
						for (var i = 0; i < comlt.length; i++) {
							comstr += '<div class="col_1_of_4 span_1_of_4"><div class="product-desc">';
							if(comlt[i].avatar != '' && comlt[i].avatar != null) {
								comstr += '<a href="/User/seeUserInfo?uid=' +comlt[i].userId+ '"><img src="'+comlt[i].avatar+'" alt="" /></a>';
							} else {
								comstr += '<a href="/User/seeUserInfo?uid=' +comlt[i].userId+ '"><img src="images/default.jpg" alt="" /></a>';
							}
							comstr += '<h4>'+comlt[i].cname+'</h4></div><div class="prod-inner">';
							comstr += '<span class="price">'+comlt[i].mainBussiness+'</span>';
							comstr += '<a href="/User/seeUserInfo?uid='+comlt[i].userId+'" class="button" rel="nofollow">查看详情</a>';
							comstr += '<div class="clear"></div></div></div>';
						}
						comstr += '<div class="clear"></div>';
					}
				});
			$("#stuDiv").append(stustr);
			$("#comDiv").append(comstr);
			});
		</script>
</body>
</html>
