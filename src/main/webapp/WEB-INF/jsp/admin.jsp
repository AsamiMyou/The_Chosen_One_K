<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>后台管理</title>

<link rel="stylesheet" type="text/css" href="../js/themes/icon.css">
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet" type="text/css"
	href="../js/themes/default/easyui.css">
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
					<div class="easyui-accordion" style="width:1541px;height:750px;">
						<div title="审核用户" data-options="iconCls:'icon-ok'"
							style="overflow:auto;padding:10px;">
							<div id="container"
								style="margin-top:10px;padding:20px;border:1px solid #e1e0e0;">
								<table id="example" class="tripe" style="text-align:center">
									<thead>
										<tr>
											<th>序号</th>
											<th>账号</th>
											<th>账号类型</th>
											<th>创建时间</th>
											<th>当前状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
						<div title="审核发帖" data-options="iconCls:'icon-ok'"
							style="overflow:auto;padding:10px;">
							<div id="container"
								style="margin-top:10px;padding:20px;border:1px solid #e1e0e0;">
								<table id="message">
									<thead>
										<tr>
											<th>序号</th>
											<th>标题</th>
											<th>发布人</th>
											<th>发布时间</th>
											<th>查看人数</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
						<div title="用户管理" data-options="iconCls:'icon-search'"
							style="padding:10px;">
							<ul class="easyui-tree">
								<li><span>天选之子</span>
									<ul>
										<li><span>企业</span>
											<ul>
												<c:forEach items="${userMap.comlst }" var="com">
													<li>${com }</li>
												</c:forEach>
											</ul></li>
										<li><span>学生</span>
											<ul>
												<c:forEach items="${userMap.userlst }" var="user">
													<li>${user }</li>
												</c:forEach>
											</ul></li>
									</ul></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	$(function() {
	
	function timestampToTime(timestamp) {
		var date = new Date(timestamp); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
		Y = date.getFullYear() + '-';
		M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		D = date.getDate() + ' ';
		return Y + M + D;
	}



	/*Javascript代码片段*/
	var t = $('#example').DataTable({
		ajax : {
			//指定数据源
			url : "/Admin/returnApprovesList"
		},
		//每页显示10条数据
		pageLength : 10,
		bAutoWidth : false,
		columns : [ {
			"data" : null //此列不绑定数据源，用来显示序号
		},
			{
				"data" : "account"
			},
			{
				"data" : "type"
			},
			{
				"data" : "createTime"
			},
			{
				"data" : "status"
			},
			{
				"data" : null
			} ],
		"fnRowCallback" : function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
			var id = aData.id;
			$(nRow).attr("id", id);
			var oSettings = this.fnSettings();
			if (oSettings.oFeatures.bServerSide) {
				$("td:first", nRow).html(oSettings._iDisplayStart + iDisplayIndex + 1);
			} else {
				$("td:first", nRow).html(iDisplayIndexFull + 1);
			}
			var type = aData.type;
			switch (type) {
			case "1":
				var operate = "<a href='/Student/seeStudent?id=" + id + "'>审核</a>";
				break;
			case "2":
				var operate = "<a href='/Com/seeCompany?id=" + id + "'>审核</a>";
				break;
			}

			$("td:last", nRow).html(operate);
		},
		"columnDefs" : [
			{
				"render" : function(data, type, row, meta) {
					//渲染 
					return timestampToTime(row.createTime);
				},
				//指定是第三列
				"targets" : 3
			},
			{
				"render" : function(data, type, row, meta) {
					//渲染 
					if (row.type == '1') {
						return "学生";
					} else {
						return "企业";
					}
				},
				//指定是第2列
				"targets" : 2
			},
			{
				"render" : function(data, type, row, meta) {
					//渲染 
					if (row.status == '0') {
						return "待审核";
					} else if (row.status == '1') {
						return "正常";
					} else if (row.status == '2') {
						return "已禁用";
					}
				},
				//指定是第2列
				"targets" : 4
			},
		]
	});
		function bindClick() {
			$("#message").find("button").click(function(){
				var id = $(this).attr("data-id");
				$.get("/Message/delMessage", {
				"mid" : id
				}, function(data) {
					if (data) {
						alert("帖子已删除");
						window.location.reload();
					} else {
						alert("帖子未删除")
					}
				})
			});
		}
		var url1 = "/Message/returnAllMessage";
		$('#message').DataTable({
		ajax : {
			//指定数据源
			url : url1
		},
		//每页显示10条数据
		pageLength : 10,
		retrieve: true,
		bAutoWidth : false,
		columns : [ {
			"data" : null //此列不绑定数据源，用来显示序号
		},
			{
				"data" : "title"
			},
			{
				"data" : "creator"
			},
			{
				"data" : "createTime"
			},
			{
				"data" : "seeTime"
			},
			{
				"data" : "status"
			},
			{
				"data" : null
			} ],
		"fnRowCallback" : function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
			var id = aData.id;
			$(nRow).attr("id", id);
			var oSettings = this.fnSettings();
			if (oSettings.oFeatures.bServerSide) {
				$("td:first", nRow).html(oSettings._iDisplayStart + iDisplayIndex + 1);
			} else {
				$("td:first", nRow).html(iDisplayIndexFull + 1);
			}
			var operate = "";
			var status = aData.status;
			if(status == '0') {
			operate += "<a href='/Message/toSeeMessage?mid=" + id + "'>审核</a>";
			operate += "&nbsp;&nbsp;";
			}
		    operate += "<button type='button' class='delMess' data-id=" + id + ">删除</button>"
			$("td:last", nRow).html(operate);
			
		},"fnDrawCallback" : function() {
		    	bindClick();
		},
		"columnDefs" : [ {
			// "visible": false,
			//"targets": 0
		},
			{
				"render" : function(data, type, row, meta) {
					//渲染 
					return timestampToTime(row.createTime);
				},
				//指定是第三列
				"targets" : 3
			},{
				"render" : function(data, type, row, meta) {
					//渲染 
					var str = "";
					switch(row.status) {
						case "0" :
						str = "审核中";
						break;
						case "1" :
						str = "已通过";
						break;
						case "2" :
						str = "已拒绝";
						break;
					}
					return str;
				},
				//指定是第三列
				"targets" : 5
			}
		]
		
	});
		

		$(".repass").click(function() {
			var id = $(this).attr("id-data");
			$.get("/Admin/rebuildPass", {
				"id" : id
			}, function(data) {
				if (data) {
					alert("密码已重置");
					window.location.reload();
				} else {
					alert("密码未重置")
				}
			})
		})
		
		$(".stop").click(function() {
			var id = $(this).attr("id-data");
			$.get("/Admin/stop", {
				"id" : id
			}, function(data) {
				if (data) {
					alert("账号已停用");
					window.location.reload();
				} else {
					alert("账号未停用")
				}
			})
		})
		$(".start").click(function() {
			var id = $(this).attr("id-data");
			$.get("/Admin/start", {
				"id" : id
			}, function(data) {
				if (data) {
					alert("账号已启用");
					window.location.reload();
				} else {
					alert("账号未启用")
				}
			})
		})
		$(".del").click(function() {
			var id = $(this).attr("id-data");
			$.get("/Admin/delUser", {
				"id" : id
			}, function(data) {
				if (data) {
					alert("账号已删除");
					window.location.reload();
				} else {
					alert("账号未删除")
				}
			})
		})
		
	})
</script>