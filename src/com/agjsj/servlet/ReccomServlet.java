package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.ReccomBiz;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonReccomUtil;

public class ReccomServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static int SUCCESS = 1;
	private final static int ERROR = 0;
	private final static int EXIST = -1;
	
	public void destroy() {
		super.destroy(); 
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

		Application.path = request.getSession().getServletContext().getRealPath("/image");
		String json_str = HttpUtil.getDateStream(request);				//获取二进制流对象
		JSONObject root_object = JSONObject.fromObject(json_str);		//获取全部json数据
		String requestCode = root_object.getString("requestCode");		//获取json中的状态码
		System.out.println(requestCode);
		
		if (requestCode.equals("D0001")) {
			JsonReccomUtil recommUtil = new JsonReccomUtil();
			String json_date = recommUtil.createListReccomJson();
			HttpUtil.sendDateStream(json_date, response);
		}
		
	}

	public void init() throws ServletException {
	}

}
