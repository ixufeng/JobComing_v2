<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="site-notice">
			<a href=""><em>JobComing~</em></a>
			<a class="pull-right" id="bullet-button" style="margin-right:30px;">弹幕</a>
		</div>
		<header class="site-header jumbotron">
			<c:choose>
		  	<c:when test="${empty loginUser}">
				<div class="site-nav"> 
					<a href="/JobComing_v2/user/goLogin">登录</a> <span>/</span>
					<a href="/JobComing_v2/user/goRegister">注册</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="site-nav">
					<a href="/JobComing_v2/user/goUser">${loginUser.userName}</a> <span>/</span>
					<a href="/JobComing_v2/user/goJobPublish">发布兼职</a>
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