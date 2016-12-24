<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<title>兼职详情</title>
		<jsp:include page="/WEB-INF/components/styles.jsp"></jsp:include>		
		<link rel="stylesheet" href="css/jobInfo.css" />
		<script type="text/javascript" src="<c:url value='/js/map.js'/>"></script>
		
		<link href="<c:url value='/css/chat.css'/>" rel="stylesheet">	
		<link href="<c:url value='/css/styles.css'/>" rel="stylesheet">	
		<link href="<c:url value='/css/default.css'/>" rel="stylesheet">	
	</head>
	
	<body class="home-template">

		<jsp:include page="/WEB-INF/components/head.jsp"></jsp:include>
		<div class="container" style="margin-top: 30px;">
			<div class="row">
				<div class="col-md-9 job-info">
					<div class="panel panel-default" id="jobPublisher" data-username="${job.sendUser.userName }" data-email="${job.sendUser.email }" data-userId="${job.sendUser.userId }">
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
												  	   <img id="user-avatar" src="<c:url value='/img/public.png'/>" style="width: 80px;height: 90px;" class="img-thumbnail img-responsive">
												  </c:when>
												  <c:otherwise>
												      <img src="${job.sendUser.avatar}" id="user-avatar" style="width: 80px;height: 90px;" class="img-thumbnail img-responsive">
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
								<a data-pre="0" data-job="${job.jobId}" data-url="" class="btn btn-default btn-info send-email">
									<span class="glyphicon glyphicon-envelope"></span>
									邮件预约
								</a>
								
								<a id="private-chat" class="btn btn-default btn-success" style="margin-left: 30px;">
									<span class="glyphicon glyphicon-send"></span>
									私聊一下
								</a>
							</div>
						</div>
					</div>
				</div>
			
			
				<div class="col-md-3 adv visible-md visible-lg" style="padding-right: 0px;">
					<!-- 今日热推 -->
					<jsp:include page="/WEB-INF/components/todayjobs.jsp"></jsp:include>
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-map-marker"></span>&nbsp;导&nbsp;航
						</div>
						<div class="panel-body" id="map" style="min-height:240px;">
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
		<!-- 弹幕发送 -->
		<jsp:include page="/WEB-INF/components/bullet.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/components/chatCon.jsp"></jsp:include>
		<script type="text/javascript" src="<c:url value='/js/chat.js'/>"></script>
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