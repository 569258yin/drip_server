package com.agjsj.biz;

import com.agjsj.dao.UserDAO;
import com.agjsj.dao.UserDAOImpl;
import com.agjsj.entity.User;

/*
 * 业务逻辑实现类
 */

public class UserBizImpl implements UserBiz{

	@Override
	public Object checkLogin(String loginName, String loginPwd) {
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.validateLogin(loginName, loginPwd);
	}
	
	
	@Override
	public boolean checkRegister(String loginName) {
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.validateRegister(loginName);
	}

	@Override
	public boolean register(User obj) {
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.register(obj);
	}


	@Override
	public int updateUserPsw(Integer user_id, String user_psw_old,
			String user_psw_new) {
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.updateUserPsw(user_id, user_psw_old, user_psw_new);
	}


	@Override
	public boolean updateUser(Integer user_id, User user) {
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.updateUser(user_id, user);
	}


	@Override
	public String[] getUserNameAndIcon(Integer user_id) {
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.getUserNameAndIcon(user_id);
	}
	

}
