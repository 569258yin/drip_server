package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.JobreplayDAO;
import com.agjsj.dao.JobreplayDAOImpl;
import com.agjsj.dao.OpentuanreplayDAO;
import com.agjsj.dao.OptuanreplayDAOImpl;
import com.agjsj.entity.Jobreplay;
import com.agjsj.entity.Optuanreplay;

public class OpentuanreplayBizImpl implements OpentuanreplayBiz{

	@Override
	public boolean addOpentuanReplay(Optuanreplay optuanreplay) {
		OpentuanreplayDAO dao = new OptuanreplayDAOImpl();
		return dao.addOptuanReplay(optuanreplay);
	}

	@Override
	public List<Optuanreplay> getAllOpentuanReplay(Integer opentuanId,
			Integer count, Integer start) {
		OpentuanreplayDAO dao = new OptuanreplayDAOImpl();
		return dao.getAllOptuanReplay(opentuanId, count, start);
	}

}
