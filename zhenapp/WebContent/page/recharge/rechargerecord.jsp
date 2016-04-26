<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>充值记录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>  
  <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/page/css/index.css" />
<style>
	.textbox{
		height:20xp;
		margin:0;
		padding:0 2px;
		box-sizing:content-box;
	}
</style>
  <body>
	
	<table id="datagrid">
	</table>
	
	<div id="datagridtools">
		<div style="padding:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="obj.remove();">删除</a>
		</div>
		<div style="padding:5px;">
			<lable style="padding:0 10px 0 10px;">创建时间从:</lable><input type="text" name="datefrom" class="easyui-datebox"  width="110px"  />
			到：<input type="text" name="dateto" class="easyui-datebox"  width="110px"  />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="obj.search();">查询</a>
		</div>
	</div>
  </body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/user.js"></script>
<script type="text/javascript">
	var uri = "${pageContext.request.contextPath}";
	
	;$(function(){
		obj={
			search:function(){
				$("#datagrid").datagrid('load',{
					datefrom:$("input[name='datefrom']").val(),
					dateto:$("input[name='dateto']").val(),
				});
			},
			remove:function(){
				var rows=$("#datagrid").datagrid('getSelections');
				if(rows.length>0){
					$.messager.confirm('确认','您确认想要删除记录吗？',function(b){    
					    if (b){
							var rechargeids=[];
							for(var i=0;i<rows.length;i++){
								rechargeids.push(rows[i].rechargeid);
							}
							$.ajax({
								type:"POST",
								url:"${pageContext.request.contextPath}/recharge/deleteRechargeinfoByid",
								data:{
									rechargeids:rechargeids.join(",")
								},
								beforeSend:function(){
									$("#datagrid").datagrid('loading');
								},
								success:function(){
									$("#datagrid").datagrid('loaded');	
									$.messager.show({
										title:"提示消息",
										msg:"删除成功",
										width:300,
										height:200,
									});
									$("#datagrid").datagrid('load');
								},
							});
					    }
					});
				}else{
					$.messager.alert('提示信息',"请选择要删除的信息",'info');
				}
			},
		};	
		
		
			$("#datagrid").datagrid({
				fit:true,
				title : '任务订单管理',
				url:"${pageContext.request.contextPath}/recharge/findRechargeinfoByUserAndpage",
				columns : [ [ 
				    {
						field : 'rechargepk',
						title : '选择',
						checkbox:true,
						
						
					}, 
					{
						field : 'rechargeid',
						title : '充值订单号',
						width : 300,
					}, 
					{
						field : 'rechargeverification',
						title : '充值校验码',
					},
					{
						field : 'rechargemoney',
						title : '充值金额',
					},
					{
						field : 'rechargestate',
						title : '充值状态',
					},
					{
						field : 'createtime',
						title : '发布时间'
					}
					] ],
				pagination:true,
				pageList:[1,5,10,15,20,25],
				striped:true,
				nowrap:true,
				fitColumns:true,
				rownumbers:true,
				toolbar:'#datagridtools'
			});
	});
	
</script>
</html>
