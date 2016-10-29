package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Message;

public class MessageDAOImpl extends BaseHibernateDAO implements MessageDAO{

	@Override
	public boolean sendMessage(Message message) {
		return this.add(message);
	}

	/**
	 * 为1 的时候系统消息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getSystemMessage() {
		String hql = "from Message message where message.messageTag=1";
		return getByHql(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getPersonMessage(Integer user_id) {
		String hql = "from Message message where message.messageTag=0 "
				+ "and message.userReceiveId='"+user_id+"'";
		return getByHql(hql);
	}

}
