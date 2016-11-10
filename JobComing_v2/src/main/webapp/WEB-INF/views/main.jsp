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
		<link rel="stylesheet" href="<c:url value='/css/main.css'/>" />
		<link rel="shortcut icon" href="<c:url value='/img/favicon.png'/>">
	</head>

	<body class="home-template">
		<div class="site-notice">
			<a href=""><em>JobComing~</em></a>
		</div>
		<header class="site-header jumbotron">
			<div class="site-nav">
				<a href="login">登录</a> <span>/</span>
				<a href="register">注册</a>
			</div>
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
							<span>兼职地点：</span>
							<a class="current">全国</a>
							<a href="" class="active">南京</a>
							<a href="" class="active">杭州</a>
							<a href="" class="active">上海</a>
							<a href="" class="active">北京</a>
							<a href="" class="active">深圳</a>
							<a href="" class="active">广州</a>
							<a href="" class="active">成都</a>
							<a href="" class="active">苏州</a>
							<a href="" class="active">长沙</a>
							<a href="city.html" style="float: right;">更多<i class="caret"></i></a>
							<div class="sep5" style="height: 20px;"></div>
							<span>兼职形式：</span>
							<a class="ser-kind">所有</a>
							<a href="" class="active">清洁</a>
							<a href="" class="active">家教</a>
							<a href="" class="active">宣传</a>
							<a href="" class="active">派送</a>
							<a href="" class="active">调研</a>
							<a href="" class="active">促销</a>
							<div class="sep5" style="height: 20px;"></div>
							<span>开始时间：</span>
							<a class="ser-kind">不限</a>
							<a href="" class="active">周一</a>
							<a href="" class="active">周二</a>
							<a href="" class="active">周三</a>
							<a href="" class="active">周四</a>
							<a href="" class="active">周五</a>
							<a href="" class="active">周六</a>
							<a href="" class="active">周日</a>
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
							<li class="list-group-item">
								<table style="border: 0px;width: 100%;">
									<tbody>
										<tr>
											<td width="55" valign="top" align="center">
												<a href="#">
													<img src="<c:url value='/img/public.png'/>" style="width: 55px; height: 55px;" class="img-responsive img-rounded" border="0">
												</a>
											</td>
											<td width="10"></td>
											<td width="auto" valign="middle">
												<span class="item_title"> 
													<a href="" style="color: #00b38a;">[清洁]</a>
													<a href="" style="color: #4d5256;">江苏科技大学某实验室需要一些人打扫卫生</a>
												</span>
												<div class="sep5" style="height: 1px;"></div>

												<span style="font-size: 11px; color: #ccc;">		
													<a href="#">
														发布人
													</a> &nbsp;•&nbsp; 
													<strong>
														<a href="#" style="color: #4d5256;">
															张先生
														</a>
													</strong> &nbsp;•&nbsp; 
															
													<small>2天前</small>
												</span>
												<div class="sep5" style="height: 1px;"></div>
												<span style="font-size: 11px; color: #ccc;"> 
													<a href="#">
														地点
													</a> &nbsp;•&nbsp; 
													<small>江苏张家港</small>
												</span>
											</td>
											<td width="160" valign="top" align="left" class="hidden-xs">
												<span style="font-size: 11px; color: #ccc;"> 
													<a href="#">
														开始
													</a> &nbsp;•&nbsp; 
													<small>2016/10/26</small>
												</span>
												<div class="sep5" style="height: 1px;"></div>
												<span style="font-size: 11px; color: #ccc;"> 
													<a href="#">
														结束
													</a> &nbsp;•&nbsp; 
													<small>2016/10/26</small>
												</span>
											</td>
											<td width="60" valign="top" class="hidden-xs" style="position: relative;">
												<a href="#" class="count_livid" style="float:right;margin-right: 10px; font-size: 25px;" data-pre="0">
													<span class="glyphicon glyphicon-envelope"></span>
												</a>
												<div class="clearfix"></div>
												<p class="my_pre">预约成功</p>
											</td>
										</tr>
									</tbody>
								</table>
							</li>

						</ul>
					</main>
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
		
		<iframe id="webchat7moor" src="chat.html" style="display: none; margin: 0px; padding: 0px; width: 320px; height: 542px; border-width: 0px; border-radius: 3px; transition: height 0.5s ease-out; z-index: 99999; bottom: 0px; right: 0px; position: fixed;"></iframe>
		<script type="text/javascript" src="<c:url value='/js/jquery.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>" ></script>
		<script>
			$(".fb-icon").click(function(){
				$("#webchat7moor").css("display","block");
			})
		</script>
	</body>
</html>