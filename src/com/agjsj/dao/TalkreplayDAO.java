package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Talkreplay;

public interface TalkreplayDAO {
	
	/**
	 * 添加评论		
	 * @param talkReplay  不需要ID
	 * @return
	 */
	public boolean addTalkReplay(Talkreplay talkReplay);
	
	public List<Talkreplay> getAllTalkReplay(Integer talkId,Integer count,Integer start);
}
