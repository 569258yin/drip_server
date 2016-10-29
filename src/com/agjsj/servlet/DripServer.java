package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.util.HttpUtil;

public class DripServer extends HttpServlet {
	
	//用户有关的服务
	private static final String USER_SERVER = "1000";
	//简历有关的服务
	private static final String RESUME_SERVER = "2000";
	//兼职招聘有关的服务
	private static final String JOB_SERVER = "3000";
	//预约兼职
	private static final String APPOINT_JOB_SERVER = "4000";
	//度假旅游
	private static final String HOLIDAY_SERVER = "5000";
	//预约度假信息
	private static final String APPOINT_HOLIDAY_SERVER = "6000";
	//教育培训服务
	private static final String TRAIN_SERVER = "7000";
	//预约教育培训服务
	private static final String APPOINT_TRAIN_SERVER = "8000";
	//神吐槽服务
	private static final String TALK_SERVER = "9000";
	//个人开团
	private static final String PERSONTUAN_SERVER = "A000";
	//预约个人开团
	private static final String APPOINTTUAN_SERVER = "B000";
	
	/**
	 * 服务器总路径.判断请求转发 到哪一个servlet<br>
	 */
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		String json_str = HttpUtil.getRootDateStream(request);				//获取二进制流对象
		JSONObject root_object = JSONObject.fromObject(json_str);		//获取全部json数据
		String requestCode = root_object.getString("requestCode");		//获取json中的状态码
		StringBuilder builder = new StringBuilder(requestCode);
		requestCode = builder.substring(0, 4);
		System.out.println(requestCode);
		
		switch (requestCode) {
		case USER_SERVER:
			url = "/servlet/UserServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case RESUME_SERVER:
			url = "/servlet/ResumeServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case JOB_SERVER:
			url = "/servlet/JobServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case APPOINT_JOB_SERVER:
			url = "/servlet/AppointJobServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case HOLIDAY_SERVER:
			url = "/servlet/HolidayServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case APPOINT_HOLIDAY_SERVER:
			url = "/servlet/AppointHolidayServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case TRAIN_SERVER:
			url = "/servlet/TrainServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case APPOINT_TRAIN_SERVER:
			url = "/servlet/AppointTrainServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case TALK_SERVER:
			url = "/servlet/TalkServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		case PERSONTUAN_SERVER:
			url = "/servlet/PersonTuanServlet";
			System.out.println(url);
//			response.sendRedirect(url);
			request.getRequestDispatcher(url).forward(request, response);
			System.out.println(url);
			break;
		case APPOINTTUAN_SERVER:
			url = "/servlet/AppointTuanServlet";
			request.getRequestDispatcher(url).forward(request, response);
			break;
		default:
			break;
		}
	}

	public void init() throws ServletException {
	}

}
