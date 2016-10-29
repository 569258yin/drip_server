package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.MessageBiz;
import com.agjsj.biz.MessageBizImpl;
import com.agjsj.entity.Message;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonMessageUtil;

public class MessageServlet extends HttpServlet {

	/**
	 * 
	 */
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
		String json_str = HttpUtil.getDateStream(request);				//获取二进制流对象
		JSONObject root_object = JSONObject.fromObject(json_str);		//获取全部json数据
		String requestCode = root_object.getString("requestCode");		//获取json中的状态码
		System.out.println(requestCode);
		
		//-----------------------------------------------
//		if (requestCode.equals("E0001")) {
//			int userSendId = Integer.parseInt(root_object.getString("userSendId"));
//			int userReceiveId = Integer.parseInt(root_object.getString("userReceiveId"));
//			String messageContext = root_object.getString("messageContext");
//			
//			
//			
//		}
		if (requestCode.equals("E0002")) {
			MessageBiz messageBiz = new MessageBizImpl();
			List<Message> list = messageBiz.getSystemMessage();
			HttpUtil.sendDateStream(JsonMessageUtil.getListToJson(list), response);
		}
		if (request.equals("E0003")) {
			int user_id = Integer.parseInt(root_object.getString("user_id"));
			MessageBiz messageBiz = new MessageBizImpl();
			List<Message> list = messageBiz.getPersonMessage(user_id);
			HttpUtil.sendDateStream(JsonMessageUtil.getListToJson(list), response);
		}
	}

	public void init() throws ServletException {
	}

}
