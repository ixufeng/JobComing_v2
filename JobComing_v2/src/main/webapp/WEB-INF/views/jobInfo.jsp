<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>兼职详情</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/site.min.css" rel="stylesheet">
		<link rel="stylesheet" href="css/main.css" />
		<link rel="stylesheet" href="css/jobInfo.css" />
		<script type="text/javascript" src="js/map.js"></script>
		<link rel="shortcut icon" href="img/favicon.png">
	</head>

	<body class="home-template">
		<div class="site-notice">
			<a href=""><em>JobComing~</em></a>
		</div>
		<header class="site-header jumbotron">
			<c:choose>
		  	<c:when test="${empty loginUser}">
				<div class="site-nav"> 
					<a href="user/goLogin">登录</a> <span>/</span>
					<a href="user/goRegister">注册</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="site-nav">
					<a href="user/goUser">${loginUser.userName}</a> <span>/</span>
					<a href="user/goJobPublish">发布兼职</a>
				</div>
			</c:otherwise>
		  </c:choose>
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<form class="" role="search">
							<div class="form-group">
								<input type="text" class="form-control search clearable" placeholder="搜索兼职/单位/地点">
								<i class="glyphicon glyphicon-search"></i>
								<ul class="list-group" id="hide-info">
									</ul>
							</div>
						</form>
					</div>
				</div>
			</div>
		</header>
		<div class="container" style="margin-top: 30px;">
			<div class="row">
				<div class="col-md-9 job-info">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
            					闲着无聊做做兼职--JobComing
            					<a href="jobs" style="float: right;display: inline-block;color:green">首页</a>
        					</h3>
						</div>
						<div class="panel-body">
							<table class="table">
								<tbody>
									<tr>
										<td width="60" class="txt">种类</td>
										<td><a href="">[${job.kindName }]</a></td>
										<td width="60" class="txt">开始</td>
										<td class="txt2">${job.beginTime }</td>
										<td rowspan="4" width="90" class="hidden-xs">
											<c:choose>
												  <c:when test="${ empty job.sendUser.avatar}">
												  	   <img src="<c:url value='/img/public.png'/>" style="width: 80px;height: 90px;" class="img-thumbnail img-responsive">
												  </c:when>
												  <c:otherwise>
												      <img src="${job.sendUser.avatar}" style="width: 80px;height: 90px;" class="img-thumbnail img-responsive">
												   </c:otherwise>
												</c:choose>
										</td>
									</tr>
									<tr>
										<td width="60" class="txt">发布者</td>
										<td class="txt2">${job.sendUser.userName }</td>
										<td width="60" class="txt">结束</td>
										<td class="txt2">${job.endTime}</td>
									</tr>
									<tr>
										<td width="60" class="txt">性别</td>
										<td class="txt2">${job.sendUser.sex}</td>
										<td width="60" class="txt">地区</td>
										<td class="txt2"><a href="">[${job.cityName }]</a></td>
									</tr>
									<tr>
										<td width="60" class="txt">信誉</td>
										<td class="txt2">${job.sendUser.score}%</td>
										<td width="60" class="txt">地址</td>
										<td class="txt2"><a id="show">[查看]</a></td>
									</tr>
								</tbody>
							</table>
							<div class="alert alert-warning">
								<a href="#" class="close">
									&times;
								</a>
								<strong>${job.detailAddr}</strong>
							</div>
							<h5 class="desc">
								<span class="glyphicon glyphicon-file"></span>
								兼&nbsp;职&nbsp;描&nbsp;述
							</h5>
							<p>${job.jobScribe}</p>
							<h5 class="desc">
								<span class="glyphicon glyphicon-phone"></span>
								联&nbsp;系&nbsp;方&nbsp;式
							</h5>
							<p><a id="show2">[查看发布者联系方式]</a></p>
							<div class="alert alert-info">
								<a href="#" class="close close2">
									&times;
								</a>
								<strong>联系电话：${job.sendUser.phone }</strong><br />
								<strong>电子邮件：${job.sendUser.email }</strong>
								
							</div>
						
							<div style="margin-top: 30px;">
								<a href="" class="btn btn-default btn-info">
									<span class="glyphicon glyphicon-envelope"></span>
									邮件预约
								</a>
								
								<a href="" class="btn btn-default btn-success" style="margin-left: 30px;">
									<span class="glyphicon glyphicon-send"></span>
									私聊一下
								</a>
							</div>
						</div>
					</div>
				</div>
			
			
				<div class="col-md-3 adv visible-md visible-lg" style="padding-right: 0px;">
					<div class="panel panel-default">
					    <div class="panel-heading">
					       	<span class="glyphicon glyphicon-fire"></span>&nbsp;今&nbsp;日&nbsp;兼&nbsp;职&nbsp;推&nbsp;送
					    </div>
					     <ul class="list-group">
					        <li class="list-group-item">
					        	<a href="">[苏州]</a>&nbsp;
					        	<a href="">[清洁]</a>&nbsp;
					        	<a href="">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;江苏科技大学
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					         <li class="list-group-item">
					        	<a href="">[苏州]</a>&nbsp;
					        	<a href="">[清洁]</a>&nbsp;
					        	<a href="">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;江苏科技大学
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					         <li class="list-group-item">
					        	<a href="">[苏州]</a>&nbsp;
					        	<a href="">[清洁]</a>&nbsp;
					        	<a href="">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;江苏科技大学
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					         <li class="list-group-item">
					        	<a href="">[苏州]</a>&nbsp;
					        	<a href="">[清洁]</a>&nbsp;
					        	<a href="">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;江苏科技大学
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					        <li class="list-group-item">
					        	<a href="">[苏州]</a>&nbsp;
					        	<a href="">[清洁]</a>&nbsp;
					        	<a href="">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;江苏科技大学
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					        <li class="list-group-item">
					        	<a href="">[苏州]</a>&nbsp;
					        	<a href="">[清洁]</a>&nbsp;
					        	<a href="">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;江苏科技大学
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					        <li class="list-group-item">
					        	<a href="">[苏州]</a>&nbsp;
					        	<a href="">[清洁]</a>&nbsp;
					        	<a href="">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;江苏科技大学
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					        <li class="list-group-item">
					        	<a href="">[苏州]</a>&nbsp;
					        	<a href="">[清洁]</a>&nbsp;
					        	<a href="">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;江苏科技大学
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					    </ul>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-map-marker"></span>&nbsp;导&nbsp;航
						</div>
						<div class="panel-body" id="map" style="min-height:300px;">
							<script type="text/javascript">
								ShowMap("map", {
									city: '${job.cityName }',
									addr: '${job.detailAddr}'
								});
							</script>	
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script>
			$("#show").click(function(){
				$(".alert-warning").css("display","block");
			})
			$(".close").click(function(){
				$(".alert-warning").css("display","none");
			})
			$("#show2").click(function(){
				$(".alert-info").css("display","block");
			})
			$(".close2").click(function(){
				$(".alert-info").css("display","none");
			})
		</script>
	</body>

</html>