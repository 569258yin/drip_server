package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.JobreplayBiz;
import com.agjsj.biz.JobreplayBizImpl;
import com.agjsj.biz.TrainreplayBiz;
import com.agjsj.biz.TrainreplayBizImpl;
import com.agjsj.entity.Jobreplay;
import com.agjsj.entity.Trainreplay;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonReplayUtil;

public class TrainReplayServlet extends HttpServlet {

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
		
		//---------------------------------------------------------------
		if (requestCode.equals("K0001")) {
			Trainreplay trainReplay = JsonReplayUtil.getTrainReplayFromJson(root_object);
			TrainreplayBiz trainreplayBiz = new TrainreplayBizImpl();
			boolean tag = trainreplayBiz.addTrainReplay(trainReplay);
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
		
		if(requestCode.equals("K0002")){
			Integer trainId = Integer.parseInt(root_object.getString("trainId"));
			Integer count = Integer.parseInt(root_object.getString("count"));
			Integer start = Integer.parseInt(root_object.getString("start"));
			TrainreplayBiz trainreplayBiz1 = new TrainreplayBizImpl();
			List<Trainreplay> list = trainreplayBiz1.getAllTrainReplay(trainId, count, start);
			String json_date2 = JsonReplayUtil.createListTrainRepalyJson(list);
			HttpUtil.sendDateStream(json_date2, response);
		}
	}

	public void init() throws ServletException {
	}

}
