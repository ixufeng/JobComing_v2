package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.Chat;

public interface ChatDao {
	/**
	 * 根据聊天记录对象插入表
	 * @param chat
	 */
	public void insert(Chat chat);
	/**
	 * 根据用户id返回聊天记录
	 * @param userId
	 * @return
	 */
	public List<Chat> getChatListByUserId(int userId);
	/**
	 * 通过聊天编号修改状态
	 * @param chatId
	 * @param status
	 */
	public void update(@Param("chatId")int chatId,@Param("status")int status);
	/**
	 * 通过聊天编号删除聊天记录
	 * @param chatId
	 */
	public void delete(List<Integer> list);
	
}
