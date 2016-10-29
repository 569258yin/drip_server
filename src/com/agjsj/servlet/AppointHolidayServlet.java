package com.agjsj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.AppointHolidayBiz;
import com.agjsj.biz.AppointHplidayBizImpl;
import com.agjsj.entity.Appointholiday;
import com.agjsj.entity.Holiday;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonAppointHolidayUtil;
import com.agjsj.util.JsonDateInter;
import com.agjsj.util.JsonHolidayUtil;

public class AppointHolidayServlet extends HttpServlet {


	private final static int SUCCESS = 1;
	private final static int ERROR = 0;
	private final static int EXIST = -1;
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
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

		/**
		 * 预约旅游
		 */

		if ("60001".equals(requestCode)) {

			String user_id = root_object.getString("user_id");
			String holidayId = root_object.getString("holidayId");
			JsonAppointHolidayUtil jsonAppointHolidayUtil = new JsonAppointHolidayUtil();
			Appointholiday appointholiday = jsonAppointHolidayUtil
					.getAppointHolidayFromJSONObject(root_object);
			String validateCode = appointholiday.getAppointholidayNumcard();
			String phonenumber = appointholiday.getAppointholidayPhone();
			String json_date = null;
			if (validateCode.equals(Application.validateMap.get(phonenumber).getNumber())
					&& !Application.validateMap.get(phonenumber).isIsuse()) {
				Application.validateMap.get(phonenumber).setIsuse(true);
				AppointHolidayBiz appointHolidayBiz = new AppointHplidayBizImpl();
				int tag = appointHolidayBiz.sendAppointHoliday(appointholiday,
						Integer.parseInt(user_id), Integer.parseInt(holidayId));

				if (tag == 1) {
					json_date = JsonAbstactDate.createPubicJson(requestCode,
							"预约旅游成功", SUCCESS);
				} else if(tag == 0) {
					json_date = JsonAbstactDate.createPubicJson(requestCode,
							"预约旅游失败", ERROR);
				}else if(tag == -1){
					json_date = JsonAbstactDate.createPubicJson(requestCode,
							"预约旅游存在", EXIST);
				}
			}
			json_date = JsonAbstactDate.createPubicJson(requestCode,
					"验证码不正确", -2);
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 获取所有预约信息
		 */

		if ("60002".equals(requestCode)) {

			String user_id = root_object.getString("user_id");
			AppointHolidayBiz appoHolidayBiz = new AppointHplidayBizImpl();
			List<Holiday> list = appoHolidayBiz.getAppointHoliday(Integer.parseInt(user_id));
			JsonDateInter holidayUtil = new JsonHolidayUtil();
			String json_date = holidayUtil.createHolidayListJson(list);
			HttpUtil.sendDateStream(json_date, response);
		}
		/**
		 * 删除某条我预约的度假
		 */

		if ("60003".equals(requestCode)) {

			String user_id = root_object.getString("user_id");
			String holidayId = root_object.getString("holidayId");
			AppointHolidayBiz appointHolidayBiz = new AppointHplidayBizImpl();
			boolean tag = appointHolidayBiz.deleteAppointHoliday(
					Integer.parseInt(user_id), Integer.parseInt(holidayId));
			JsonAppointHolidayUtil jsonAppointHolidayUtil = new JsonAppointHolidayUtil();
			String json_date = null;
			if (tag) {
				json_date = jsonAppointHolidayUtil.createPubicJson(requestCode,
						"删除旅游成功", 1);
			} else {
				json_date = jsonAppointHolidayUtil.createPubicJson(requestCode,
						"删除旅游失败", 0);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

	}

	public void init() throws ServletException {
	}

}
