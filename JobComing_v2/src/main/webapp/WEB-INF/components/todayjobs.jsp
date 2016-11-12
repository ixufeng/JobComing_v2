<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="panel panel-default">
    <div class="panel-heading">
       	<span class="glyphicon glyphicon-apple"></span>&nbsp;今&nbsp;日&nbsp;热&nbsp;推
    </div>
     <ul id="today-jobs" class="list-group">
       
        
    </ul>
</div>
<script>
$(document).ready(function(){
	//异步获取今日热推
	$.ajax({
		url:"ajax_todayJobs",
		dataType:"json",
		success:function(data){
		
			for(var i =0;i<data.length;i++){
				var html = '<li class="list-group-item">'
					html+= '<a href="">['+data[i].cityName+']</a>&nbsp;'
					html+= '<a href="/JobComing_v2/jobInfo?jobId='+data[i].jobId+'">'
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

});

</script>