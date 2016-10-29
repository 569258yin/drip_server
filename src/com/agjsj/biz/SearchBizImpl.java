package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.SearchDAOImpl;
import com.agjsj.dao.SerachDAO;
import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;

public class SearchBizImpl implements SearchBiz{

	@Override
	public List<Job> serchJob(String str) {
		SerachDAO serachDAO = new SearchDAOImpl();
		return serachDAO.serchJob(str);
	}

	@Override
	public List<Holiday> serchHoliday(String str) {
		SerachDAO serachDAO = new SearchDAOImpl();
		return serachDAO.serchHoliday(str);
	}

	@Override
	public List<Train> searchTrain(String str) {
		SerachDAO serachDAO = new SearchDAOImpl();
		return serachDAO.searchTrain(str);
	}
	
}
