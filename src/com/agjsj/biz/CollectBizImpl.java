package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.CollectDAO;
import com.agjsj.dao.CollectDAOImpl;

public class CollectBizImpl implements CollectBiz{

	@Override
	public boolean addCollect(Integer user_id, Integer tag, Integer id) {
		CollectDAO collectDAO = new CollectDAOImpl();
		return collectDAO.addCollect(user_id, tag, id);
	}

	@Override
	public List<Object> getCollect(Integer user_id, Integer tag) {
		CollectDAO collectDAO = new CollectDAOImpl();
		return collectDAO.getCollectJob(user_id, tag);
	}

	@Override
	public boolean deleteCollect(Integer user_id,Integer collectId,Integer tag) {
		CollectDAO collectDAO = new CollectDAOImpl();
		return collectDAO.deleteCollect(user_id,collectId,tag);
	}

}
