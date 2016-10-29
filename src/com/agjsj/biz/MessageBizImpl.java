package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.MessageDAO;
import com.agjsj.dao.MessageDAOImpl;
import com.agjsj.entity.Message;

public class MessageBizImpl implements MessageBiz{

	@Override
	public boolean sendMessage(Message message) {
		MessageDAO messageDAO = new MessageDAOImpl();
		return messageDAO.sendMessage(message);
	}

	@Override
	public List<Message> getSystemMessage() {
		MessageDAO messageDAO = new MessageDAOImpl();
		return messageDAO.getSystemMessage();
	}

	@Override
	public List<Message> getPersonMessage(Integer user_id) {
		MessageDAO messageDAO = new MessageDAOImpl();
		return messageDAO.getPersonMessage(user_id);
	}

}
