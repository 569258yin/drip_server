package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.JobreplayDAO;
import com.agjsj.dao.JobreplayDAOImpl;
import com.agjsj.entity.Jobreplay;

public class JobreplayBizImpl implements JobreplayBiz{

	@Override
	public boolean addJobReplay(Jobreplay jobReplay) {
		JobreplayDAO jobreplayDAO = new JobreplayDAOImpl();
		return jobreplayDAO.addJobReplay(jobReplay);
	}

	@Override
	public List<Jobreplay> getAllJobReplay(Integer jobId, Integer count,
			Integer start) {
		JobreplayDAO jobreplayDAO = new JobreplayDAOImpl();
		return jobreplayDAO.getAllJobReplay(jobId, count, start);
	}

}
