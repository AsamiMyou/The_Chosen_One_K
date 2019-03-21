<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>个人信息查看</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="/js/themes/default/default.css" />
<link rel="stylesheet" href="/js/plugins/code/prettify.css" />
<script charset="utf-8" src="/js/kindeditor.js"></script>
<script charset="utf-8" src="/js/lang/zh-CN.js"></script>
<script charset="utf-8" src="/js/plugins/code/prettify.js"></script>
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
									<c:if test="${messageType == '1' }">
									<p>${userBean.sname }</p>
									<p>${userBean.majoy }</p>
									</c:if>
									<c:if test="${messageType == '2' }">
									<p>${userBean.cname }</p>
									<p>${userBean.mainBussiness }</p>
									</c:if>
								</div>
						</div>
					</div>
					<div>他的发帖：</div>
					<div>&nbsp;</div>
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
		var uid = '<%=request.getAttribute("userId")%>' ;
		var url1 = "/Message/returnUserMessage?uid=" + uid;
		$.get(url1,function(data) {
			console.log(data);
		})
		$('#message').DataTable({
		ajax : {
			//指定数据源
			url : url1
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
		
		
	})
	
</script>