//登录表单
//表单失去焦点的事件 --用户名
$("#login_username").blur(function(){
	var value = $(this).val();
	if(value==""){
		$(this).prev().html("用户名不能为空");
		$(this).addClass("input-error");
	}
	else{
		$.ajax({
			type:"post",
			url:"",
			data:{username:value},
			success:function(date){
				
			},
			error:function(){
				
			},
			dataType:"",
		});
	}
});

$("#login_password").blur(function(){
	//验证密码
	var value = $(this).val();
	if(value==""){
		$(this).prev().html("密码不能为空");
		$(this).addClass("input-error");
	}
	else{
		$.ajax({
			type:"post",
			url:"",
			data:{password:value},
			success:function(date){
				
			},
			error:function(){
				
			},
			dataType:"",
		});
	}
})