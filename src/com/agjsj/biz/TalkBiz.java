package com.agjsj.biz;

import java.util.List;

import com.agjsj.entity.Talk;

public interface TalkBiz {

	/**
	 * 发布神吐槽
	 * 
	 * @param talk
	 *            吐槽对象
	 * @param user_id
	 * @return
	 */
	public int sendTalk(Talk talk, Integer user_id);

	/**
	 * 分页获取加载所有的吐槽内容
	 * 
	 * @param count
	 * @param start
	 * @return
	 */
	public List<Talk> getPublicAllTalk(Integer count, Integer start);

	/**
	 * 赞
	 * 
	 * @param talkId
	 */
	public void addNumZan(Integer talkId);

	/**
	 * 砸
	 * 
	 * @param talkId
	 */
	public void addNumZa(Integer talkId);

	/**
	 * 评论数
	 * 
	 * @param talkId
	 */
	public void addNumReplay(Integer talkId);
}
