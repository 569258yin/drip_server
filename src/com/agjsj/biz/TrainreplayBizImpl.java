package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.TrainreplayDAO;
import com.agjsj.dao.TrainreplayDAOImpl;
import com.agjsj.entity.Trainreplay;

public class TrainreplayBizImpl implements TrainreplayBiz{

	@Override
	public boolean addTrainReplay(Trainreplay trainReplay) {
		TrainreplayDAO trainreplayDAO = new TrainreplayDAOImpl();
		return trainreplayDAO.addTrainReplay(trainReplay);
	}

	@Override
	public List<Trainreplay> getAllTrainReplay(Integer trainId, Integer count,
			Integer start) {
		TrainreplayDAO trainreplayDAO = new TrainreplayDAOImpl();
		return trainreplayDAO.getAllTrainReplay(trainId, count, start);
	}

}
