package com.agjsj.biz;

import com.agjsj.entity.User;


/*
 * 业务层
 */
public interface UserBiz {
	/**
	 * //校验登录
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public Object checkLogin(String loginName,String loginPwd);
	/**
	 * //校验注册用户名是否重复
	 * @param loginName
	 * @return
	 */
	
	public boolean checkRegister(String loginName);

	/**
	 * 注册
	 * @param obj
	 * @return
	 */
	public boolean register(User obj);
	/**
	 * 修改密码
	 * @param user_id
	 * @param user_psw_old
	 * @param user_psw_new
	 * @return
	 */
	public int updateUserPsw(Integer user_id,String user_psw_old,String user_psw_new);
	
	public boolean updateUser(Integer user_id,User user);
	
	public String[] getUserNameAndIcon(Integer user_id);
}
