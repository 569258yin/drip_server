package com.agjsj.dao;

import com.agjsj.entity.User;


public class UserDAOImpl extends BaseHibernateDAO implements UserDAO{

	
	//		String hql = "from Books books where books.title=:bookTitle ";
	@Override
	public boolean validateRegister(String loginName) {
		String hql = "from User user where user.userName ='"+loginName +"'";
		return super.isExistByHql(hql);
	}

	@Override
	public Object validateLogin(String loginName, String loginPwd) {
		String hql = "from User user where user.userName ='"+loginName+"'"
				+" AND user.userPsw ='"+loginPwd+"'";
		if (this.getByHql(hql).size() > 0) {
			return this.getByHql(hql).get(0);
		}
		return null;
	}

	@Override
	public boolean register(Object obj) {
		return this.add(obj);
	}

	@Override
	public int updateUserPsw(Integer user_id, String user_psw_old,
			String user_psw_new) {
		boolean bool = false;
		int tag = 0;
		//判断用户旧密码是否登录成功
		String hql = "from User user where user.userId ='"+user_id+"'"
				+" AND user.userPsw ='"+user_psw_old+"'";
		bool = this.isExistByHql(hql);
		if (bool) {
			String updateHql = "update User user set user.userPsw='"+user_psw_new
					+"' where user.userId='"+user_id+"'";
			bool = this.updateOrDeleteByHql(updateHql);
			if (bool) {
				tag = 1;
			}else{
				tag = 0;
			}
		}else{
			tag = -1;
		}
		return tag;
	}

	@Override
	public boolean updateUser(Integer user_id, User user) {
		boolean bool = false;
		if(user_id != null && user != null){
			bool = this.updateBaseUser(user_id, user);
		}else{
			return false;
		}
//		bool = this.delete(this.get(User.class, user_id));
//		if (bool) {
//			user.setUserId(user_id);
//			bool = this.add(user);
//		}
		return bool;
	}

	@Override
	public String[] getUserNameAndIcon(Integer user_id) {
		String[] str = new String[2];
		User user = (User) this.get(User.class, user_id);
		str[0] = user.getUserName();
		str[1] = user.getUserIcon();
		return str;
	}


}
