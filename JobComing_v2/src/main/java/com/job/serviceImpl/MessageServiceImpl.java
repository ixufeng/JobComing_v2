package com.job.serviceImpl;

import org.springframework.stereotype.Service;

import com.job.bean.BulletMessage;
import com.job.service.MessageService;
import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;


/**
 * message服务
 * @author xufeng
 *
 */
@Service
public class MessageServiceImpl implements MessageService {
	

	private final String goEasyKey = "93468357-b450-4c4b-a011-ce2dd9e9b59a"; //超级key,可以接收，可以发送，只保留在服务器端
	private final String bulletChannel = "bulletMessage";
	
	/**
	 * 发送弹幕
	 * @param content
	 */
	@Override
	public boolean pushBulletMessage(BulletMessage bullet){
		
		String content = bullet.toString();
		
		GoEasy goEasy = new GoEasy(this.goEasyKey);
		goEasy.publish(bulletChannel, content, new PublishListener(){
			
			@Override
			public void onSuccess() {
	
			}
			
			@Override
			public void onFailed(GoEasyError error) {
			
			}
			
		});
		
		return true;
	}
	
}
