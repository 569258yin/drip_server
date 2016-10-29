package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Jobreplay;

public class JobreplayDAOImpl extends BaseHibernateDAO implements JobreplayDAO{

	@Override
	public boolean addJobReplay(Jobreplay jobReplay) {
		return this.add(jobReplay);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jobreplay> getAllJobReplay(Integer jobId, Integer count,
			Integer start) {
		return this.getPageListByQBC(count, start, Jobreplay.class, "jobreplayTime"
				,"jobId",jobId);
	}



}
