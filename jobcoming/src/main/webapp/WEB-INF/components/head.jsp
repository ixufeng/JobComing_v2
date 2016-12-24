<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="site-notice">
			<a href=""><em>JobComing~</em></a>
			<a class="pull-right" id="bullet-button" data-flag="0" style="margin-right:30px;">弹幕</a>
		</div>
		<header class="site-header jumbotron">
			<c:choose>
		  	<c:when test="${empty loginUser}">
				<div class="site-nav"> 
					<a href="/jobcoming/user/goLogin">登录</a> <span>/</span>
					<a href="/jobcoming/user/goRegister">注册</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="site-nav">
					<a href="/jobcoming/user/goUser">${loginUser.userName}</a> <span>/</span>
					<a href="/jobcoming/user/goJobPublish">发布兼职</a>
				</div>
			</c:otherwise>
		  </c:choose>
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<form class="" role="search">
							<div class="form-group">
								<input type="text" id="select-job" class="form-control search clearable" placeholder="搜索兼职/单位/地点">
								<i class="glyphicon glyphicon-search"></i>
								<ul class="list-group" id="hide-info">
									</ul>
							</div>
						</form>
					</div>
				</div>
			</div>
		</header>