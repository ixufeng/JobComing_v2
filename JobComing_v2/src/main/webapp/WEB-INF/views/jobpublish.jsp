<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>发布兼职</title>
		<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/site.min.css'/>" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value='/css/main.css'/>" />
		<link rel="stylesheet" href="<c:url value='/css/jobPublish.css'/>" />
		<link rel="shortcut icon" href="<c:url value='/img/favicon.png'/>">
	</head>

	<body class="home-template">
		<jsp:include page="/WEB-INF/components/head.jsp"></jsp:include>
		<div class="container" style="margin-top: 30px;">
			<div class="row">
				<div class="col-md-10 col-md-offset-1 job-info">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title" style="display: inline-block;">
            					分享一份兼职--JobComing
        					</h3>
        					
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-8">
									<form action="../jobPublish/submitJob" method="post">
										<h5 class="desc">
											<span class="glyphicon glyphicon-tags"></span>&nbsp;选择兼职类型
										</h5>
										<div class="form-group">
											<select class="form-control" id="jobkind" name="jobKindId">
												<option value="0">--选择一个兼职类型--</option>
												<option value="1">[清洁]</option>
												<option value="2">[家教]</option>
												<option value="3">[促销]</option>
												<option value="4">[派送]</option>
												<option value="5">[调研]</option>
												<option value="6">[计时工]</option>
												<option value="7">[网络兼职]</option>
												<option value="8">[撰稿]</option>
												<option value="9">[翻译]</option>
												<option value="10">[导游]</option>
											</select>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-map-marker"></span>&nbsp;选择兼职地点
										</h5>
										<div class="form-group">
											<select class="form-control" id="jobaddress" name="addrNumber">
												<option value="0">--选择兼职地点--</option>
												<option value="320100">[南京]</option>
												<option value="310100">[上海]</option>
												<option value="320500">[苏州]</option>
												<option value="320400">[常州]</option>
												<option value="321000">[扬州]</option>
												<option value="330100">[杭州]</option>
												<option value="320800">[淮安]</option>
												<option value="110100">[北京]</option>
												<option value="420100">[武汉]</option>
												<option value="220200">[吉林]</option>
											</select>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-leaf"></span>&nbsp;详细地址
										</h5>
										<div class="form-group">
											<textarea id="descCon1" class="form-control" rows="3" placeholder="对具体工作地址进行简短的描述" name="detailAddr"></textarea>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-leaf"></span>&nbsp;开始时间
										</h5>
										<div class="form-group">
											<input type="date" class="form-control" id="begindate" name="beginTime"/>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-leaf"></span>&nbsp;结束时间
										</h5>
										<div class="form-group">
											<input type="date" class="form-control" id="enddate" name="endTime"/>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-info-sign"></span>&nbsp;内容描述
										</h5>
										<div class="form-group">
											<textarea id="descCon" class="form-control" rows="3" placeholder="对工作的内容进行简短的描述" name="jobScribe"></textarea>
										</div>
										<button type="submit" class="btn btn-default btn-info" id="btn">发布信息</button>
									</form>	
								</div>
							
								<div class="col-md-4 visible-lg visible-md">
									<div class="panel panel-default">
										<div class="panel-heading">
											用户信息
										</div>
										<div class="panel-body">
											<p>
												<c:choose>
													  <c:when test="${ empty loginUser}">
									  	   					<img src="../img/public.png"style="width: 60px;height: 60px;" class="img-thumbnail">
													  </c:when>
											  		  <c:otherwise>
									     				 <img src="${loginUser.avatar}" style="width: 60px;height: 60px;" class="img-thumbnail">
									 			 	  </c:otherwise>
											    </c:choose>
											</p>
											<p>用户名:${loginUser.userName }</p>
											<p>用户积分:${loginUser.score }</p>
											<p>发布次数:</p>
											<p>参与次数:</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="<c:url value='/js/jquery.js'/>"></script>
		<script src="<c:url value='/js/bootstrap.js'/>"></script>
		<script src="<c:url value='/js/search.js'/>"></script>
		<!--//提交判断-->
		<script>
			$("form").submit(function(){
				 var jobkind = $("#jobkind").val();
				 var jobaddress = $("#jobaddress").val();
				 var date1 = $("#begindate").val();
				 var start=new Date(date1.replace("-", "/").replace("-", "/"));
				 var date2 = $("#enddate").val();
				 var end=new Date(date2.replace("-", "/").replace("-", "/"));
				 var con = $("#descCon").val();
				 var con1= $("#descCon1").val();
				 if(jobkind==""||jobaddress==""||date1==""||date2==""||con==""||con1==""){
				 	return false;
				 }
				 else if(end<start){
				 	return false;
				 }
				 else{
				 	return true;
				 }
			})
		</script>
	</body>

</html>