package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.TalkreplayDAO;
import com.agjsj.dao.TalkreplayDAOImpl;
import com.agjsj.entity.Talkreplay;

public class TalkreplayBizImpl implements TalkreplayBiz {

	@Override
	public boolean addTalkReplay(Talkreplay talkReplay) {
		TalkreplayDAO talkreplayDAO = new TalkreplayDAOImpl();
		return talkreplayDAO.addTalkReplay(talkReplay);
	}

	@Override
	public List<Talkreplay> getAllTalkReplay(Integer talkId, Integer count,
			Integer start) {
		TalkreplayDAO talkreplayDAO = new TalkreplayDAOImpl();
		return talkreplayDAO.getAllTalkReplay(talkId, count, start);
	}

}
