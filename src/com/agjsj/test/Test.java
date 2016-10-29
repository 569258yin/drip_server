package com.agjsj.test;

import com.agjsj.biz.UserBiz;
import com.agjsj.biz.UserBizImpl;
import com.agjsj.entity.User;

public class Test {

	private boolean register() {
		User user = new User();
		user.setUserName("lisi");
		user.setUserPsw("123456");
		user.setUserSex(2);
		user.setUserPhone("18314447865");
		UserBiz userBiz = new UserBizImpl();
		return userBiz.register(user);
	}
	
	private boolean checkRegister() {
		UserBiz userBiz = new UserBizImpl();
		return userBiz.checkRegister("zhangsan");
	}
	private Object checkLogin() {
		UserBiz userBiz = new UserBizImpl();
		return userBiz.checkLogin("lisi", "123456");
	}
	public static void main(String[] args) {
		User user = (User) new Test().checkLogin();
		System.out.println(user.getUserName()+":"+user.getUserPsw());
	}

}
