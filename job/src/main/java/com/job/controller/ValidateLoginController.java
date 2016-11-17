package com.job.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.job.utils.GeetestConfig;
import com.job.utils.GeetestLib;

@Controller
@RequestMapping("/validate")
public class ValidateLoginController {
	@ResponseBody
	@RequestMapping("/gtOne")
	public String geetestOne(HttpServletRequest request) {

		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key());
		String resStr = "{}";
		// 自定义userid
		String userid = "test";
		// 进行验证预处理
		int gtServerStatus = gtSdk.preProcess(userid);
		// 将服务器状态设置到session中
		request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
		// 将userid设置到session中
		request.getSession().setAttribute("userid", userid);
		resStr = gtSdk.getResponseStr();
		return resStr;
	}

	@RequestMapping("/gtTwo")
	public @ResponseBody Map<String, String> geetestSec(HttpServletRequest request) {
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key());
		String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
		String validate = request.getParameter(GeetestLib.fn_geetest_validate);
		String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
		// 从session中获取gt-server状态
		int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
		// 从session中获取userid
		String userid = (String) request.getSession().getAttribute("userid");
		int gtResult = 0;
		if (gt_server_status_code == 1) {
			// gt-server正常，向gt-server进行二次验证
			gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, userid);
		} else {
			// gt-server非正常情况下，进行failback模式验证
			gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
		}
		Map<String, String> data = new HashMap<>();
		if (gtResult == 1) {
			// 验证成功
			data.put("status", "success");
			data.put("version", gtSdk.getVersionInfo());
			return data;
		} else {
			data.put("status", "fail");
			data.put("version", gtSdk.getVersionInfo());
			return data;
		}
	}
}
