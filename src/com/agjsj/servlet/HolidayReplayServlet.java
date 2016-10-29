package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.HolidayreplayBiz;
import com.agjsj.biz.HolidayreplayBizImpl;
import com.agjsj.entity.Holidayreplay;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonHolidayUtil;
import com.agjsj.util.JsonReplayUtil;

public class HolidayReplayServlet extends HttpServlet {

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

		String json_str = HttpUtil.getDateStream(request);				//获取二进制流对象
		JSONObject root_object = JSONObject.fromObject(json_str);		//获取全部json数据
		String requestCode = root_object.getString("requestCode");		//获取json中的状态码

		System.out.println(requestCode);
		
		switch (requestCode) {
		case "F0001":
			Holidayreplay holidayReplay = JsonReplayUtil.getHolidaReplayFromJson(root_object);
			HolidayreplayBiz holidayreplayBiz = new HolidayreplayBizImpl();
			boolean tag = holidayreplayBiz.addHolidayReplay(holidayReplay);
			String json_date1 = null;
			if (tag) {
				json_date1 = JsonAbstactDate.createPubicJson(requestCode, "评论成功成功",
						1);
			} else {
				json_date1 = JsonAbstactDate
						.createPubicJson(requestCode, "评论失败", 0);
			}
			HttpUtil.sendDateStream(json_date1, response);
			break;
			
		case "F0002":
			Integer holidayId = Integer.parseInt(root_object.getString("holidayId"));
			Integer count = Integer.parseInt(root_object.getString("count"));
			Integer start = Integer.parseInt(root_object.getString("start"));
			HolidayreplayBiz holidayreplayBiz1 = new HolidayreplayBizImpl();
			List<Holidayreplay> list = holidayreplayBiz1.getAllHolidayReplay(holidayId, count, start);
			String json_date2 = JsonReplayUtil.createListHolidayRepalyJson(list);
			HttpUtil.sendDateStream(json_date2, response);
			break;
		default:
			break;
		}

	}

	public void init() throws ServletException {
	}

}
