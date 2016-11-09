//下拉框选择出生
	var sel_year = $("#sel_year")[0].options;
	var sel_month = $("#sel_month")[0].options;
	for(var i = 1970;i <= 2016; i++){
		sel_year.add(new Option(i+"年",i+"年"));
	}
	
	$("#sel_year").change(function(){
		sel_month.length = 1;
		var value = $("#sel_year").val();
		if(value!=" "){	
			for(var i = 1;i <= 12; i++){
				sel_month.add(new Option(i+"月",i+"月"));
			}
		}
	});
//注册表单  用户名
$("#register_username").blur(function(){
	//用户名规则--数字，字母，下划线，中文 6-12位
	var username_reg = /^[a-z\d_\u4e00-\u9fa5]{6,12}$/;
	var value = $(this).val();
	if(value==""){
		$(this).prev().html("用户名不能为空");
		$(this).addClass("input-error");
	}
	else if(!username_reg.test(value)){
		$(this).prev().html("数字,字母,下划线,中文6至12位");
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

//密码1
var password1 = "";
$("#register_password1").blur(function(){
	var pass_reg = /^\w{6,12}$/;
	var value = $(this).val();
	if(value==""){
		$(this).prev().html("请填写密码");
		$(this).addClass("input-error");
	}
	else if(!pass_reg.test(value)){
		$(this).prev().html("格式不合法(6-12)");
		$(this).addClass("input-error");
	}
	else{
		$(this).prev().html("");
		$(this).removeClass("input-error");
		password1 = value;
	}
});

//密码2
$("#register_password2").blur(function(){
	var value = $(this).val();
	if(value==""){
		$(this).prev().html("请填写密码");
		$(this).addClass("input-error");
	}
	else if(value != password1){
		$(this).prev().html("两次密码不一致");
		$(this).addClass("input-error");
	}
	else{
		$(this).prev().html("");
		$(this).removeClass("input-error");
	}
});

//邮箱
$("#register_email").blur(function(){
	var value = $(this).val();
	var email_reg = /^\w+@(\w+\.[a-z,A-Z]+)+$/;
	if(value == ""){
		$(this).prev().html("请填写邮箱号");
		$(this).addClass("input-error");
	}
	else if(!email_reg.test(value)){
		$(this).prev().html("邮箱格式不正确");
		$(this).addClass("input-error");
	}
	else{
		$(this).prev().html("");
		$(this).removeClass("input-error");
	}
});

//手机
$("#register_phone").blur(function(){
	var value = $(this).val();
	var phone_reg = /^1[34578]\d{9}$/;
	if(value == ""){
		$(this).prev().html("请填写手机号码");
		$(this).addClass("input-error");
	}
	else if(!phone_reg.test(value)){
		$(this).prev().html("手机格式不正确");
		$(this).addClass("input-error");
	}
	else{
		$(this).prev().html("");
		$(this).removeClass("input-error");
	}
});
 
//真实姓名
$("#register_realname").blur(function(){
	var value = $(this).val();
	var realname_reg =/^[\u4e00-\u9fa5]{2,4}$/;
	if(value == ""){
		$(this).prev().html("请填写真实姓名");
		$(this).addClass("input-error");
	}
	else if(!realname_reg.test(value)){
		$(this).prev().html("含非法字符");
		$(this).addClass("input-error");
	}
	else{
		$(this).prev().html("");
		$(this).removeClass("input-error");
	}
});
 