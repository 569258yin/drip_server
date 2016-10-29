package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Talkreplay;

public interface TalkreplayBiz {
	/**
	 * 添加评论
	 * 
	 * @param talkReplay
	 *            不需要ID
	 * @return
	 */
	public boolean addTalkReplay(Talkreplay talkReplay);
	
	/**
	 * 分页获取指定的id下的所有评论
	 * @param talkId
	 * @param count
	 * @param start
	 * @return
	 */
	public List<Talkreplay> getAllTalkReplay(Integer talkId, Integer count,
			Integer start);
}
