package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.TrainDAO;
import com.agjsj.dao.TrainDAOImpl;
import com.agjsj.entity.Train;

public class TrainBizImpl implements TrainBiz{

	@Override
	public int sendTrain(Train train, Integer user_id) {
			TrainDAO trainDAO = new TrainDAOImpl();
			return trainDAO.sendTrain(train, user_id);
	}

	@Override
	public List<Train> getPersonAllTrain(Integer user_id) {
		TrainDAO trainDAO = new TrainDAOImpl();
		
		return trainDAO.getPersonAllTrain(user_id);
	}

	@Override
	public List<Train> getPublicAllTrain(Integer count, Integer start) {
		TrainDAO trainDAO = new TrainDAOImpl();
		return trainDAO.getPublicAllTrain(count, start);
	}

	@Override
	public boolean updateTrain(Integer trainId, Integer user_id, Train train) {

		TrainDAO trainDAO = new TrainDAOImpl();
		return trainDAO.updateTrain(trainId, user_id, train);
	}

	@Override
	public boolean deleteTrain(Integer trainId, Integer user_id) {
		TrainDAO trainDAO = new TrainDAOImpl();
		return trainDAO.deleteTrain(trainId, user_id);
	}

	
}
