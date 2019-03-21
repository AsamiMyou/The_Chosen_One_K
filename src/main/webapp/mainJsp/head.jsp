<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/lightbox.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/swiper.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/datatables.min.css" rel="stylesheet" type="text/css" media="all" />
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/plug-in.js"></script>
<script src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>
<script src="../js/script.js" type="text/javascript"></script>
<script src="../js/superfish.js"></script>
<script src="../js/swiper.min.js"></script>
<script src="../js/lightbox.js"></script>
<div class="header">
	<div class="header-bot">
		<div class="logo">
			<a href="../index.jsp"><img src="../images/banner.jpg" alt="" /></a>
		</div>
		<div class="f-right">
			<p class="welcome-msg">欢迎光临天选之子就业网站</p>
			<div class="clear"></div>
			<ul class="links">
				<li class="first"><a href="/User/toStu" title="My Account">毕业生入口</a></li>
				<li><a href="/User/toCom" title="My Wishlist">企业入口</a></li>
					<c:if test="${empty sessionScope.user }">
					<li><a href="/register/toRegister" title="register"
					class="top-link-cart">注册</a></li>
				<li><a href="/Login/toLogin" title="Checkout"
					class="top-link-checkout">登陆</a></li>
					</c:if>
				<c:if test="${not empty sessionScope.user}">
				<c:if test="${sessionScope.Admin == 'admin'}">
				<li><a href="/Admin/toAdmin" title="admin"
					class="top-link-checkout">后台管理</a></li>
				</c:if>
				<c:if test="${empty sessionScope.Admin}">
				<li><a href="/User/toUserPage" title="admin"
					class="top-link-checkout">个人管理</a></li>
					<li><a href="/Message/toCreatorMessage" title="admin"
					class="top-link-checkout">我的发帖</a></li>
				</c:if>
				<li><a href="/Login/logOut" title="admin"
					class="top-link-checkout">登出</a></li>
				</c:if>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="header_bottom">
	<div class="omenu">
		<ul>
			<li class="active firstLi"><a href="../index.jsp">首页</a></li>
			<li id="seaStu" class="firstLi"><a>优秀毕业生</a></li>
			<li id="seaCom" class="firstLi"><a>入驻企业</a></li>

		</ul>
	</div>
	<div id="seaBox" class="search_box" style="display:none">
		<form action="/User/keywordSearch" id="seaForm" method="post">
			<input id="seaType" name="seaType" type="hidden"> <input type="text"
				name="Search" style="height:30px;box-sizing: border-box;"><button
				type="submit" id="searchBtn" value=""></button>
		</form>
	</div>
	<div class="clear"></div>
</div>


<script type="text/javascript">
	/* $("#searchBtn").click(function() {
		alert("1");
		$("#seaForm").submit();
	}) */
	$("#seaStu").click(function() {
		$(".firstLi").removeClass("active");
		$(this).addClass("active");
		$("#seaType").val("stu");
		$("#seaBox").show();
	})
	$("#seaCom").click(function() {
		$(".firstLi").removeClass("active");
		$(this).addClass("active");
		$("#seaType").val("com");
		$("#seaBox").show();
	})
</script>