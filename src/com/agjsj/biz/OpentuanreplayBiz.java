package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Jobreplay;
import com.agjsj.entity.Optuanreplay;

public interface OpentuanreplayBiz {
	/**
	 * 添加评论		
	 * @param talkReplay  不需要ID
	 * @return
	 */
	public boolean addOpentuanReplay(Optuanreplay optuanreplay);
	
	/**
	 * 获取所有的评论
	 * @param talkId
	 * @param count
	 * @param start
	 * @return
	 */
	public List<Optuanreplay> getAllOpentuanReplay(Integer opentuanId,Integer count,Integer start);
}
