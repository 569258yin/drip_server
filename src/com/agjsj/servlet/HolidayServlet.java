package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.AppointHolidayBiz;
import com.agjsj.biz.AppointHplidayBizImpl;
import com.agjsj.biz.HolidayBiz;
import com.agjsj.biz.HolidayBizImpl;
import com.agjsj.entity.Appointholiday;
import com.agjsj.entity.Holiday;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonAppointHolidayUtil;
import com.agjsj.util.JsonDateInter;
import com.agjsj.util.JsonHolidayUtil;
import com.agjsj.util.JsonJobUtil;

public class HolidayServlet extends HttpServlet {

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
		
		/*
		 * 1.发布旅游度假信息（50001）
		 */
		if("50001".equals(requestCode)){
			//获取user_id
			String user_id = root_object.getString("user_id");

			//获取holiday对象 
			JsonDateInter  holidayUtil = new JsonHolidayUtil();
			Holiday holiday = holidayUtil.getHolidayJson(root_object);


			HolidayBiz holidayBiz = new HolidayBizImpl();
			int tag= holidayBiz.sendHoliday(Integer.parseInt(user_id), holiday);

			String json_date;
			if (tag > 0) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "发布成功", tag);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "发布失败", tag);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 2.获取个人发布旅游的所有信息（50002）
		 */
		if("50002".equals(requestCode)){
			//获取user_id
			String user_id = root_object.getString("user_id");

			HolidayBiz holidayBiz = new HolidayBizImpl();
			List<Holiday> list= holidayBiz.getPersonAllHoliday(Integer.parseInt(user_id));
			String json_date;
			JsonDateInter jsonHolidayUtils = new JsonAppointHolidayUtil();
			json_date = jsonHolidayUtils.getListAppointHolidayJson(list);
			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 3.获取所有发布旅游的信息（50003）
		 */
		if ("50003".equals(requestCode)) {

			//获取一次获取多少条信息count
			//获取起始位置start
			int count = root_object.getInt("count");
			int start = root_object.getInt("start");

			//获取度假旅游信息放到list集合中
			HolidayBiz holidayBizImpl = new HolidayBizImpl();			
			List<Holiday> list = holidayBizImpl.getPublicAllHoliday(count,start);
			//
			String json_date;
			JsonDateInter jsonHolidayUtil = new JsonHolidayUtil();
			json_date = jsonHolidayUtil.createHolidayListJson(list);

			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 4.修改个人发布的某条旅游的信息（50004）
		 */
		if ("50004".equals(requestCode)) {
			String holidayId = root_object.getString("holidayId");
			String user_id = root_object.getString("user_id");

			JsonDateInter holidayUtil = new JsonHolidayUtil();
			Holiday holiday = holidayUtil.getHolidayJson(root_object);

			HolidayBiz holidayBiz = new HolidayBizImpl();
			boolean bool = holidayBiz.updateHoliday(Integer.parseInt(holidayId), Integer.parseInt(user_id), holiday);

			String json_date;
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "修改成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "修改失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 删除我发布的某条旅游度假信息
		 */
		if ("50005".equals(requestCode)) {
			String jobId = root_object.getString("holidayId");
			String user_id = root_object.getString("user_id");
			boolean bool;
			HolidayBiz holidayBiz = new HolidayBizImpl();
			bool = holidayBiz.deleteHoliday(Integer.parseInt(jobId),Integer.parseInt(user_id));
			String json_date;
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "删除成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "删除失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		
		/**
		 * 预约旅游
		 */

		if ("60001".equals(requestCode)) {

			String user_id = root_object.getString("user_id");
			String holidayId = root_object.getString("holidayId");
			JsonAppointHolidayUtil jsonAppointHolidayUtil = new JsonAppointHolidayUtil();
			Appointholiday appointholiday = jsonAppointHolidayUtil
					.getAppointHolidayFromJSONObject(root_object);
			AppointHolidayBiz appointHolidayBiz = new AppointHplidayBizImpl();
			int tag = appointHolidayBiz.sendAppointHoliday(appointholiday,
					Integer.parseInt(user_id), Integer.parseInt(holidayId));

			String json_date = null;
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
			String json_date = null;
			if (tag) {
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"删除旅游成功", 1);
			} else {
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"删除旅游失败", 0);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
