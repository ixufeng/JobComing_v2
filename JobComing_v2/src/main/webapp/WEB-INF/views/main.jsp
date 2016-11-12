<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Expires" content="0">
	    <meta http-equiv="kiben" content="no-cache">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>主界面</title>
		<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/site.min.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/message.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/barrager.css'/>" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value='/css/main.css'/>" />
		<link rel="shortcut icon" href="<c:url value='/img/favicon.png'/>">
		<script type="text/javascript" src="http://cdn.goeasy.io/goeasy.js"></script>
	</head>

	<body class="home-template">
		<div class="site-notice">
			<a href=""><em>JobComing~</em></a>
			<a class="pull-right" id="bullet-button" style="margin-right:30px;">弹幕</a>
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
							</div>
						</form>
					</div>
				</div>
			</div>
		</header>

		<div class="container mycontainer">
			<div class="row">
				<div class="col-md-9">
					<div class="mostused-packages well hidden-xs hidden-sm">
						<div>
							<div id="city-name">
								<span>兼职地点：</span>
								<a class="city active" href="jobs?cityName=-1" data-name="全国">全国</a>
								<a class="active city" href="jobs?cityName=南京" data-name="南京">南京</a>
								<a href="">杭州</a>
								<a href="">上海</a>
								<a href="">北京</a>
								<a href="">深圳</a>
								<a href="">广州</a>
								<a href="">成都</a>
								<a href="">苏州</a>
								<a href="">长沙</a>
								<a href="user/goMore" style="float: right;">更多<i class="caret"></i></a>
							</div>
							<div class="sep5" style="height: 20px;"></div>
							<div id="job-kind-name">
								<span>兼职形式：</span>
								<a href="jobs?jobKindName=-1" data-name="所有" class="active job-kind-name">所有</a>
								<c:forEach items="${jobKinds}" var="jobKind">
									<a class="active job-kind-name" data-name="${jobKind.jobKindName }" href="jobs?jobKindName=${jobKind.jobKindName }">${jobKind.jobKindName }</a>
								</c:forEach>
							</div>
							<div class="sep5" style="height: 20px;"></div>
							<div id="week-time">							
								<span>开始时间：</span>
								<a href="jobs?weekTime=-1"  data-name="不限"class="active week-time" >不限</a>
								<a href="jobs?weekTime=周一" data-name="周一" class="active week-time">周一</a>
								<a href="jobs?weekTime=周二" data-name="周二" class="active week-time">周二</a>
								<a href="jobs?weekTime=周三" data-name="周三" class="active week-time">周三</a>
								<a href="jobs?weekTime=周四" data-name="周四" class="active week-time">周四</a>
								<a href="jobs?weekTime=周五" data-name="周五" class="active week-time">周五</a>
								<a href="jobs?weekTime=周六" data-name="周六" class="active week-time">周六</a>
								<a href="jobs?weekTime=周日" data-name="周日" class="active week-time">周日</a>
							</div>
						</div>
					</div>
					
					<div class="mostused-packages well hidden-xs hidden-sm" style="padding: 0px;height: 46px;">
						<div class="page-sel">
							<span>排序方式：</span>
							<a class="ser-kind">默认</a>
							<a href="" class="active">最新</a>
						</div>
						<div class="page-sel2">
							<a href="" class="prev"></a>
							<span style="color: #00b38a;">1</span> <span>/ 12</span>
							<a href="" class="next"></a>
						</div>
					</div>
					
					<main class="packages-list-container" id="all-packages">
						<ul class="list-group">
						<c:forEach items="${jobs}" var="job">							
							
							<li class="list-group-item">
								<table style="border: 0px;width: 100%;">
									<tbody>
										<tr>
											<td width="55" valign="top" align="center">
												<c:choose>
												  <c:when test="${ empty job.sendUser.avatar}">
												  	   <img src="<c:url value='/img/public.png'/>" style="width: 55px; height: 55px;" class="img-responsive img-rounded" border="0">
												  </c:when>
												  <c:otherwise>
												      <img src="${job.sendUser.avatar}" style="width: 55px; height: 55px;" class="img-responsive img-rounded" border="0">
												   </c:otherwise>
												</c:choose>
											</td>
											<td width="10"></td>
											<td width="auto" valign="middle">
												<span class="item_title"> 
													<a href="" style="color: #00b38a;">[${job.kindName}]</a>
													<a href="jobInfo?jobId=${job.jobId }" style="color: #4d5256;">${job.jobScribe}</a>
												</span>
												<div class="sep5" style="height: 1px;"></div>

												<span style="font-size: 11px; color: #ccc;">		
													<a href="#">
														发布人
													</a> &nbsp;•&nbsp; 
													<strong>
														<a href="#" style="color: #4d5256;">
															${job.sendUser.userName}
														</a>
													</strong> &nbsp;•&nbsp; 
															
													<small>2天前</small>
												</span>
												<div class="sep5" style="height: 1px;"></div>
												<span style="font-size: 11px; color: #ccc;"> 
													<a href="#">
														地点
													</a> &nbsp;•&nbsp; 
													<small>${job.cityName }</small>
												</span>
											</td>
											<td width="160" valign="top" align="left" class="hidden-xs">
												<span style="font-size: 11px; color: #ccc;"> 
													<a href="#">
														开始
													</a> &nbsp;•&nbsp; 
													<small>${job.beginTime }</small>
												</span>
												<div class="sep5" style="height: 1px;"></div>
												<span style="font-size: 11px; color: #ccc;"> 
													<a href="#">
														结束
													</a> &nbsp;•&nbsp; 
													<small>${job.endTime} </small>
												</span>
											</td>
											<td width="60" valign="top" class="hidden-xs" style="position: relative;">
												<a class="count_livid send-email" style="float:right;margin-right: 10px; font-size: 25px;" data-url="" data-job="${job.jobId}" data-pre="0">
													<span class="glyphicon glyphicon-envelope"></span>
												</a>
												<div class="clearfix"></div>
												<p class="my_pre">预约成功</p>
											</td>
										</tr>
									</tbody>
								</table>
							</li>
						</c:forEach>
						</ul>
					</main>
				</div>
				<div class="col-md-3 adv visible-md visible-lg" style="padding-right: 0px;">
					<div class="panel panel-default">
					    <div class="panel-heading">
					       	<span class="glyphicon glyphicon-fire"></span>&nbsp;今&nbsp;日&nbsp;兼&nbsp;职&nbsp;推&nbsp;送
					    </div>
					     <ul class="list-group" id="today-jobs">
					 
					        
					    </ul>
					</div>
					
					<div class="panel panel-default">
					    <div class="panel-heading">
					       	<span class="glyphicon glyphicon-apple"></span>&nbsp;最&nbsp;近&nbsp;浏&nbsp;览&nbsp;记&nbsp;录
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
					        
					    </ul>
					</div>
				</div>
			</div>
		</div>

		<div id="product-fk">
			<div id="feedback-icon">
				<div class="fb-icon"></div>
				<span>用户反馈</span>
			</div>
		</div>
		<div class="container" id="bullet-con">
			<div class="row">
				<div class="col col-xs-12 col-md-9 col-md-offset-2">
					<div class="input-group">
				      <input type="text" id="bullet-text" class="form-control">
				      <span class="input-group-btn">
				        <button class="btn btn-default" type="button" id="bullet-send">发送弹幕</button>
				      </span>
				    </div><!-- /input-group -->
				</div>				
			</div>
			<span id="bullet-close" class="pull-right visible-md glyphicon glyphicon-remove"></span>
		</div>
		<iframe id="webchat7moor" src="chat.html" style="display: none; margin: 0px; padding: 0px; width: 320px; height: 542px; border-width: 0px; border-radius: 3px; transition: height 0.5s ease-out; z-index: 99999; bottom: 0px; right: 0px; position: fixed;"></iframe>
		<script type="text/javascript" src="<c:url value='/js/jquery.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/js/jquery.barrager.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/message.js'/>"></script>
		<script>
			$(".fb-icon").click(function(){
				$("#webchat7moor").css("display","block");
			});

			//异步获取今日热推
			$.ajax({
				url:"ajax_todayJobs",
				dataType:"json",
				success:function(data){
					console.log(data);
					for(var i =0;i<data.length;i++){
						var html = '<li class="list-group-item">'
							html+= '<a href="">['+data[i].cityName+']</a>&nbsp;'
							html+= '<a href="">'
							html+= '<span class="glyphicon glyphicon-map-marker"></span>'
							html+= '&nbsp;'+data[i].detailAddr.substring(0,6)
							html+= '<span style="font-weight: bold;">...</span>'
							html+= '</a>'
							html+= '</li>'
						$("#today-jobs").append(html);
					}
				},

				error:function(data){
					//
					console.log(data);
					
				}
				
			});


			//异步改变搜索的样式
			$.ajax({
				url:"ajax_searchKey",
				dataType:"json",
				success:function(data){
					console.log(data);
					if(data.cityName!=null){
						var cityName = data.cityName.replace(/\%/g,"");
						$(".city").removeClass("ser-kind");
						
						$(".city[data-name='"+cityName+"']").addClass("ser-kind");
					}else{
						$(".city[data-name='全国']").addClass("ser-kind");
					}

					if(data.weekTime!=null){
						var weekTime = data.weekTime;
						$("#week-time").find("a").removeClass("ser-kind");
						$(".week-time[data-name='"+weekTime+"']").addClass("ser-kind");
						
					}else{
						$(".week-time[data-name='不限']").addClass("ser-kind");
					}

					if(data.jobKindName!=null){
						var jobKindName = data.jobKindName.replace(/\%/g,"");
						console.log(jobKindName);
						$("#job-kind-name").find("a").removeClass("ser-kind");
						$(".job-kind-name[data-name='"+jobKindName+"']").addClass("ser-kind");
					}else{
						$(".job-kind-name[data-name='所有']").addClass("ser-kind");
					}
				},
				error:function(){
					console.log("error");
				}
			});


			
			
			
		</script>
	</body>
</html>