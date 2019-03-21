<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>注册</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="wrap">
		<div class="total">
			<%@include file="/mainJsp/head.jsp"%>
			<div class="mian">
				<div class="single">
					<div class="section group">
						<div class="col span_2_of_3">
							<div class="contact-form">
								<h3>用户注册</h3>
								<form method="post" action="/register/registerUser" id="register" enctype="multipart/form-data">
									<div id="form1">
										<div>
											<span><label>用户类型</label></span> <span
												style="text-align:center">
												<div class="checkboxWrap">
													<input type="radio" name="type" class="forLabel" id="a"
														value="1" ><label for="a">学生</label>
												</div>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<div class="checkboxWrap">
													<input type="radio" name="type" class="forLabel" id="b"
														value="2" checked="checked"><label for="b">企业</label>
												</div>
											</span>
										</div>
										<div>
											<span><label>用户账号<span class="required">*</span></label></span>
											<span><input id="account" name="account" type="text"
												required="required"></span>
										</div>
										<div>
											<span><label>用户密码<span class="required">*</span></label></span>
											<span><input id="passwd" name="password"
												type="password" required="required" class="textbox"></span>
										</div>
										<div>
											<span><label>确认密码<span class="required">*</span></label></span>
											<span><input id="conformpasswd" type="password"
												required="required" class="textbox"></span>
										</div>
										<div>
											<span><label>联系手机</label></span> <span><input
												id="phone" name="phone" type="text"></span>
										</div>
										<div>
											<span><label>邮箱地址</label></span> <span><input
												id="email" name="email" type="text"></span>
										</div>
										<a class='button-contact' id="next">下一步</a>
									</div>

									<div id="form3" style="display:none" class="contact-forminput">
										<div>
											<span><label>企业名称<span class="required">*</span></label></span> <span> <input
												class="re" name="cname" type="text" required="required">
											</span>
										</div>
										<div>
											<span><label>法人代表或负责人<span class="required">*</span></label></span> <span><input
												class="re" name="person" type="text" required="required"></span>
										</div>
										<div>
											<span><label>法人代表或负责人身份证号<span class="required">*</span></label></span> <span><input
												class="re" name="personId" type="text" required="required"></span>
										</div>
										<div>
											<span><label>注册资金（万元）<span class="required">*</span></label></span> <span><input
												class="re" name="cmoney" type="number" required="required"></span>
										</div>
										<div>
											<span><label>详细地址<span class="required">*</span></label></span> <span><input
												class="re" name="address" type="text" required="required"></span>
										</div>
										<div>
											<span><label>银行开户行<span class="required">*</span></label></span> <span><input
												class="re" name="bankAddress" type="text" required="required"></span>
										</div>
										<div>
											<span><label>银行账户<span class="required">*</span></label></span> <span><input
												class="re" name="bankAcoount" type="text" required="required"></span>
										</div>
										<div>
											<span><label>营业执照编号<span class="required">*</span></label></span> <span><input
												class="re" name="comNum" type="text" required="required"></span>
										</div>
										<div>
											<span><label>主营业务<span class="required">*</span></label></span> <span><input
												class="re" name="mainBussiness" type="text" required="required"></span>
										</div>
										<div>
											<span><label>营业执照截止日期<span class="required">*</span></label></span> <span><input
												class="re" name="comDate" type="date" required="required"></span>
										</div>
										<div>
											<span><label>营业执照复印件<span class="required">*</span></label></span> <span><input
												class="re" name="cimgUrl" type="file" required="required"></span>
										</div>
										<a href='#' class='button-contact back' style="float:left">上一步</a>
										<button class='button-contact' type="submit">提交</button>
									</div>

									<div id="form2" style="display:none" class="contact-forminput">
										<div>
											<span><label>性别</label></span> <span
												style="text-align:center">
												<div class="checkboxWrap">
													<input type="radio" name="sex" class="forLabel" id="aaa"
														value="男" checked="checked"><label for="aaa">男</label>
												</div>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<div class="checkboxWrap">
													<input type="radio" name="sex" class="forLabel" id="bbb"
														value="女"><label for="bbb">女</label>
												</div>
											</span>
										</div>
										<div>
											<span><label>姓名<span class="required">*</span></label></span> <span><input
												class="re" name="sname" type="text" required="required"></span>
										</div>
										<div>
											<span><label>出生日期<span class="required">*</span></label></span> <span><input
												class="re" name="birthday" type="date" required="required"></span>
										</div>
										<div>
											<span><label>学号<span class="required">*</span></label></span> <span><input
											class="re"	name="studentId" type="text" required="required"></span>
										</div>
										<div>
											<span><label>专业<span class="required">*</span></label></span> <span><input
												class="re" name="majoy" type="text" list="majoys" required="required"> <datalist
													id="majoys">
													<c:forEach var="majoys" items="${majoys }"> 
													<option value="${majoys.majoyName }">
													</c:forEach>
												</datalist> </span>
										</div>
										<div>
											<span><label>年级<span class="required">*</span></label></span><span> <select name="level" >
													<option>一年级</option>
													<option>二年级</option>
													<option>三年级</option>
													<option>四年级</option>
											</select>
											</span>
										</div>
										<div>
											<span><label>当前状态<span class="required">*</span></label></span> <span><select name="sstatus" >
													<option>在读</option>
													<option>待就业</option>
													<option>已就业</option>
											</select></span>
										</div>
										<div>
											<span><label>预期工作城市<span class="required">*</span></label></span> <span><input
												name="city" type="text" list="citys" class="re" required="required"> <datalist
													id="citys">
													<c:forEach var="citys" items="${citys }"> 
													<option value="${citys.cityName }">
													</c:forEach>
												</datalist> </span>
										</div>
										<div>
											<span><label>期望职业<span class="required">*</span></label></span> <span><input
												name="job" type="text" list="jobs" class="re" required="required"> <datalist
													id="jobs">
													<c:forEach var="jobs" items="${jobs }"> 
													<option value="${jobs.jobName }">
													</c:forEach>
												</datalist> </span>
										</div>
										<div>
											<span><label>期望薪资（K/月）</label></span> <span><input
												name="smoney" type="text"></span>
										</div>
										<div>
											<span><label>学生证首页照<span class="required">*</span></label></span> <span><input
												name="simgUrl" type="file" class="re" required="required"></span>
										</div>
										<a href='#' class='button-contact back' style="float:left">上一步</a>
										<button class='button-contact' type="submit">提交</button>
									</div>

								</form>
							</div>
						</div>
						<div class="col span_1_of_3">
							<div class="company_address">
								<h3>注册须知 :</h3>
								<p>注册时请务必确保信息的准确性,</p>
								<p>学生注册需要提供有效的学生证号,</p>
								<p>企业注册需要提供有效的营业执照信息,</p>
								<p>如果信息与本人有出入,</p>
								<p>本平台有权停用或注销问题账户。</p>
								<p>
									有问题请咨询 Email: <span>jskfm1995@gmail.com</span>
								</p>
								<p>
									联系电话: <span>18309224483</span>
								</p>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
</body>
</html>


<script type="text/javascript">
	$("#conformpasswd").change(function() {
		var pwd = $("#passwd").val();
		if ($(this).val() != pwd) {
			alert("两次密码不一致，请确认后输入");
			$(this).focus();
		}
	})
	$("#next").click(function() {
		if ($("#account").val() == "" || $("#account").val() == undefined) {
			alert("请正确填写账号信息");
			return false;
		}
		if ($("#passwd").val() == "" || $("#passwd").val() == undefined) {
			alert("请正确填写密码");
			return false;
		}
		if ($("#conformpasswd").val() == "" || $("#conformpasswd").val() == undefined) {
			alert("请正确填写密码");
			return false;
		}
		if ($("#email").val() != "" ) {
			var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if (!filter.test($("#email").val())) {
				alert("邮箱格式不正确");
				return false;
			}
		}
		if ($("#phone").val() != "" ) {
			var filter = /^[1][3,4,5,7,8][0-9]{9}$/;
			if (!filter.test($("#phone").val())) {
				alert("手机号不正确");
				return false;
			}
		}
		$("#form1").hide();
		switch ($("input[name='type']:checked").val()) {
		case "1":
			$("#form2").show();
			$("#form2").find(".re").each(function() {
				$(this).attr("required","required");
			})
			$("#form3").find(".re").each(function() {
				$(this).removeAttr("required");
			})
			break;
		case "2":
			$("#form3").show();
			$("#form2").find(".re").each(function() {
				$(this).removeAttr("required");
			})
			$("#form3").find(".re").each(function() {
				$(this).attr("required","required");
			})
			break;
		}
	})
	$(".submit").click(function() {
		
		$("#register").submit();
	})
	$(".back").click(function() {
		$("#form2").hide();
		$("#form3").hide();
		$("#form1").show();
	})
</script>