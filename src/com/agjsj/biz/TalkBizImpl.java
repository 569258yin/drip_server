package com.agjsj.biz;

import java.util.List;

import com.agjsj.dao.TalkDAO;
import com.agjsj.dao.TalkDAOImpl;
import com.agjsj.entity.Talk;

public class TalkBizImpl implements TalkBiz {

	@Override
	public int sendTalk(Talk talk, Integer user_id) {
		TalkDAO talkDAO = new TalkDAOImpl();
		return talkDAO.sendTalk(talk, user_id);
	}

	@Override
	public List<Talk> getPublicAllTalk(Integer count, Integer start) {
		TalkDAO talkDAO = new TalkDAOImpl();
		return talkDAO.getPublicAllTalk(count, start);
	}

	@Override
	public void addNumZan(Integer talkId) {
		TalkDAO talkDAO = new TalkDAOImpl();
		talkDAO.addNumZan(talkId);

	}

	@Override
	public void addNumZa(Integer talkId) {
		TalkDAO talkDAO = new TalkDAOImpl();

		talkDAO.addNumZa(talkId);
	}

	@Override
	public void addNumReplay(Integer talkId) {
		TalkDAO talkDAO = new TalkDAOImpl();
		talkDAO.addNumReplay(talkId);
	}

}
