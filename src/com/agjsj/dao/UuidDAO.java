package com.agjsj.dao;

import java.util.List;

import com.agjsj.entity.Uuid;

/**
 * 保存登录转态，放置服务器突然停机造成的用户登陆错误
 * @author yh
 *
 */
public interface UuidDAO {
	/**
	 * 保存
	 * @param uuid
	 */
	public void saveUUid(Uuid uuid);
	/**
	 * 删除表中所有信息
	 */
	public void deleteUUid();
	
	/**
	 * 获取所有的uuid
	 * @return
	 */
	public List<Uuid> getUuid();
	
}
