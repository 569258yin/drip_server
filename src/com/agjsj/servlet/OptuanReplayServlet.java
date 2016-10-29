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
import com.agjsj.biz.JobreplayBiz;
import com.agjsj.biz.JobreplayBizImpl;
import com.agjsj.biz.OpentuanreplayBiz;
import com.agjsj.biz.OpentuanreplayBizImpl;
import com.agjsj.entity.Holidayreplay;
import com.agjsj.entity.Jobreplay;
import com.agjsj.entity.Optuanreplay;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonReplayUtil;

public class OptuanReplayServlet extends HttpServlet {

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
		
		//---------------------------------------------------------------
		if (requestCode.equals("L0001")) {
			Optuanreplay optuanreplay = JsonReplayUtil.getOptuanReplayFromJson(root_object);
			OpentuanreplayBiz biz = new OpentuanreplayBizImpl();
			boolean tag = biz.addOpentuanReplay(optuanreplay);
			String json_date1 = null;
			if (tag) {
				json_date1 = JsonAbstactDate.createPubicJson(requestCode, "评论成功成功",
						1);
			} else {
				json_date1 = JsonAbstactDate
						.createPubicJson(requestCode, "评论失败", 0);
			}
			HttpUtil.sendDateStream(json_date1, response);
		}
		
		if(requestCode.equals("L0002")){
			Integer opentuanId;
			Integer count;
			Integer start;
			String json_date2 = "";
			try {
				opentuanId = Integer.parseInt(root_object.getString("opentuanId"));
				count = Integer.parseInt(root_object.getString("count"));
				start = Integer.parseInt(root_object.getString("start"));
				OpentuanreplayBiz biz = new OpentuanreplayBizImpl();
				List<Optuanreplay> list = biz.getAllOpentuanReplay(opentuanId, count, start);
				json_date2 = JsonReplayUtil.createListOptuanRepalyJson(list);
			} catch (NumberFormatException e) {
				json_date2 = JsonAbstactDate.createPubicJson(requestCode, "评论失败", 0);
				e.printStackTrace();
			}
			HttpUtil.sendDateStream(json_date2, response);
		}


	}
	public void init() throws ServletException {
		// Put your code here
	}

}
