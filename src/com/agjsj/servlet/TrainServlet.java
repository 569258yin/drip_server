package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.AppointTrainBiz;
import com.agjsj.biz.AppointTrainBizImpl;
import com.agjsj.biz.TrainBiz;
import com.agjsj.biz.TrainBizImpl;
import com.agjsj.entity.Appointtrain;
import com.agjsj.entity.Train;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonAppointTrainUtil;
import com.agjsj.util.JsonDateInter;
import com.agjsj.util.JsonJobUtil;
import com.agjsj.util.JsonTrainUtil;

public class TrainServlet extends HttpServlet {

	private final static int SUCCESS = 1;
	private final static int ERROR = 0;
	private final static int EXIST = -1;
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
		
		/*
		 * 1.发布教育培训信息（70001）
		 */
		if("70001".equals(requestCode)){
			//获取user_id
			String user_id = root_object.getString("user_id");

			//获取train对象 
			JsonDateInter  trainUtil = new JsonTrainUtil();
			Train train = trainUtil.getTrainJson(root_object);


			TrainBiz trainBiz = new TrainBizImpl();
			int tag= trainBiz.sendTrain(train, Integer.parseInt(user_id));

			String json_date;
			if (tag > 0) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "发布成功", tag);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "发布失败", tag);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 2.获取个人发布教育培训的所有信息（50002）
		 */
		if("70002".equals(requestCode)){
			//获取user_id
			String user_id = root_object.getString("user_id");

			TrainBiz trainBiz = new TrainBizImpl();
			List<Train> list= trainBiz.getPersonAllTrain(Integer.parseInt(user_id));


			String json_date;
			JsonDateInter jsonTrainUtils = new JsonTrainUtil();
			json_date = jsonTrainUtils.createTrainListJson(list);
			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 3.获取所有发布教育培训的信息（50003）
		 */
		if ("70003".equals(requestCode)) {

			//获取一次获取多少条信息count
			//获取起始位置start
			int count = root_object.getInt("count");
			int start = root_object.getInt("start");

			//获取教育培训信息放到list集合中
			TrainBiz trainBizImpl = new TrainBizImpl();			
			List<Train> list = trainBizImpl.getPublicAllTrain(count, start);
			//封装json发送
			String json_date;
			JsonDateInter jsonTrainUtil = new JsonTrainUtil();
			json_date = jsonTrainUtil.createTrainListJson(list);

			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 4.修改个人发布的教育培训的信息（70004）
		 */
		if ("70004".equals(requestCode)) {    
			String trainId = root_object.getString("trainId");
			String user_id = root_object.getString("user_id");

			JsonDateInter trainUtil = new JsonTrainUtil();
			Train train = trainUtil.getTrainJson(root_object);

			TrainBiz trainBiz = new TrainBizImpl();
			boolean bool = trainBiz.updateTrain(Integer.parseInt(trainId), Integer.parseInt(user_id), train);

			String json_date;
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "修改成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "修改失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 删除我发布的某条培训度假信息
		 */
		if ("70005".equals(requestCode)) {
			String jobId = root_object.getString("trainId");
			String user_id = root_object.getString("user_id");
			boolean bool;
			TrainBiz trainBiz = new TrainBizImpl();
			bool = trainBiz.deleteTrain(Integer.parseInt(jobId),Integer.parseInt(user_id));
			String json_date;
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "删除成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "删除失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		
		/**
		 * 预约教育培训
		 */
		if ("80001".equals(requestCode)) {
			/*
			 * 无用  ，重构可以舍弃
			 */
			String user_id = root_object.getString("user_id");
			String trainId = root_object.getString("trainId");

			JsonDateInter appointTrainUtil = new JsonAppointTrainUtil();
			Appointtrain appointtrain = appointTrainUtil
					.getAppointTrainFromJSONObject(root_object);
			AppointTrainBiz appointtrainBiz = new AppointTrainBizImpl();
			int tag = appointtrainBiz
					.sendAppointTrain(appointtrain, Integer.parseInt(user_id), Integer.parseInt(trainId));
			String json_date = null;
			if (tag == 1) {
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"预约培训成功", SUCCESS);
			}else if(tag == 0) {
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"预约培训失败", ERROR);
			}else if(tag == -1){
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"预约培训存在", EXIST);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/*
		 * 获取我预约的培训信息
		 */
		if ("80002".equals(requestCode)) {
			String user_id = root_object.getString("user_id");
			AppointTrainBiz appointtrainBiz = new AppointTrainBizImpl();
			List<Train> list = appointtrainBiz.getAppointTrain(Integer.parseInt(user_id));
			JsonDateInter jsonAppointTrainUtil = new JsonAppointTrainUtil();
			String json_date = jsonAppointTrainUtil.getListAppointTrainJson(list);
			HttpUtil.sendDateStream(json_date, response);
		}

		if ("80003".equals(requestCode)) {
			String user_id = root_object.getString("user_id");
			String holidayId = root_object.getString("trainId");
			AppointTrainBiz appointtrainBiz = new AppointTrainBizImpl();
			boolean tag = appointtrainBiz.deleteAppointTrain(
					Integer.parseInt(user_id), Integer.parseInt(holidayId));
			String json_date = null;
			if (tag) {
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"删除培训成功", SUCCESS);
			} else {
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"删除培训失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
