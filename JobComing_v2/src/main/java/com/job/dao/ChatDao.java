package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.Chat;

public interface ChatDao {
	/**
	 * ���������¼��������
	 * @param chat
	 */
	public void insert(Chat chat);
	/**
	 * �����û�id���������¼
	 * @param userId
	 * @return
	 */
	public List<Chat> getChatListByUserId(int userId);
	/**
	 * ͨ���������޸�״̬
	 * @param chatId
	 * @param status
	 */
	public void update(@Param("chatId")int chatId,@Param("status")int status);
	/**
	 * 批量删除
	 * @param chatId
	 */
	public void delete(List<Integer> list);
	
}
