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
import com.agjsj.entity.Appointtrain;
import com.agjsj.entity.Train;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonAppointTrainUtil;
import com.agjsj.util.JsonDateInter;

public class AppointTrainServlet extends HttpServlet {

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
			String validateCode = appointtrain.getAppointtrainNumcard();
			String phonenumber = appointtrain.getAppointtrainPhone();
			String json_date = null;
			if (validateCode.equals(Application.validateMap.get(phonenumber).getNumber())
					&& !Application.validateMap.get(phonenumber).isIsuse()) {
				Application.validateMap.get(phonenumber).setIsuse(true);
				AppointTrainBiz appointtrainBiz = new AppointTrainBizImpl();
				int tag = appointtrainBiz
						.sendAppointTrain(appointtrain, Integer.parseInt(user_id), Integer.parseInt(trainId));
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
			}
			else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "验证码不正确", -2);
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
	public void init() throws ServletException {
	}

}
