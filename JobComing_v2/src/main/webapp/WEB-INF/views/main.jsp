<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="time" uri="/WEB-INF/time.tld"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>	
		<title>主界面</title>
		<jsp:include page="/WEB-INF/components/styles.jsp"></jsp:include>
	</head>

	<body class="home-template">

		<!-- 引入头部 -->
		<jsp:include page="/WEB-INF/components/head.jsp"></jsp:include>
		<div class="container mycontainer">
			<div class="row">
				<div class="col-md-9">
					<div class="mostused-packages well hidden-xs hidden-sm">
						<div>
							<div id="city-name">
								<span>兼职地点：</span>
								<a class="city active"  href="jobs?cityName=-1" data-name="全国">全国</a>
								<a class="active city" href="jobs?cityName=南京" data-name="南京">南京</a>
								<a class="active city" href="jobs?cityName=杭州" data-name='杭州'>杭州</a>
								<a class="active city" href="jobs?cityName=上海" data-name="上海">上海</a>
								<a class="active city" href="jobs?cityName=北京" data-name='北京'>北京</a>
								<a class="active city" href="jobs?cityName=深圳" data-name='深圳'>深圳</a>
								<a class="active city" href="jobs?cityName=广州" data-name='广州'>广州</a>
								<a class="active city" href="jobs?cityName=成都" data-name='成都'>成都</a>
								<a class="active city" href="jobs?cityName=苏州" data-name='苏州'>苏州</a>
								<a class="active city" href="jobs?cityName=长沙" data-name='长沙'>长沙</a>
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
								<a href="jobs?weekTime=-1"  data-name="-1"class="active week-time" >不限</a>
								<a href="jobs?weekTime=2" data-name="2" class="active week-time">周一</a>
								<a href="jobs?weekTime=3" data-name="3" class="active week-time">周二</a>
								<a href="jobs?weekTime=4" data-name="4" class="active week-time">周三</a>
								<a href="jobs?weekTime=5" data-name="5" class="active week-time">周四</a>
								<a href="jobs?weekTime=6" data-name="6" class="active week-time">周五</a>
								<a href="jobs?weekTime=7" data-name="7" class="active week-time">周六</a>
								<a href="jobs?weekTime=1" data-name="1" class="active week-time">周日</a>
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
															
													 <c:set var="time" value="${job.jobTime}"/>
														<small>${time:getTimeBefore(time)}</small>
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
					<!-- 今日热推 -->
					<jsp:include page="/WEB-INF/components/todayjobs.jsp"></jsp:include>
					<!-- 浏览记录 -->
					<jsp:include page="/WEB-INF/components/historyjobs.jsp"></jsp:include>
					
				</div>
			</div>
		</div>

		<div id="product-fk">
			<div id="feedback-icon">
				<div class="fb-icon"></div>
				<span>用户反馈</span>
			</div>
		</div>
		<!-- 弹幕发送 -->
		<jsp:include page="/WEB-INF/components/bullet.jsp"></jsp:include>
		
		<iframe id="webchat7moor" src="chat.html" style="display: none; margin: 0px; padding: 0px; width: 320px; height: 542px; border-width: 0px; border-radius: 3px; transition: height 0.5s ease-out; z-index: 99999; bottom: 0px; right: 0px; position: fixed;"></iframe>

		<script src="<c:url value='/js/search.js'/>"></script>


		<script>
			$(".fb-icon").click(function(){
				$("#webchat7moor").css("display","block");
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
						$(".week-time[data-name='-1']").addClass("ser-kind");
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