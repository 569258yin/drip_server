package com.agjsj.biz;

import java.util.List;

public interface CollectBiz {
	/**
	 * 向数据库中添加我的收藏
	 * @param user_id	收藏用户
	 * @param tag		标志是要收藏的哪种的信息
	 * @param id		要收藏的id
	 * @return			
	 */
	public boolean addCollect(Integer user_id,Integer tag,Integer id);
	
	/**
	 * 获取我的收藏
	 * @param user_id	用户
	 * @param tag     标志
	 * @return
	 */
	public List<Object> getCollect(Integer user_id,Integer tag);
	
	/**
	 * 删除我的收藏
	 * @param user_id
	 * @param tag
	 * @param id
	 * @return
	 */
	public boolean deleteCollect(Integer user_id,Integer collectId,Integer tag);
	
}
