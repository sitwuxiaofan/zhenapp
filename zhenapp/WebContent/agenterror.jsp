<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<meta name="keywords" content="淘口令,刷淘宝流量,淘宝刷流量软件,淘宝流量,淘宝刷流量" />
<meta name="description" content="旺点击是一个快速提升淘宝手机流量、淘口令流量、淘宝无线流量、淘宝APP流量的平台,真流量优势:  百分百模拟刷淘宝手机流量、淘口令、淘宝刷流量软件、刷淘宝流量软件。" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/index.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery.SuperSlide.2.1.1.js"></script>
<title>联系我们</title>
<style type="text/css">
/*html5*/
article,aside,dialog,footer,header,section,footer,nav,figure,menu{display:block}

.webHeader .logo a {
	display: block;
	width: 280px;
	height: 80px;
	background: url("${pageContext.request.contextPath}/webimg/${tWebInfoCustom.logo}") no-repeat;
	text-indent: -99999px;
}
*{margin:0px;padding:0px;outline:none;list-style-type:none;border:none;}
.QQbox{z-index:1000;width:410px;left:-276px;top:0;margin:149px 0 0 0;position:fixed;}
*html,*html body{background-image:url(about:blank);background-attachment:fixed;}
*html .QQbox{position:absolute;top:expression(eval(document.documentElement.scrollTop));}
.QQbox .press{left:0;border:none;cursor:pointer;width:32px;height:96px;position:absolute;padding-top:140px;}
.QQbox .Qlist{float:left;width:410px;background:url(${pageContext.request.contextPath}/webimg/${tWebInfoCustom.bg01}) no-repeat;background-position:1px 0px;height:436px;display:block;overflow:hidden;zoom:1;}
.QQbox .Qlist .infobox{text-align:center;background-repeat:no-repeat;padding:5px;line-height:14px;color:#CCCCCC;font-weight:700;}
.QQbox .Qlist .con{margin-top:266px;margin-left:50px;color:#32567e;font-size:14px;}
.QQbox .Qlist .con ul li{height:31px;list-style:none;margin-left:35px;}
.QQbox .Qlist .con ul li a{font-size:13px;margin-left:18px;text-decoration:none;}
.OnlineLeft{float:left;display:inline;width:262px;height:439px;overflow:hidden;zoom:1;}
.OnlineBtn{float:right;display:inline;width:127px;height:36px;background:url(${pageContext.request.contextPath}/webimg/${tWebInfoCustom.bg02}) no-repeat;margin-top:-45px;margin-left:220px;}
</style>
</head>
<body>
	<div class="topbar">
		<div class="warp1200 toplogin clearfix">
			<div class="userlogin row_r" id="userLogin">
				<c:if test="${tUserInfoCustom == null}">
					您好，欢迎来到${tAgentInfoCustom.agentname }！<a href="${pageContext.request.contextPath}/frontend/authlogin">马上登录</a>|<a href="${pageContext.request.contextPath}/frontend/authregister">快速注册</a>
				</c:if>
				<c:if test="${tUserInfoCustom != null}">
					<div class="userlogin row_r" id="userLogin">您好 <span>${tUserInfoCustom.usernick }</span> 欢迎您回来！<a href="${pageContext.request.contextPath}/user/responsepersonal">进入会员中心</a>|<a href="${pageContext.request.contextPath}/user/authlogout">退出登录</a></div>
				</c:if>
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
        $('.scl7').addClass('hover');
    </script>
		<div class="rightBox row_r">
			<div class="chennalBox mtop15">
				<h3>联系我们</h3>

				<div class="mainBox">
					<div class="newsContent">
						<div class="content">
							<p>
								流量客服：QQ${tWebInfoCustom.qq} 
								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${tWebInfoCustom.qq}&site=qq&menu=yes">
								<img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
							</p>
							<p>
								技术咨询：QQ${tWebInfoCustom.qq} <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${tWebInfoCustom.qq}&site=qq&menu=yes">
								<img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
							</p>
							<p>
								流量托管：QQ${tWebInfoCustom.qq} 
								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${tWebInfoCustom.qq}&site=qq&menu=yes">
								<img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
							</p>
							<br />
							<p>承接托管业务：淘宝端APP无线流量、聚划算开团提醒、加购、收藏、领券；</p>
							<p>请咨询坐席客服，我们将竭诚为您服务!</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer.min.js"></script>
<div id="divQQbox" class="QQbox">
	<div id="divOnline" class="Qlist">
		<div class="OnlineLeft">
			<div class="con">
				<ul>
					<li>技术咨询<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
					<li>流量托管<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
				</ul>
			</div>
		</div>
		<div class="OnlineBtn">
		</div>
	</div>
</div>
<div class="copyRight">
	<div class="warp1200 footer">
		<p>
			Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="${tAgentInfoCustom.agentname }">${tAgentInfoCustom.agentname }</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
		</p>
	</div>
</div>
<script type="text/javascript">
     $(function() {
     	$("#divQQbox").hover(
   			function(){
   				$(this).stop(true,false);
   				$(this).animate({left:0},300);	
   			},
   			function(){
   				$(this).animate({left:-276},149);	
   			}
   		);
     });
</script>
</body>
</html>