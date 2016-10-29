package com.agjsj.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.entity.Validata;
import com.agjsj.util.DateUtil;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;

public class ValidateServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 公共操作
		 */
		String json_str ="";
		json_str = HttpUtil.getDateStream(request);				//获取二进制流对象

		JSONObject root_object = JSONObject.fromObject(json_str);		//获取全部json数据
		String phone = root_object.getString("userPhone");		//获取json中的状态码
		/**
		 * 发送验证码信息到服务商，并保存验证码
		 */
		boolean bool = sendValidataNumber(phone);
		String json_date = "";
		if (bool) {
			json_date = JsonAbstactDate.createPubicJson("", "获取验证码成功！", 1);
		}else{
			json_date = JsonAbstactDate.createPubicJson("", "获取验证码失败", 0);
		}
		HttpUtil.sendDateStream(json_date, response);
	}

	
	/**
	 * 向服务商发送验证码
	 * @return
	 */
	private boolean sendValidataNumber(String phonenumber) {
		String number = createNumber();
//		System.out.println(number);
		String message = "【点滴生活】：感谢你使用公司的服务，你的验证码为"+number+"，验证码5分钟有效，请不要告诉他人哦！";
		boolean bool = true;
		long time = 60 * 60 *5;
		if (bool) {
			Validata validata = new Validata(number, new Date().getTime() + time);
			Application.validateMap.put(phonenumber, validata);
			System.out.println(validata);
			return true;
		}
		return false;
	}
	/**
	 * 生成验证码
	 * @return
	 */
	private String createNumber(){
		Integer i = (int)(100000 + Math.random() * 999999);
		return i.toString();
	}


	public void init() throws ServletException {
	}

}
