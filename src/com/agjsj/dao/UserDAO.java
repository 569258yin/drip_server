package com.agjsj.dao;

import com.agjsj.entity.User;

/**
 * 用户业务类
 * @author yh
 *
 */
public interface UserDAO {
	/**
	 * 登录校验
	 * @param loginName	登录名
	 * @param loginPwd	密码
	 * @return 用户对象
	 */
	public Object validateLogin(String loginName,String loginPwd);
	
	/**
	 * 验证用户名是否存在
	 * @param loginName	用户名
	 * @return
	 */
	public boolean validateRegister(String loginName);
	
	/**
	 * 用户注册
	 * @param obj	用户对象
	 * @return	布尔类型
	 */
	public boolean register(Object obj);
	
	/**
	 * 修改密码
	 * @return
	 */
	public int updateUserPsw(Integer user_id,String user_psw_old,String user_psw_new);
	
	/**
	 * 修改个人信息
	 * @param user_id
	 * @param user
	 * @return
	 */
	public boolean updateUser(Integer user_id,User user);
	
	/**
	 * 获取用户的用户名和头像
	 * @return
	 */
	public String[] getUserNameAndIcon(Integer user_id);
	
	
}
