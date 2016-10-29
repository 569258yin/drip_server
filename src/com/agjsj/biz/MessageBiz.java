package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Message;

public interface MessageBiz{
	/**
	 * 发送消息
	 * @param message
	 * @return
	 */
	public boolean sendMessage(Message message);
	
	/**
	 * 得到系统通知消息
	 * @return
	 */
	public List<Message> getSystemMessage();
	
	/**
	 * 得到用户个人消息
	 * @param user_id
	 * @return
	 */
	public List<Message> getPersonMessage(Integer user_id);
}
