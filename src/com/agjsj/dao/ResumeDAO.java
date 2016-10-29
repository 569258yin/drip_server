package com.agjsj.dao;

import com.agjsj.entity.Resume;

/**
 * 简历功能接口
 * @author yh
 *
 */
public interface ResumeDAO {
	
	/**
	 * 上传简历
	 * 
	 * @param resume
	 *            简历对象
	 * @userId userId 用户ID
	 * @return true 上传成功 false 上传失败
	 */
	public boolean sendResume(Resume resume);
	
	/**
	 * 到服务器取简历内容
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public Resume getResume(Integer userId);

	/**
	 * 删除我的简历
	 * 
	 * @param userId
	 * @return
	 */
	public boolean deleteMyResume(Integer userId);
	
	/**
	 * 修改我的简历
	 * @param userId	用户名
	 * @return		bool类型
	 */
	public boolean updateResume(Resume resume,Integer userId);
}
