//发送弹幕

(function(){
	
	//点击发送弹幕
	$("#bullet-send").click(function(){
		
		var text = $("#bullet-text").val();
		$.ajax({
			url:"message/bullet",			
			dataType:"text",
			data:{
				"info":text,
				"color":'#0f0',
				"close":true,
				"speed":6
			},
			success:function(data){
				console.log(data);
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