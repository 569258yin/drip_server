package com.agjsj.biz;

import com.agjsj.dao.ImageDAO;
import com.agjsj.dao.ImageDAOImpl;

public class ImageBizImpl implements ImageBiz{

	@Override
	public boolean addUserIcon(String url, Integer id) {
		ImageDAO imageDAO = new ImageDAOImpl();
		return imageDAO.addUserIcon(url, id);
	}

	@Override
	public boolean addJobIcon(String url, Integer id) {
		ImageDAO imageDAO = new ImageDAOImpl();	// TODO Auto-generated method stub
		return imageDAO.addJobIcon(url, id);
	}

	@Override
	public boolean addHolidayIcon(String url, Integer id) {
		ImageDAO imageDAO = new ImageDAOImpl();
		return imageDAO.addHolidayIcon(url, id);
	}

	@Override
	public boolean addTrainIcon(String url, Integer id) {
		ImageDAO imageDAO = new ImageDAOImpl();
		return imageDAO.addTrainIcon(url, id);
	}

	@Override
	public boolean addTalkIcon(String url, Integer id) {
		ImageDAO imageDAO = new ImageDAOImpl();
		return imageDAO.addTalkIcon(url, id);
	}

}
