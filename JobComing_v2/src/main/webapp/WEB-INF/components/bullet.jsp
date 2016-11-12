<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="<c:url value='/js/jquery.barrager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/message.js'/>"></script>