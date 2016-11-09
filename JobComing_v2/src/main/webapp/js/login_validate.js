//登录表单
//表单失去焦点的事件 --用户名
$("#login_username").blur(function() {
	var value = $(this).val();
	if (value == "") {
		$(this).prev().html("用户名不能为空");
		$(this).addClass("input-error");
	} else {
		$(this).prev().html("");
		$(this).removeClass("input-error");
	}
});

$("#login_password").blur(function() {
	// 验证密码
	var value = $(this).val();
	if (value == "") {
		$(this).prev().html("密码不能为空");
		$(this).addClass("input-error");
	} else {
		$(this).prev().html("");
		$(this).removeClass("input-error");
	}
});

function geetestValidate() {
	var handlerPopup = function(captchaObj) {
		// 成功的回调
		captchaObj.onSuccess(function() {
			var validate = captchaObj.getValidate();
			$.ajax({
				url : "VerifyLoginServlet", // 进行二次验证
				type : "post",
				dataType : "json",
				data : {
					geetest_challenge : validate.geetest_challenge,
					geetest_validate : validate.geetest_validate,
					geetest_seccode : validate.geetest_seccode
				},
				success : function(data) {
					if (data && (data.status === "success")) {
						$("form").submit();
					} else {
						return false;
					}
				}
			});
		});
		$("#popup-submit").click(function(e) {
			var username = $("#login_username").val();
			var password = $("#login_password").val();
			if (username == "") {
				e.preventDefault();
				$("#login_username").addClass('input-error');
			}
			if (password == "") {
				e.preventDefault();
				$("#login_password").addClass('input-error');
			}
			if (username != "" && password != "") {
				e.preventDefault();
				$("#login_username").removeClass('input-error');
				$("#login_password").removeClass('input-error');
				captchaObj.show();
			}
		});
		// 将验证码加到id为captcha的元素里
		captchaObj.appendTo("#popup-captcha");
	};
	// 验证开始需要向网站主后台获取id，challenge，success（是否启用failback）
	$.ajax({
		url : "StartCaptchaServlet?t=" + (new Date()).getTime(), // 加随机数防止缓存
		type : "post",
		dataType : "json",
		success : function(data) {
			// 使用initGeetest接口
			// 参数1：配置参数
			// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
			initGeetest({
				gt : data.gt,
				challenge : data.challenge,
				product : "popup", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
				offline : !data.success
			// 表示用户后台检测极验服务器是否宕机，一般不需要关注
			}, handlerPopup);
		}
	});
};

/*
 * $('.registration-form').on('submit', function(e) {
 * $(this).find('input[type="text"], input[type="password"]').each(function() {
 * var labelInfo = $(this).prev().html(); if($(this).val() == "" || labelInfo !=
 * "") { e.preventDefault(); $(this).addClass('input-error'); } else {
 * $(this).removeClass('input-error'); } }); });
 */

geetestValidate();