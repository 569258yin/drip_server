package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Trainreplay;

public class TrainreplayDAOImpl extends BaseHibernateDAO implements TrainreplayDAO{

	@Override
	public boolean addTrainReplay(Trainreplay trainReplay) {
		// TODO Auto-generated method stub
		return this.add(trainReplay);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trainreplay> getAllTrainReplay(Integer trainId, Integer count,
			Integer start) {
		return this.getPageListByQBC(count, start, Trainreplay.class, "trainreplayTime", "trainId", trainId);
	}

}
