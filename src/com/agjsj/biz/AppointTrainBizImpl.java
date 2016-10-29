package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.AppointTrainDAO;
import com.agjsj.dao.AppointTrainDAOImpl;
import com.agjsj.entity.Appointtrain;
import com.agjsj.entity.Train;

public class AppointTrainBizImpl implements AppointTrainBiz {


	@Override
	public int sendAppointTrain(Appointtrain appointTrain, Integer user_id,
			Integer trainId) {
		AppointTrainDAO appointTrainDAO = new AppointTrainDAOImpl();
		return appointTrainDAO.sendAppointTrain(appointTrain, user_id, trainId);
	}

	@Override
	public List<Train> getAppointTrain(Integer user_id) {
		AppointTrainDAO appointTrainDAO = new AppointTrainDAOImpl();
		return appointTrainDAO.getAppointTrain(user_id);
	}

	@Override
	public boolean deleteAppointTrain(Integer user_id, Integer trainId) {
		AppointTrainDAO appointTrainDAO = new AppointTrainDAOImpl();
		return appointTrainDAO.deleteAppointTrain(user_id, trainId);
	}

}
