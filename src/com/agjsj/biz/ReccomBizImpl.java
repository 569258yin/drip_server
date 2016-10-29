package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.ReccomDAO;
import com.agjsj.dao.ReccomDAOImpl;
import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

public class ReccomBizImpl implements ReccomBiz{

	@Override
	public List<Job> getListJob() {
		ReccomDAO reccomDAO = new ReccomDAOImpl();
		return reccomDAO.getListJob();
	}

	@Override
	public List<Holiday> getListHoliday() {
		ReccomDAO reccomDAO = new ReccomDAOImpl();
		return reccomDAO.getListHoliday();
	}

	@Override
	public List<Train> getListTrain() {
		ReccomDAO reccomDAO = new ReccomDAOImpl();
		return reccomDAO.getListTrain();
	}

}
