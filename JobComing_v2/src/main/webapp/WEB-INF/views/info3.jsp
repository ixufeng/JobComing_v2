<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>个人主页</title>
		<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/site.min.css'/>" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value='/css/main.css'/>" />
		<link rel="stylesheet" href="<c:url value='/css/myinfo.css'/>" />
		<link rel="stylesheet" href="<c:url value='/css/fileinput.css'/>" />
		<link rel="shortcut icon" href="<c:url value='/img/favicon.png'/>">
	</head>

	<body class="home-template">
		<div class="site-notice">
			<a href=""><em>JobComing~</em></a>
		</div>
		<header class="site-header jumbotron">
			<c:choose>
		  	<c:when test="${empty loginUser}">
				<div class="site-nav">
					<a href="goLogin">登录</a> <span>/</span>
					<a href="goRegister">注册</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="site-nav">
					<a>${loginUser.userName}</a> <span>/</span>
					<a href="../jobs">首页</a>
				</div>
			</c:otherwise>
		  </c:choose>
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2">
						<form class="" role="search">
							<div class="form-group">
								<input type="text" class="form-control search clearable" placeholder="搜索兼职/单位/地点">
								<i class="glyphicon glyphicon-search"></i>
								<!--这个是键盘按下的时候搜索的ajax异步显示信息-->
									<ul class="list-group" id="hide-info">
										<li class="list-group-item">
											<a href="">java</a>
										</li>
										<li class="list-group-item">
											<a href="">java</a>
										</li>
										<li class="list-group-item">
											<a href="">java</a>
										</li>
									</ul>
							</div>
						</form>
					</div>
				</div>
			</div>
		</header>
		<div class="container">
			<div class="row">
				<div class="col-md-2 myinfo visible-lg visible-md">
					<div class="list-group">
						<a href="goUser" class="list-group-item">我的信息</a>
						<a href="goTogether" class="list-group-item">参与记录</a>
						<a href="goPublish" class="list-group-item active">分享记录</a>
						<a href="../jobs" class="list-group-item">返回首页</a>
					</div>
				</div>
				<div class="col-md-10 myinfo">
					<ul class="nav nav-tabs">
						<li class="active bar">
							<a href="goUser">我的信息</a>
						</li>
						<li class="bar">
							<a href="goTogether">参与记录</a>
						</li>
						<li class="bar">
							<a href="goPublish">分享记录</a>
						</li>
					</ul>
					
					<table class="table table3">
						<tbody>
							<tr>
								<th width="60" style="text-align: center">编号</th>
								<th width="auto" style="text-align: center">内容</th>
								<th width="60" style="text-align: center">类别</th>
								<th width="60" style="text-align: center">详情</th>
							</tr>
							<c:forEach var="jobShow" items="${sessionScope.jobShow}" varStatus="vs"> 
							<tr>
								<td width="60" style="text-align: center">${vs.count}</td>
								<td width="auto" style="text-align: center;">
									<div style="overflow: hidden;display: block;min-width: 100px;">${jobShow.jobPublish.workDescribe }</div>
								</td>
								<td width="60" style="text-align: center">
									<a>[${jobShow.jobKind.jobKindName}]</a>
								</td>
								<td width="60" style="text-align: center">
									<a data-toggle="modal" data-target="#vs${vs.count}">[查看]</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!--个人信息修改的模态框-->
		<div class="modal fade" id="modifyInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form role="form" action="" method="post" class="login-form">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">个人信息修改</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="sr-only" for="form-username">Username</label>
								<input type="text" name="username" value="匆匆那年YY" readonly="readonly" class="form-username form-control" id="form-username">
							</div>
							<div class="form-group">
								<label class="sr-only" for="form-email">Email</label>
								<input type="text" name="email" value="1070763759@qq.com" readonly="readonly" class="form-username form-control" id="form-email">
							</div>
							<div class="form-group">
								<label class="sr-only" for="form-phone">Phone</label>
								<input type="text" name="email" value="18151587371" readonly="readonly" class="form-username form-control" id="form-email">
							</div>
							<div class="form-group">
								<label class="control-label">头像选择</label>
								<input id="input-2" name="image" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">
							</div>
							<div class="form-group" style="margin-bottom: 60px;">
								<div class="radio col-xs-4 col-sm-3">
									<label>
										<input type="radio" name="sex" id="male" value="male" checked="checked">
									</label>
									<span><img src="img/male.png" class="img-responsive" style="width: 20px; height:20px;display: inline-block;margin-top: -2px;"></span>
								</div>
								<div class="radio col-xs-4 col-sm-3" style="margin-top: 10px;">
									<label>
										<input type="radio" name="sex" id="female" value="female">
									</label>
									<span><img src="img/female.png" class="img-responsive" style="width: 20px; height:20px;display: inline-block;margin-top: -2px;"></span>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary">修改信息</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--个人信息修改的模态框-->

		<!--工作信息查看的模态框-->
		<div class="modal fade" id="modifyJob" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">兼职信息</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="" for="username" style="margin-left: 5px;">发布人</label>
							<input type="text" name="username" value="匆匆那年YY" readonly="readonly" class="form-username form-control" id="form-username">
						</div>
						<div class="form-group">
							<label class="" for="content" style="margin-left: 5px;">发布详情</label>
							<textarea class="form-control" rows="2">兼职信息的介绍内容</textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--工作信息查看的模态框-->
		
		<!--用户评价模态框-->
		<div class="modal fade" id="modifyGrade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="" method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">用户评价</h4>
						</div>
						<div class="modal-body">

							<div class="form-group">
								<label class="" for="username" style="margin-left: 5px;">发布人</label>
								<input type="text" name="username" value="匆匆那年YY" readonly="readonly" class="form-username form-control" id="form-username">
							</div>
							<div class="form-group">
								<label class="" for="content" style="margin-left: 5px;">评价内容</label>
								<textarea class="form-control" rows="2">用户的一些评价，需要写进评价表</textarea>
							</div>
							<div class="form-group">
								<label class="" for="content" style="margin-left: 5px;">用户评分</label>
								<ul>
									<li></li>
									<li></li>
									<li></li>
									<li></li>
									<li></li>
								</ul>
							</div>
							<div class="form-group">
								<input type="hidden" class="form-control grade" value="" name="grade"/>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">提交评价</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--用户评价模态框-->

		<!--发布信息查看的模态框-->
		<c:forEach var="jobShowD" items="${sessionScope.jobShow}" varStatus="vs"> 
		<div class="modal fade" id="vs${vs.count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">我的分享兼职</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="" for="username" style="margin-left: 5px;">地点</label>
							<input type="text" name="username" value="${jobShowD.jobPublish.detailAddress}" readonly="readonly" class="form-username form-control" id="form-username">
						</div>
						<div class="form-group">
							<label class="" for="content" style="margin-left: 5px;">分享详情</label>
							<textarea class="form-control" rows="2">${jobShowD.jobPublish.workDescribe}</textarea>
						</div>
						<div class="form-group">
							<label class="" for="username" style="margin-left: 5px;">开始时间</label>
							<input type="text" name="username" value="${jobShowD.jobPublish.workBeginTime}" readonly="readonly" class="form-username form-control" id="form-username">
						</div>
						<div class="form-group">
							<label class="" for="username" style="margin-left: 5px;">结束时间</label>
							<input type="text" name="username" value="${jobShowD.jobPublish.workOverTime}" readonly="readonly" class="form-username form-control" id="form-username">
						</div>
					</div>
				</div>
			</div>
		</div>
		</c:forEach>
		<!--发布信息查看的模态框-->
		<script src="<c:url value='/js/jquery.js'/>"></script>
		<script src="<c:url value='/js/bootstrap.js'/>"></script>
		<script src="<c:url value='/js/fileinput.js'/>"></script>
		<script src="<c:url value='/js/search.js'/>"></script>
		<script>
			$(".form-group ul li").click(function(){
				var value = $(this).index()+1;
				$(this).css("background-position","0px -30px");
				$(this).prevAll().css("background-position","0px -30px");
				$(this).nextAll().css("background-position","0px 0px");
				$(".form-group .grade").val(value);
			});
		</script>
	</body>

</html>