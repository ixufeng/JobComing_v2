//发送弹幕

(function(){
	//打开发送弹幕栏
	$("#bullet-button").click(function(){
		
		$("#bullet-con").animate({"bottom":"0px"},200);
		
	});
	//关闭发送弹幕栏
	$("#bullet-close").click(function(){
		
		$("#bullet-con").animate({"bottom":"-60px"},200);
		
	});
	
	
	//点击发送弹幕
	$("#bullet-send").click(function(){
		
		var text = $("#bullet-text").val();
		if(text==null||text.trim()==""){
			return;
		}
		$.ajax({
			url:"message/bullet",			
			dataType:"text",
			data:{
				"info":text,
				"color":'#505',
				"close":true,
				"speed":6
			},
			error:function(data){
				
				console.log(data);
			}
			
		});

	});
	

})();

var goEasy = new GoEasy({
    appkey: '93468357-b450-4c4b-a011-ce2dd9e9b59a'
});

goEasy.subscribe({
  channel: 'bulletMessage',
  onMessage: function(message){
	  if(message!=null){
		  
		  var json = eval('('+message.content+')');
		 $('body').barrager(json);
	  }
      
  }
});

//发送邮件
$(".send-email").click(function(){
	var data = $(this).attr("data-pre");
	var url = $(this).attr("data-url") + "ajax_jobMail";
	var jobId = $(this).attr("data-job");
	var om = $(this);
	//没有预约过
	if(data=="0"){
		$.ajax({
			url:url,
			data:{"jobId":jobId},
			dataType:"text",
			success:function(data){
				if(data=="success"){
					alert("预约成功！");
					om.css("color","#ccc");
					
				}
				if(data=="selfJob"){
					//自己发布的工作
					alert("不能预约自己的工作！");
					
				}
				if(data=="unlogin"){
					alert("请先登录！");
				}
				if(data=="invalidJob"){
					alert("该工作已无效！");
				}
				if(data=="faliure"){
					alert("发送邮件失败");
				}
				if(data=="hasJob"){
					alert("这个工作已经预约过了");
					om.attr("data-pre","1");
					om.css("color","#ccc");
				}
			},
			
			error:function(data){
				
			}
			
		});
	}
	
	
});



