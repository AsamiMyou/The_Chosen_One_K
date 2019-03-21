<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>企业模块</title>
<link rel="stylesheet" href="/js/themes/default/default.css" />
<link rel="stylesheet" href="/js/plugins/code/prettify.css" />
<script charset="utf-8" src="/js/kindeditor.js"></script>
<script charset="utf-8" src="/js/lang/zh-CN.js"></script>
<script charset="utf-8" src="/js/plugins/code/prettify.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<style>
.searchTable {
	width:1500px;
	border: 2px solid #e4e2ed;
	margin: 3 auto;
	height: 80px;
	}
.searchTable td{
	width:40%;	
	}
.searchTable input{
	width:250px;
	height:25px;
}
.searchBtn {
	float:right;
	height: 30px;
    width: 200px;
    border-bottom-color: rebeccapurple;
}
</style>
<body>
	<div class="wrap">
		<div class="total">
			<%@include file="/mainJsp/head.jsp"%>
			<div class="single">
				<div class="mian">
					<div class="author clear">
						<table class="searchTable">
						<tr><td>企业名称：</td><td><input type="text" id="cname"></td><td>企业地址：</td><td><input type="text" id="caddress"></td></tr>
						<tr><td>主营业务：</td><td><input type="text" id="mainBussiness"></td><td colspan="2"></td></tr>
						<tr><td colspan="2"></td><td colspan="2"><button type="button" class="searchBtn" id="searchBn">查询</button></td></tr>
						</table>
					</div>
					<div>企业查询：&nbsp;&nbsp;<span id="keyWord">关键字：</span></div>
					<HR>
					<div id="container"
						style="margin-top:10px;padding:20px;border:1px solid #e1e0e0;">
						<table id="stuinfo" class="tripe" style="text-align:center">
							<thead>
								<tr>
									<th>序号</th>
									<th>企业名称</th>
									<th>企业地址</th>
									<th>营业执照到期时间</th>
									<th>主营业务</th>
									<th>创建时间</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
					<div>&nbsp;&nbsp;</div>
					<div style="height: 32px;">企业论坛：<span style="float:right"><c:if test="${sessionScope.userType == 'com'}"><a href="/Message/toMessage"class="button-contact">发表帖子</a></c:if></span></div>
					<HR>
					<div id="container"
						style="margin-top:10px;padding:20px;border:1px solid #e1e0e0;">
						<table id="message" class="tripe" style="text-align:center">
							<thead>
								<tr>
									<th>序号</th>
									<th>标题</th>
									<th>发布人</th>
									<th>发布时间</th>
									<th>查看人数</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
					</div>
				</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">

$(function() {
	function timestampToTime(timeStamp) {
	   var date = new Date();  
	   date.setTime(timeStamp);  
	   var y = date.getFullYear();      
	   var m = date.getMonth() + 1;      
	   m = m < 10 ? ('0' + m) : m;      
	   var d = date.getDate();      
	   d = d < 10 ? ('0' + d) : d;      
	   return y + '-' + m + '-' + d ;
	}


	var a = '<%=request.getAttribute("Search")%>' ;
	var url1 = "/User/searchCom";
	if(a != 'null' && a != null && a.length > 0) {
		$("#keyWord").html("关键字：" + a);
		url1 = "/User/searchCKey?key=" + a;
	}
	var stable = $('#stuinfo').DataTable({
		ajax : {
			//指定数据源
			url : url1
		},
		//每页显示10条数据
		pageLength : 10,
		columns : [ {
				"data" : null //此列不绑定数据源，用来显示序号
			},
			{
				"data" : "cname"
			},
			{
				"data" : "address"
			},
			{
				"data" : "comDate"
			},
			{
				"data" : "mainBussiness"
			},
			{
				"data" : "createTime"
			} ],
		"fnRowCallback" : function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
			var userId = aData.userId;
			$(nRow).attr("userId", userId);
			var oSettings = this.fnSettings();
			if (oSettings.oFeatures.bServerSide) {
				$("td:first", nRow).html(oSettings._iDisplayStart + iDisplayIndex + 1);
			} else {
				$("td:first", nRow).html(iDisplayIndexFull + 1);
			}
		},
		"columnDefs" : [ {
			// "visible": false,
			//"targets": 0
		},{
				"render" : function(data, type, row, meta) {
					//渲染 
					return timestampToTime(row.comDate);
				},
				//指定是第三列
				"targets" : 3
			},{
				"render" : function(data, type, row, meta) {
					//渲染 
					return timestampToTime(row.createTime);
				},
				//指定是第三列
				"targets" : 5
			},{
				"render" : function(data, type, row, meta) {
					//渲染 
					return "<a href='/User/seeUserInfo?uid="+row.userId+"'>"+row.cname +"</a>";
				},
				//指定是第三列
				"targets" : 1
			}
		]
	});

		
	$('#message').DataTable({
		ajax : {
			//指定数据源
			url : "/Message/returnComMessage"
		},
		//每页显示10条数据
		pageLength : 10,
		retrieve: true,
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
			}
			,
			{
				"render" : function(data, type, row, meta) {
					//渲染 
					return "<a href='/Message/toSeeMessage?mid="+row.id+"'>"+row.title +"</a>";
				},
				//指定是第三列
				"targets" : 1 
			}
		]
	});

		
	$("#searchBn").click(function() {
		var cname = $("#cname").val();
		var caddress = $("#caddress").val();
		var mainBussiness = $("#mainBussiness").val();
		var para = "?cname="+cname+"&caddress="+caddress+"&mainBussiness=" + mainBussiness;
	    var url1 = "/User/searchCom" + para;
		stable.ajax.url(url1).load();
		$("#keyWord").html("关键字：");
	})	
})
	
</script>
