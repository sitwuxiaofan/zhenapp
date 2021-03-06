<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<meta name="keywords" content="无线流量,无限流量代运营,无线刷流量 " />
<meta name="description" content="无线流量,无限流量代运营,无线刷流量 " />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/frontend/pagematter/common/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/jquery-1.11.1.min.js"></script>
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/sweetalert.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/sweetalert-dev.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/layer_user.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/user.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/validform.style.css"
	type="text/css">

<style type="text/css">
.login_box {
	width: 930px;
	padding-bottom: 20px;
}

.form_control {
	margin-top: 5px;
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	border-bottom: 1px dashed #dedede;
	padding-bottom: 5px;
}

.form_control_t {
	margin-top: 5px;
}

.form_control .form_label {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	width: 180px;
}

.form_control .form_label_rate {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	width: 100px;
	float: left;
	padding-left: 15px;
}

.form_control .form_input {
	height: 23px;
	line-height: 23px;
	font-size: 12px;
}

.form_control .form_select {
	height: 23px;
	line-height: 23px;
	font-size: 12px;
	list-style: 20px;
}

.form_control .select_big {
	width: 85px;
}

.form_control .select_small {
	width: 55px;
}

.form_control .form_radio {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .form_radio span {
	margin: 0 20px 0 5px;
}

.form_control .input_tip {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .Validform_checktip {
	height: 25px;
	line-height: 25px;
}

.form_control .form_btn {
	width: 150px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
}

.form_control .form_btn_order_good {
	width: 80px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
	background-color: #006633;
	color: #ffffff;
	border: 1px solid #01706e;
	margin-right: 2px;
}

.form_control .form_btn_order_bad {
	width: 80px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
	background-color: #cccc00;
	color: #ffffff;
	border: 1px solid #01706e;
	margin-right: 2px;
}

.form_control .form_btn_order_notfound {
	width: 80px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
	background-color: #990033;
	color: #ffffff;
	border: 1px solid #01706e;
	margin-right: 2px;
}

.form_control a.form_abtn {
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal
}

.form_control_t .form_label {
	float: left;
	display: block;
	width: 140px;
	text-align: right;
	padding-right: 10px;
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .Validform_wrong {
	background-position: 15px -95px;
}

.form_control .Validform_right {
	background-position: 15px -145px;
}

.form_control .Validform_loading {
	background-position: 15px 4px;
}

.taxkTips {
	padding-bottom: 10px;
}

.taxkTips h2 {
	height: 30px;
	line-height: 30px;
	text-indent: 5px;
	border-bottom: 1px solid #dedede;
	font-size: 12px;
	color: #666;
	font-weight: bold;
	background-color: #f0f0f0;
	margin-top: 10px;
}

.task_dist {
	background-color: rgb(239, 239, 239);
	display: inline-table;
	width: 40px;
}

.task_time_title {
	width: 46px;
	text-align: center;
	font-weight: bold;
}

.task_time_count {
	margin: 1px;
}

.input_time {
	width: 40px;
	text-align: center;
}

.scan_icon {
	padding-right: 10px;
}

.toggle_wrapper {
	display: none;
}

.scan_break {
	padding-right: 10px;
}

.input50 {
	text-align: center;
}
</style>
<title>会员中心 - ${tAgentInfoCustom.agentname }</title>
</head>

<body>

	<div id="topbar">
		<div class="warp1200">
			<div class="clearfix">
				<div class="welcome row_l">
					<div class="welcome row_l"></div>
				</div>
				<div class="userlogininfo row_r">
					<div class="islogin" id="islogin">
						<a href="${pageContext.request.contextPath}/user/responseuser"><i class="fa fa-user"></i><span id="username">${tUserInfoCustom.usernick}</span></a>
						<a href="${pageContext.request.contextPath}/user/responseuser"><i class="fa fa-cog"></i>会员中心</a> 
						<a href="${pageContext.request.contextPath}/user/authlogout"><i class="fa fa-sign-out"></i>退出</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="pageFull">
		<div class="webHeader clearfix">
			<div class="logo row_l">
				<a href="${pageContext.request.contextPath}/frontend/index" title="电商流量">${tAgentInfoCustom.agentname }</a>
			</div>
			<div class="channel row_r">
				<ul class="clearfix">
					<li><a href="${pageContext.request.contextPath}/frontend/index" title="电商流量"
						class="scl1">网站首页</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/intro" class="scl2">服务介绍</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/anli" class="scl3">成功案例</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articlenews" class="scl4" title="电商干货">电商干货</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articleguide" class="scl5">新手指引</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/authlogin" class="scl6" title="用户中心">用户中心</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/about" class="scl7">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	    $('.scl6').addClass('hover');
	</script>

	<div class="uc_warp">
		<div class="userbody clearfix">
			<div class="leftmenu row_l">
			</div>
	<script type="text/javascript">
	   $('#addztctask').addClass('hover');
	</script>
			<div class="rightbox row_r">
				<div class="u_outbox">
					<div class="tabtitle clearfix">
						<a href="${pageContext.request.contextPath}/task/responsetaskadd" class="row_l ">淘宝APP流量</a>
						<a href="${pageContext.request.contextPath}/task/responsetaskztcadd" class="row_l hover">淘宝APP直通车流量</a>
						<a href="${pageContext.request.contextPath}/frontend/articleguidedetail/5" target="_blank" class="row_r" style="color:#FF0000">【必看】----直通车发布教程----不看无法发布</a>
					</div>
					<div class="umainbox">
						<!--main-->
						<div id="addTaskDiv">
							<form class="koo_fromBox" >
								<div class="taxkTips">
									<h2>
										<scan class="scan_icon">
										<a><i class="fa fa-info-circle fa-lg"></i></a></scan>
										任务基本信息区
									</h2>
								</div>
								<div class="form_control clearfix">
									<label class="form_label">宝贝url：</label> 
									<input type="text" name="taskurl" placeholder="请输入宝贝url" id="taskurl" style="width:350px;"
									<c:if test="${tTaskInfoCustom.taskurl!=null }">value="${tTaskInfoCustom.taskurl}"</c:if>
									<c:if test="${tTaskInfoCustom.taskurl==null }">value=" "</c:if>
									maxlength="1000" onchange="checkurl(this);" />&nbsp;&nbsp;&nbsp;&nbsp;
									<span id="span_taskurl"></span>
								</div>
								<label class="form_label"></label>
								<table id="tab_keyword" style="padding: 0px;">
										<tr>
											<c:if test="${tTaskInfoCustom!=null}">
												<td style="width:170px;" align="right">
													<label class="form_label">关键词：</label>
												</td>
												<td style="width:10px;">
												</td>
												<td>
													<input type="text" name="taskkeywords" id="taskkeywordcheck" style="width:200px;" value="${tTaskInfoCustom.taskkeyword}" placeholder="请输入关键词" onchange="checkword(this);" />		
												</td>
												<td style="width:5px;">
												</td>
												<td>
													<input type="button" class="easyui-linkbutton" iconCls="icon-add" onclick="addinput();" value="&nbsp;&nbsp;添 &nbsp;加 &nbsp;&nbsp;" />
												</td>
												<td style="width:10px;">
												</td>
												<td>
												</td>
											</c:if>
											<c:if test="${tTaskInfoCustom==null}">
												<td style="width:170px;" align="right">
													<label class="form_label">关键词：</label>
												</td>
												<td style="width:10px;">
												</td>
												<td>
													<input type="text" name="taskkeywords"  style="width:200px;" onchange="checkword(this);" />		
												</td>
												<td style="width:5px;">
												</td>
												<td>
													<input type="button" class="easyui-linkbutton" iconCls="icon-add" onclick="addinput();" value="&nbsp;&nbsp;添 &nbsp;加 &nbsp;&nbsp;" />
												</td>
												<td style="width:10px;">
												</td>
												<td>
												</td>
											</c:if>
										</tr>
								</table>
								<div class="form_control clearfix" style="height:0px;">
								</div>
								<div class="form_control clearfix">
									<label class="form_label">模式：</label> 
									
									<label class="form_radio">
										<input type="radio" name="Mode" v-model="tmChecked" checked="checked" value="0" onchange="checkmode(this);"/>
										<span>新模式(推荐)</span>
									</label> 
									<label class="form_radio">
										<input type="radio" name="Mode" v-model="myfChecked" value="1" onchange="checkmode(this);"/>
										<span>老模式</span>
									</label>
									<label class="form_radio">
										<input type="radio" name="Mode" v-model="myfChecked" value="2" onchange="checkmode(this);"/>
										<span>钻展模式</span>
									</label>
								</div>
								<div class="form_control clearfix" id="div_taskimgztc" style="display: none;">
									<label class="form_label">直通车图片：</label> 
									<input type="text" name="taskimgztc" placeholder="请输入直通车图片" id="taskimgztc" style="width:350px;"
									<c:if test="${tTaskInfoCustom.taskimgztc!=null }">value="${tTaskInfoCustom.taskimgztc}"</c:if>
									<c:if test="${tTaskInfoCustom.taskimgztc==null }">value=" "</c:if>
									maxlength="1000" />&nbsp;&nbsp;&nbsp;&nbsp;
									<span id="span_taskimgztc"></span>
								</div>
								
								<div class="form_control clearfix" id="div_creativetitle" style="display: block;">
									<label class="form_label">创意标题：</label> 
									<input type="text" name="creativetitle" placeholder="请输入创意标题" id="creativetitle" style="width:350px;" onchange="checktitle();"
									<c:if test="${tTaskInfoCustom.creativetitle!=null }">value="${tTaskInfoCustom.creativetitle}"</c:if>
									<c:if test="${tTaskInfoCustom.creativetitle==null }">value=" "</c:if>
									maxlength="100" />&nbsp;&nbsp;&nbsp;&nbsp;
									<span id="span_creativetitle"></span><font color="red">*必须正确填写创意标题</font>
								</div>
								<div class="form_control clearfix" id="div_drillimg" style="display: none;">
									<label class="form_label">钻展图片地址：</label> 
									<input type="text" name="drillimg" placeholder="请输入钻展图片地址" id="drillimg" style="width:350px;" 
									<c:if test="${tTaskInfoCustom.drillimg!=null }">value="${tTaskInfoCustom.drillimg}"</c:if>
									<c:if test="${tTaskInfoCustom.drillimg==null }">value=" "</c:if>
									maxlength="100" />&nbsp;&nbsp;&nbsp;&nbsp;
									<span id="span_creativetitle"></span><font color="red">*必须正确填写钻展图片地址</font>
								</div>
								<div class="form_control clearfix">
									<label class="form_label">宝贝价格：</label> 
									<input type="text" name="taskprice" placeholder="请输入宝贝价格" id="taskprice" style="width:150px;" onchange="setprice();"
									<c:if test="${tTaskInfoCustom.taskprice!=null }">value="${tTaskInfoCustom.taskprice}"</c:if>
									<c:if test="${tTaskInfoCustom.taskprice==null }">value="0"</c:if>
									maxlength="10"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<span id="span_taskprice"></span>
								</div>
								
									<div class="taxkTips">
										<h2>
											<scan class="scan_icon">
											<a><i class="fa fa-chevron-circle-right fa-lg"></i></a></scan>
											卡位可选信息区（价格区间太大或太小均可导致找宝贝失败，如果实际排名不在200内（车位前5-7）甚至更低，必须卡价格）
										</h2>
									</div>
										<div class="form_control clearfix">
											<label class="form_label">排序类型：</label> 
											<select name="tasksearchType" id="tasksearchType" class="form_select select_big" v-model="sortType">
												<option selected="selected" value="35">综合排序</option>
												<option value="39">销量优先</option>
												<option value="37">价格从低到高</option>
												<option value="38">价格从高到低</option>
												<option value="36">信用排序</option>
											</select>
										</div>
										<div class="form_control clearfix">
											<label class="form_label">卡价格模式：</label> 
											<label class="form_radio">
												<input type="radio" name="priceMode" 
												 v-model="myfChecked" value="0"  onchange="checkpricemode(this);"/>
												<span>默认综合不卡价格（必须排名很前）</span></label> 
											
											<label class="form_radio">
												<input type="radio" name="priceMode"
												v-model="tmChecked" value="3" onchange="checkpricemode(this);"/>
												<span>自定义（如检测不在排名内，请尝试缩小或扩大价格区间再次检测）</span>
											</label> 
										</div>
										<div class="form_control clearfix">
											<label class="form_label"></label> 
											<label class="form_radio">
												<input type="radio" name="priceMode"  checked="checked"
												 v-model="myfChecked" value="1"  onchange="checkpricemode(this);"/>
												<span>自动卡价格（推荐）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;
												</span>
											</label>
										</div>
										<div class="form_control clearfix" id="div_price">
											<label class="form_label">自定义价格区间:</label>
											<input class="form_input input50" type="text" name="taskminprice" id="taskminprice" v-model="start_price" value=0 onchange="setprice(this);"/> 
											<span class="Validform_checktip scan_break">--</span> 
											<input class="form_input input50" type="text" name="taskmaxprice" id="taskmaxprice" v-model="end_price" value=0 onchange="setprice(this);"/>
											最小价格填写为宝贝的原价或者比原价少1-10元最容易校验成功
										</div>
										<div class="form_control clearfix" id="div_price">
											<label class="form_label" style="margin-left: 200px;">
												<a href="#" class="btn btn-success btn-xs" id="a_check"> 校验直通车实际排名  </a>
											</label>
											<font color="red">安徽芜湖地区不能屏蔽才能校验</font>
											<!--  <div id="div_image" style="margin-left: 300px;display: none;">
												<div class="small_pic">
													<a href="#pic_one">
														<img id="img_ztc" height="60px" width="60px;" src="http://g.search1.alicdn.com/img/i1/139560256167526225/TB2iNn6tXXXXXakXpXXXXXXXXXX_!!0-saturn_solar.jpg_60x60.jpg" />
													</a>
												</div>
												<div id="pic_one" style="display:none;">
													<img id="img_ztc2" src="http://g.search1.alicdn.com/img/i1/139560256167526225/TB2iNn6tXXXXXakXpXXXXXXXXXX_!!0-saturn_solar.jpg_350x350.jpg" />
												</div>
											</div>-->
										</div>
										<div id="div_image" style="margin-left: 10px;display: none;">
											<div class="small_pic">
												<a href="#pic_one">
													<img id="img_ztc" height="60px" width="60px;" src="http://g.search1.alicdn.com/img/i1/139560256167526225/TB2iNn6tXXXXXakXpXXXXXXXXXX_!!0-saturn_solar.jpg_60x60.jpg" />
												</a>
											</div>
											<div id="pic_one" style="display:none;">
												<img id="img_ztc2" src="http://g.search1.alicdn.com/img/i1/139560256167526225/TB2iNn6tXXXXXakXpXXXXXXXXXX_!!0-saturn_solar.jpg_350x350.jpg" />
											</div>
										</div>
										<div id="div_bur" style="margin-left:205px;margin-top:10px;display: none;">
											<img src="${pageContext.request.contextPath}/backstage/pagematter/common/img/bur.gif"></img>
										</div>
										<div id="div_dialog" title="校验发布宝贝信息" style="margin-left:25px;margin-top:10px;width:300px;height:150px;">
												<p>直通车实际排名不在200内</p>
												<p>1，直通车出价尽量控制到排名5到10名内</p>
												<p>2，请尝试把价格区间扩大或者缩小再次检查</p>
												<p>3，如刚操作过直通车后台，15分钟后方能搜到结果</p>
												<p>4，如果检测不到不要紧，请尝试强制发布</p>
												<a href="#" id="a_return" class="btn btn-info btn-xs" > 返回修改</a>
												<a href="#" id="a_compel" class="btn btn-danger btn-xs" > 强制发布</a>
											</div>
										
								<div class="taxkTips">
									<h2>
										<scan class="scan_icon">
										<a><i class="fa fa-rmb fa-lg"></i></a></scan>
										本次刷流量共需费用
									</h2>
								</div>
								<table class="table" style="margin-bottom:0px;">
									<tr class="active">
										<td>【流量数：<span id="lls_1">0</span>个，流量单个花费:<span id="lls_2" style="color:red;">${tPriceInfoCustom.pricecounts4}</span>(积分)/个，总计：<span id="lls_3">0</span>(积分)】</td>
									</tr>
									<tr class="default">
										<td>【收藏数：<span id="scs_1">0</span>个，收藏单个花费:<span id="scs_2" style="color:red;">${tPriceInfoCustom.pricecounts5}</span>(积分)/个，总计：<span id="scs_3">0</span>(积分)】</td>
									</tr>
									<tr class="active">
										<td>【购物车数：<span id="gwcs_1">0</span>个，加购物车单个花费:<span id="gwcs_2" style="color:red;">${tPriceInfoCustom.pricecounts6}</span>/个，总计：<span id="gwcs_3">0</span>(积分)】</td>
									</tr>
									<tr class="success">
										<td>【总费用:<span id="sum" style="color:red;">0</span>(积分)】</td>
									</tr>
								</table>
								<div class="form_control clearfix">
									<label class="form_label">发布时间：</label> 
									<lable style="padding:0px;"></lable>
									<input type="text" name="datefrom" id="datefrom" width="200px"/>--<input type="text" name="dateto" id="dateto" width="200px"/>
								</div>
								<div class="form_control clearfix">
									<label class="form_label">任务数量：</label> 
									<input type="text" name="flowcount" id="flowcount" <c:if test="${tTaskInfoCustom.flowcount!=null }">value="${tTaskInfoCustom.flowcount}"</c:if>
									<c:if test="${tTaskInfoCustom.flowcount==null }">value="1"</c:if>
										placeholder="请输入需要的流量数" onblur="fpll(this)"
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')" />&nbsp;&nbsp;&nbsp;&nbsp;
										<span id="span_flowcount_text"></span><span id="span_flowcount"></span>
								</div>
								
								<div class="form_control form_control_dist clearfix">
									<label class="form_label">任务分布：</label>
									<div class="hourCounts clearfix">
										<div class="task_dist">
											<div class="task_time_title">0时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_0"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">1时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_1"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">2时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_2"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">3时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_3"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">4时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_4"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">5时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_5"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">6时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_6"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">7时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_7"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">8时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_8"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">9时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_9"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">10时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_10"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">11时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_11"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
									</div>
								</div>
								<div class="form_control form_control_dist clearfix">
									<label class="form_label"></label>
									<div class="hourCounts clearfix">
										<div class="task_dist">
											<div class="task_time_title">12时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_12"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">13时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_13"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">14时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_14"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">15时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_15"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">16时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_16"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">17时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_17"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">18时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_18"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">19时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_19"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">20时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_20"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">21时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_21"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">22时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_22"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">23时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_23"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
									</div>
								</div>
								
								<div class="form_control clearfix">
									<label class="form_label">收藏数量：</label> 
									<input name="collectioncount" id="collectioncount" onchange="fpsc(this);"
										placeholder="请输入收藏数"
										<c:if test="${tTaskInfoCustom.collectioncount!=null }">value="${tTaskInfoCustom.collectioncount}"</c:if>
										<c:if test="${tTaskInfoCustom.collectioncount==null }">value="0"</c:if>
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')"/>&nbsp;&nbsp;
										<span id="span_collection_text" style="color:red;">* 必须与流量数保持一致</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="span_collection"></span>
								</div>
								<div class="form_control clearfix">
									<label class="form_label">加购物车数量：</label> 
									<input type="text" name="shoppingcount" id="shoppingcount" onchange="fpgwc(this);"
										placeholder="请输入购物车数"
										<c:if test="${tTaskInfoCustom.shoppingcount!=null }">value="${tTaskInfoCustom.shoppingcount}"</c:if>
										<c:if test="${tTaskInfoCustom.shoppingcount==null }">value="0"</c:if>
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')"
										/>&nbsp;&nbsp;
										<span id="span_shopping_text" style="color:red;">* 必须与流量数保持一致</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="span_shopping"></span>
								</div>
								<div id="buttonSubmit" class="form_control clearfix"
									style="margin-top:20px; border-bottom:none;">
									
									<div class="botton" style="margin-left:40px;">
										<input type="button" class="btn btn-info" id="subbtn" value="发布任务" />
									</div>
								</div>
								<div id="searchOrderWrapper" class="form_control clearfix"
									style="margin-top:20px; border-bottom:none;">
									<div id="searchOrderInnerWrapper" class="botton"></div>
								</div>
							</form>
						</div>
						<!--main-->
					</div>
				</div>
			</div>
			<script type="text/javascript">
        $(function () {
        	$("div.small_pic a").fancyZoom({scaleImg: true, closeOnClick: true});
        	$(".leftmenu").load("${pageContext.request.contextPath}/backstage/user/menu.jsp");
        	
        });
        /*$(document).ready(function(){
            $(".box_toggle").on('click', (function(){
                $(this).next(".toggle_wrapper").animate({height: 'toggle', opacity: 'toggle'}, "slow");
            },function(){
                $(this).next(".toggle_wrapper").animate({height: 'toggle', opacity: 'toggle'}, "slow");
            }));
        });*/
        var uri = "${pageContext.request.contextPath}";
    </script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/backstage/pagematter/common/js/taskztcadd.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/content_zoom.js"></script>
		</div>
	</div>
	<div class="copyRight">
		<div class="warp1200 footer">
			<p>
				Copyright (c) 2015  Inc. All Rights. 浙ICP备140452118号-5.
			</p>
		</div>
	</div>
</body>
</html>