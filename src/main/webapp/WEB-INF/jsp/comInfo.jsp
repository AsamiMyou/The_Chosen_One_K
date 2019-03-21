<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>企业信息</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
.info {
	border: solid 2px #efefef;
}

.info td {
	border: solid 2px #efefef;
}
</style>
</head>

<body>
	<div class="wrap">
		<div class="total">
			<%@include file="/mainJsp/head.jsp"%>
			<div class="single">
				<c:if test="${sessionScope.Admin == 'admin'}">
					<div class="mian">
						<table class="info" width="1541" height="590" align="center"
							cellspacing="0">
							<tr>
								<td align="center">企业姓名:</td>
								<td align="center">${com.cname }</td>
								<td align="center">企业头像:</td>
								<td align="center"><c:if test="${ not empty cuser.avatar}">
										<a href="${cuser.avatar }" data-lightbox="roadtrip">查看</a>
									</c:if> <c:if test="${empty cuser.avatar}">
								该用户还未上传自己的头像
								</c:if></td>
							</tr>
							<tr>
								<td align="center">联系电话：</td>
								<td align="center">${cuser.phone }</td>
								<td align="center">邮箱：</td>
								<td align="center">${cuser.email }</td>
							</tr>
							<tr id="accountInfo">
								<td width="375" align="center">账号：</td>
								<td width="364" align="center">${cuser.account }</td>
								<td width="350" align="center" colspan="2"></td>
							</tr>
							<tr>
								<td align="center">公司负责人:</td>
								<td align="center">${com.person }</td>
								<td align="center">负责人身份证号码：</td>
								<td align="center">${com.personId }</td>
							</tr>
							<tr>
								<td align="center">营业执照到期时间:</td>
								<td align="center"><fmt:formatDate value="${com.comDate }"
										pattern="yyyy-MM-dd" /></td>
								<td align="center">公司营业执照编码：</td>
								<td align="center">${com.comNum }</td>
							</tr>
							<tr>
								<td align="center">注册资金（万元）：</td>
								<td align="center">${com.cmoney }</td>
								<td align="center">公司地址：</td>
								<td align="center">${com.address }</td>
							</tr>
							<tr>
								<td align="center">开户行地址：</td>
								<td align="center">${com.bankAddress }</td>
								<td align="center">开户行账号:</td>
								<td align="center">${com.bankAcoount }</td>
							</tr>
							<tr>
								<td align="center">主营业务：</td>
								<td align="center">${com.mainBussiness }</td>
								<td align="center">营业执照照片：</td>
								<td align="center"><a href="${com.cimgUrl }"
									data-lightbox="roadtrip">查看</a></td>
							</tr>
							<c:if test="${cuser.status == '0' }">
								<tr>
									<input type="hidden" id="suerId" name="uid"
										value="${cuser.id }">
									<td colspan="2" align="center"><button id="pass"
											class="editbtn" type="button" value="通过">通过</button></td>
									<td colspan="2" align="center"><button id="refuse"
											type="button" style="background-color: red;" class="editbtn"
											value="停用">停用</button></td>
								</tr>
							</c:if>
						</table>
					</div>
				</c:if>
				<c:if test="${sessionScope.Admin != 'admin'}">
					<div class="mian">
						<form action="/Com/edit" method="post">
							<table class="info" width="1541" height="590" align="center"
								cellspacing="0">
								<tr>
									<td align="center">企业姓名:</td>
									<td align="center">${com.cname }</td>
									<td align="center">企业头像:</td>
									<td align="center"><c:if test="${not empty cuser.avatar}">
											<a href="${cuser.avatar }" data-lightbox="roadtrip">查看</a>
										</c:if> <c:if test="${empty cuser.avatar}">
											<button type="button" value="上传头像" id="addAvatar"
												class="addAvatar">上传头像</button>
										</c:if></td>
								</tr>
								<tr>
									<td align="center">联系电话：</td>
									<td align="center" class="hdtd"><p class="hdp">${cuser.phone }</p>
										<input type="text" name="phone" class="hdinput"
										style="display:none"></td>
									<td align="center">邮箱：</td>
									<td align="center" class="hdtd"><p class="hdp">${cuser.email }</p>
										<input type="text" name="email" class="hdinput"
										style="display:none"></td>
								</tr>
								<c:if test="${not empty creator}">
									<tr id="accountInfo">
										<input type="hidden" id="suerId" name="id"
											value="${cuser.id }">
										<td width="375" align="center">账号：</td>
										<td width="364" align="center">${cuser.account }</td>
										<td width="350" align="center">密码修改</td>
										<td width="434" align="center"><button type="button"
												value="密码修改" id="changePass" class="addAvatar">密码修改</button></td>
									</tr>
								</c:if>
								<tr>
									<td align="center">公司负责人:</td>
									<td align="center" class="hdtd"><p class="hdp">${com.person }</p>
										<input type="text" name="person" class="hdinput"
										style="display:none"></td>
									<td align="center">负责人身份证号码：</td>
									<td align="center" class="hdtd"><p class="hdp">${com.personId }</p>
										<input type="text" name="personId" class="hdinput"
										style="display:none"></td>
								</tr>
								<tr>
									<td align="center">营业执照到期时间:</td>
									<td align="center" class="hdtd"><p class="hdp">
											<fmt:formatDate value="${com.comDate }"
												pattern="yyyy-MM-dd" />
										</p> <input type="date" name="comDate" class="hdinput"
										style="display:none"></td>
									<td align="center">公司营业执照编码：</td>
									<td align="center" class="hdtd"><p class="hdp">${com.comNum }</p>
										<input type="text" name="comNum" class="hdinput"
										style="display:none"></td>
								</tr>
								<tr>
									<td align="center">注册资金（万元）：</td>
									<td align="center" class="hdtd"><p class="hdp">${com.cmoney }</p>
										<input type="number" name="cmoney" class="hdinput"
										style="display:none"></td>
									<td align="center">公司地址：</td>
									<td align="center" class="hdtd"><p class="hdp">${com.address }</p>
										<input type="text" name="address" class="hdinput"
										style="display:none"></td>
								</tr>
								<tr>
									<td align="center">开户行地址：</td>
									<td align="center" class="hdtd"><p class="hdp">${com.bankAddress }</p>
										<input type="text" name="bankAddress" class="hdinput"
										style="display:none"></td>
									<td align="center">开户行账号:</td>
									<td align="center" class="hdtd"><p class="hdp">${com.bankAcoount }</p>
										<input type="text" name="bankAcoount" class="hdinput"
										style="display:none"></td>
								</tr>
								<tr>
									<td align="center">主营业务：</td>
									<td align="center" class="hdtd"><p class="hdp">${com.mainBussiness }</p>
									<input type="text" name="mainBussiness" class="hdinput"
										style="display:none">
									</td>
									<td align="center">营业执照照片：</td>
									<td align="center"><a href="${com.cimgUrl }"
									data-lightbox="roadtrip">查看</a></td>
								</tr>
								<c:if test="${not empty creator}">
									<tr>
										<td colspan="2" align="center"><button id="changeInfo"
												class="editbtn" type="button" value="修改信息">修改信息</button></td>
										<td colspan="2" align="center"><button id="editBtn"
												type="submit" style="display:none" class="editbtn"
												value="确定修改">确定修改</button></td>
									</tr>
								</c:if>
							</table>
						</form>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	$("#changeInfo").click(function() {
		$(".hdtd").each(function() {
			var p = $(this).find("p");
			var str = p.html();
			var inp = $(this).find("input");
			if (inp.length > 0) {
				var type = inp.attr("type");
				inp.val(str.trim());
				p.hide();
				inp.show();
			} else {
				var sel = $(this).find("select");
				sel.val(str);
				sel.show();
				p.hide();
			}

		})
		$("#editBtn").show();
		$(this).hide();
	})
	$("#pass").click(function() {
		var id = $("#suerId").val();
		$.get("/Admin/start", {
			"id" : id
		}, function(data) {
			if (data) {
				alert("账号已通过");
				window.location.reload();
			} else {
				alert("账号未通过")
			}
		})
	})
	$("#refuse").click(function() {
		var id = $("#suerId").val();
		$.get("/Admin/stop", {
			"id" : id
		}, function(data) {
			if (data) {
				alert("账号已拒绝");
				window.location.reload();
			} else {
				alert("账号未拒绝")
			}
		})
	})
</script>
<script>
	/* $.Pop(data,{
							Title:"修改密码",//标题</b><br> 
							Close:true,//是否显示关闭按钮 true(开)/false(关)</b><br> 
							Animation:"layerFadeIn",// 默认动画</b><br> 
							BoxBg:true, // 是否显示遮罩背景层 true(开)/false(关)</b><br>
							BoxDrag:true, // 是否可以移动弹出层 true(开)/false(关)</b><br>
							oxBgopacity:0.6, // 遮罩层的透明度 0-1 0完全透明1完全黑暗</b><br>
							ZIndex:99999, // 弹出层的cssz-index属性</b><br>
							Class:false, // 是否叠加css样式</b><br> 
							Btn:{
								yes:{vla:"修改密码",class:"btn btn-primary",ope:function(){
									alert($("#oldPass").val());
									alert($("#newPass").val());
									alert($("#renewPass").val());
								}}
								}// 按钮</b><br>
							});  */
	$("#addAvatar").click(function() {
		$.ajax({
			url : "/mainJsp/addAvatar.jsp?uid=" + $("#suerId").val(),
			cache : true,
			sync : false,
			dataType : "html",
			success : function(data) {
				$.Pop(data, 'confirm_2', function() {
						var id = $("#suerId").val();
						$.ajaxFileUpload({
							url : '/User/addAvatar',
							secureuri : false, //是否启用安全提交,默认false
							fileElementId : 'avat', //文件域id值
							data : {
								'uid' : id
							}, //其它参数
							success : function(data) {
								alert("头像添加成功");
								window.location.reload();
							},
							error : function(data, status, _exception) {
								alert("头像添加失败");
							}
						});
					return true;
				})
				
			}
		});
	})
	$("#changePass").click(function() {
		$.ajax({
			url : "/mainJsp/changePass.jsp",
			cache : true,
			sync : false,
			dataType : "html",
			success : function(data) {
				$.Pop(data, 'confirm_1', function() {
					var flag = false;
					var id = $("#suerId").val();
					var oldPass = $("#oldPass").val();
					var newPass = $("#newPass").val();
					var renewPass = $("#renewPass").val();
					if (!oldPass.length > 0 || !newPass.length > 0 || !renewPass.length > 0) {
						alert("请确认所有信息都已填写!");
					} else {
						if (newPass != renewPass) {
							alert("两次密码不一致，请确认后重新输入!")
						} else {
							$.ajax({
								type : "get",
								url : "/User/changePass",
								data : {
									id : id,
									oldPassword : oldPass,
									newPassword : newPass
								},
								async : false,
								success : function(data) {
									if (data) {
										flag = true;
										alert("密码修改成功!");
									} else {
										alert("原密码填写错误，请重试!");
									}
								}
							});
						}
					}
					return flag;
				})

			}
		});
	})
</script>