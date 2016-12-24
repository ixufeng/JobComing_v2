package com.job.serviceImpl;

import com.job.bean.Job;
import com.job.bean.User;
import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.model.MailAddressReceiver;
import com.sendcloud.sdk.model.MailBody;
import com.sendcloud.sdk.model.SendCloudMail;
import com.sendcloud.sdk.model.TextContent;
import com.sendcloud.sdk.model.TextContent.ScContentType;
import com.sendcloud.sdk.util.ResponseData;

public class MailServiceImpl {

	/**
	 * 通过模板
	 * @param receivedUser  接收人邮件
	 * @param sendUser      发送人邮件
	 * @param mailTheme		邮件主题
	 * @param html			发送的html内容
	 * @return
	 * @throws Throwable
	 */
	public static boolean sendCommon(String receivedUser,String sendUser,String mailTheme,String html) throws Throwable {
		MailAddressReceiver receiver = new MailAddressReceiver();
		// 添加收件人
		receiver.addTo(receivedUser); //多个人以分号间隔
		// 添加抄送
		//receiver.addCc("JobComing@qq.com");
		// 添加密送
		//receiver.addBcc("1054993687@qq.com");

		MailBody body = new MailBody();
		// 设置 From
		body.setFrom("JobComing@JobComing.org");
		// 设置 FromName
		body.setFromName("JobComing");
		// 设置 ReplyTo
		body.setReplyTo("reply@JobComing.org");
		// 设置标题
		body.setSubject(mailTheme);
		// 创建文件附件
		//body.addAttachments(new File("D:/1.png"));
		//body.addAttachments(new File("D:/2.png"));
		//// 创建流附件
		// body.addAttachments(new FileInputStream(new File("D:/ff.png")));

		TextContent content = new TextContent();
		content.setContent_type(ScContentType.html);
		content.setText(html);

		SendCloudMail mail = new SendCloudMail();
		mail.setTo(receiver);
		mail.setBody(body);
		mail.setContent(content);

		SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendMail(mail);
		
		if(res.getResult()){
			
			return true;
			
		}
		return false;
		
	}
	
	
	/**
	 * 临时测试，可以通过读取配置文件来发送邮件，或者邮件模板
	 * 给用户发送激活邮件
	 * @param user
	 * @param activeCode
	 */
	public static boolean sendActiveMail(String user,String activeCode){
		try {
			boolean bol = sendCommon(user,"JobComing.org","the email is used to activate the account of jobciming","<html><p>Please click on the following link to activate within half an hour<a href='http://ixufeng.cn/jobcoming/api/active?activeCode="+activeCode+"'>active now !</a></p></html>");
			if(bol)return true;
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 临时测试，可以通过读取配置文件来发送邮件，或者邮件模板
	 * 用户发送求职邮件
	 * @param recevecdUserEmail
	 * @param sendUser
	 * @param job
	 * @return
	 */
	public static boolean applyForJobMail(String recevecdUserEmail,User sendUser,Job job){
		
		if(recevecdUserEmail==null||sendUser==null||job==null){
			return false;
		}
		
		String html = "<html><body><strong>【求职人】：</strong>："+sendUser.getUserName()+"<br/>【求职电话】："+sendUser.getPhone()+"<br/>&nbsp;&nbsp;&nbsp;你可以通过电话直接和他联系，也可以<a href='#'>点击这里</a>登陆到JobComing来联系</body></html>";
		try {
			
			boolean bol = sendCommon(recevecdUserEmail,sendUser.getEmail(),"JobComing:有人向您发出的【"+job.getJobScribe()+"】这份工作感兴趣",html);
			if(bol) return true;
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}
	
}
