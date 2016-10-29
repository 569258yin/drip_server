package com.agjsj.servlet;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.UserBiz;
import com.agjsj.biz.UserBizImpl;
import com.agjsj.entity.User;
import com.agjsj.util.HttpImageUtil;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonDateInter;
import com.agjsj.util.JsonUserUtil;



public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int SUCCESS = 1;
	private final static int ERROR = 0;
	private final static int EXIST = -1;
	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
//		Application.path = request.getSession().getServletContext().getRealPath("/image");
		Application.path = request.getContextPath()+"/image/";
	}
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 公共操作
		 */
		String json_str ="";
		json_str = HttpUtil.getDateStream(request);				//获取二进制流对象

		JSONObject root_object = JSONObject.fromObject(json_str);		//获取全部json数据
		String requestCode = root_object.getString("requestCode");		//获取json中的状态码
		System.out.println(requestCode);
		//-----------------------------------------------------------------------------------------	

		//		Cookie cookie = new Cookie("Cookie", request.getSession().toString());
		//		cookie.setMaxAge(3600*1000*7);
		//		response.addCookie(cookie);

		//		Cookie[] cookies = request.getCookies();
		//		Cookie findC;
		//		for (Cookie cookie2 : cookies) {
		//			if(cookie2.getName().equals("")){
		//				findC = cookie2;
		//			}
		//		}
		/*
		 * 注册 
		 */
		if (requestCode.equals("10001")) {
			boolean bool = false;
			boolean check = false;
			
			String json_date = "";
			JsonDateInter userUtil = new JsonUserUtil();
			User user = userUtil.getUserJson(root_object);
			user.setUserCode(root_object.getString("userCode"));
			String validateCode = user.getUserCode();
			String phonenumber = user.getUserPhone();
			System.out.println("手机发送验证码："+validateCode+"手机号："+phonenumber);
			System.out.println("服务器存储验证码："+Application.validateMap.get(phonenumber).getNumber());
			if (validateCode.equals(Application.validateMap.get(phonenumber).getNumber())
					&& !Application.validateMap.get(phonenumber).isIsuse()) {
				Application.validateMap.get(phonenumber).setIsuse(true);
				UserBiz userBiz = new UserBizImpl();
				String loginName = user.getUserName();
				check = userBiz.checkRegister(loginName);
				if (check) {			//用户名存在
					json_date = JsonAbstactDate.createPubicJson(requestCode, "用户名已经存在", EXIST);
					HttpUtil.sendDateStream(json_date, response);
					return;					//返回
				}
				bool = userBiz.register(user);
				if (bool) {
					json_date = JsonAbstactDate.createPubicJson(requestCode, "注册成功", SUCCESS);	
				}else{
					json_date = JsonAbstactDate.createPubicJson(requestCode, "注册失败", ERROR);	
				}
				
			}else{
			json_date = JsonAbstactDate.createPubicJson(requestCode, "验证码不正确", -2);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 登录校验
		 */
		if (requestCode.equals("10002")) {
			User user = null;
			JsonDateInter userUtil = new JsonUserUtil();
			UserBiz userBiz = new UserBizImpl();
			String loginName = root_object.getString("userName");
			String loginPwd = root_object.getString("userPsw");
			String newValus = null;
			String json_date = "";
			//登录标示
			String UUID = root_object.getString("UUID");
//			System.out.println(Application.userMap.toString());
			if (UUID.equals("0")) {
				//生成根据用户名的唯一标示
				newValus = HttpImageUtil.makeTokenName(loginName);
//				System.out.println("newValus:"+newValus);
				user = (User) userBiz.checkLogin(loginName, loginPwd);
				if (user != null) {
					Application.userMap.put(loginName, newValus);
					user.setUUID(newValus);
					json_date = userUtil.createUserJson(requestCode,user,SUCCESS);
				}else{
					json_date = JsonAbstactDate.createPubicJson(requestCode,"登录错误", ERROR);
				}
			}else{
//				System.out.println("UUID:"+UUID);
				
//				System.out.println(loginName);
				String localValue = Application.userMap.get(loginName);
//				System.out.println(localValue);
				if (localValue != null && UUID.equals(localValue)) {
//					System.out.println("已经登录");
					json_date = JsonAbstactDate.createPubicJson(requestCode,"已经登录", 2);
				}else{
//					System.out.println("登录cuowu");
					json_date = JsonAbstactDate.createPubicJson(requestCode,"登录错误", -1);
				}
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/*
		 * 修改密码
		 */
		if (requestCode.equals("10003")) {
			String json_date = null;
			String user_id = root_object.getString("user_id");
			String userName = root_object.getString("userName");
			String user_psw_old = root_object.getString("user_psw_old");
			String user_psw_new = root_object.getString("user_psw_new");
			UserBiz userBiz = new UserBizImpl();
			int tag = userBiz.updateUserPsw(Integer.parseInt(user_id), user_psw_old, user_psw_new);
			if (tag < 0 ) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "密码验证失败", tag);
			}else if(tag == 0){
				json_date = JsonAbstactDate.createPubicJson(requestCode, "更新密码错误", tag);
			}else if (tag == 1) {
				if (Application.userMap.containsKey(userName)) {
					Application.userMap.remove(userName);
				}
				json_date =	JsonAbstactDate.createPubicJson(requestCode, "注销成功", 1);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/*
		 * 修改个人信息
		 */
		if (requestCode.equals("10004")) {
			String json_date;
			boolean bool=false;
			String user_id = root_object.getString("user_id");
			JsonDateInter userUtil = new JsonUserUtil();
			User user = userUtil.getUserJson(root_object);
			UserBiz userBiz = new UserBizImpl();
			bool = userBiz.updateUser(Integer.parseInt(user_id), user);
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson("10004", "修改个人信息成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson("10004", "修改个人信息失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 注销个人登录的账号
		 */
		if (requestCode.equals("10005")) {
			String json_date ;
			String userName = root_object.getString("userName");
			if (Application.userMap.containsKey(userName)) {
				Application.userMap.remove(userName);
				json_date =	JsonAbstactDate.createPubicJson(requestCode, "注销成功", 1);
			}else{
				json_date =	JsonAbstactDate.createPubicJson(requestCode, "你未登录", 0);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

	}

	public void init() throws ServletException {
	}


}
