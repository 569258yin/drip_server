package com.agjsj.biz;

import com.agjsj.entity.Resume;

public interface ResumeBiz {
	/**
	 * 上传我的简历
	 * @param resume	resume对象
	 * @return			bool类型
	 */
	public boolean registerResume(Resume resume);
	
	/**
	 * 获取我的简历
	 * @param userId	用户ID
	 * @return	resume对象
	 */
	public Resume getResumeByUserId(Integer userId);
	
	/**
	 * 删除我的个人简历
	 * @param userId	用户Id
	 * @return			bool类型
	 */
	public boolean deleteResumeByUserId(Integer userId);
	
	/**
	 * 删除我的简历	
	 * @param resume	resume对象
	 * @return	返回bool类型
	 */
	public boolean updateResumeByUserId(Resume resume,Integer userId);
}
