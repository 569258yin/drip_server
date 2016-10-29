package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Talkreplay;

public class TalkreplayDAOImpl extends BaseHibernateDAO implements TalkreplayDAO{

	@Override
	public boolean addTalkReplay(Talkreplay talkReplay) {
		TalkDAO talkDAO = new TalkDAOImpl();
		talkDAO.addNumReplay(talkReplay.getTalkId());
		return this.add(talkReplay);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Talkreplay> getAllTalkReplay(Integer talkId, Integer count,
			Integer start) {
//		String hql = "from Talkreplay talkReplay where talkReplay.talkId ='"+talkId+"'";
//		return this.getPageList(count, start, hql);
		return this.getPageListByQBC(count, start, Talkreplay.class, "talkreplayTime"
				,"talkId",talkId);
	}

}
