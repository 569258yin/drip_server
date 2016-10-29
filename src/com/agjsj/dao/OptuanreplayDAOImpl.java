package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Optuanreplay;

public class OptuanreplayDAOImpl extends BaseHibernateDAO implements OpentuanreplayDAO{


	@SuppressWarnings("unchecked")
	@Override
	public List<Optuanreplay> getAllOptuanReplay(Integer opentuanId, Integer count,
			Integer start) {
		return this.getPageListByQBC(count, start, Optuanreplay.class, "optuanreplayTime"
				,"opentuanId",opentuanId);
	}

	@Override
	public boolean addOptuanReplay(Optuanreplay optuanreplay) {
		return this.add(optuanreplay);
	}



}
