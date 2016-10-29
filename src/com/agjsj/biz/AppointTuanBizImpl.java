package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.AppointTuanDAO;
import com.agjsj.dao.AppointTuanDAOImpl;
import com.agjsj.entity.Appointtuan;
import com.agjsj.entity.Persontuan;

public class AppointTuanBizImpl implements AppointTuanBiz {

	@Override
	public int sendAppointTuan(Appointtuan appointtuan, Integer user_id,
			Integer persontuanId) {
		AppointTuanDAO appointTuanDAO = new AppointTuanDAOImpl();
		return appointTuanDAO.sendAppointTuan(appointtuan, user_id,
				persontuanId);

	}

	@Override
	public List<Persontuan> getAppointTuan(Integer user_id) {
		AppointTuanDAO appointTuanDAO = new AppointTuanDAOImpl();
		return appointTuanDAO.getAppointTuan(user_id);
	}

	@Override
	public boolean deleteAppointTuan(Integer user_id, Integer persontuanId) {
		AppointTuanDAO appointTuanDAO = new AppointTuanDAOImpl();
		return appointTuanDAO.deleteAppointTuan(user_id, persontuanId);
	}

}
