package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Talk;
import com.agjsj.entity.Train;

public class TalkDAOImpl extends BaseHibernateDAO implements TalkDAO{

	@Override
	public int sendTalk(Talk talk, Integer user_id) {
		Talk mytalk = (Talk) this.addObject(talk);
		if (mytalk != null) {
			System.out.println(mytalk.getTalkId());
			return mytalk.getTalkId();
		}
		return  0;
	}

	/**
	 * 按发布时间降序排列
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Talk> getPublicAllTalk(Integer count, Integer start) {
//		String hql = "from Talk";
//		String hql = "from Talk as talk order by talk.talkTime DESC,talk.talkId DESC";
//		return this.getPageList(count, start, hql);
		return this.getPageListByQBC(count, start, Talk.class, "talkTime");
	}

//	String updateHql = "update User user set user.userPsw='"+user_psw_new
//			+"' where user.userId='"+user_id+"'";
	@Override
	public void addNumZan(Integer talkId) {
		Talk talk = (Talk) this.get(Talk.class, talkId);
		int zan = talk.getTalkNumzan();
		zan = zan + 1;
		String hql = "update Talk talk set talk.talkNumzan='"+zan
				+"' where talk.talkId='"+talkId+"'";
		this.updateOrDeleteByHql(hql);
		
	}

	@Override
	public void addNumZa(Integer talkId) {
		Talk talk = (Talk) this.get(Talk.class, talkId);
		int za = talk.getTalkNumza();
		za = za + 1;
		String hql = "update Talk talk set talk.talkNumza='"+za
				+"' where talk.talkId='"+talkId+"'";
		this.updateOrDeleteByHql(hql);
		
	}

	@Override
	public void addNumReplay(Integer talkId) {
		Talk talk = (Talk) this.get(Talk.class, talkId);
		int zan = talk.getTalkNumreply();
		zan = zan + 1;
		String hql = "update Talk talk set talk.talkNumreply='"+zan
				+"' where talk.talkId='"+talkId+"'";
		this.updateOrDeleteByHql(hql);
		
	}

}
