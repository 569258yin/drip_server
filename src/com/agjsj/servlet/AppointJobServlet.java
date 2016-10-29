package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.AppointJobBiz;
import com.agjsj.biz.AppointJobBizImpl;
import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Job;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonAppointJobUtil;
import com.agjsj.util.JsonDateInter;

public class AppointJobServlet extends HttpServlet {

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
		 * 预约招聘
		 */
		if ("40001".equals(requestCode)) {
			String user_id = root_object.getString("user_id");
			String jobId = root_object.getString("jobId");

			JsonAppointJobUtil jsonAppointJobUtil = new JsonAppointJobUtil();
			Appointjob appointjob = jsonAppointJobUtil
					.getAppointJobfromJSONObject(root_object);
			String validateCode = appointjob.getAppointjobNumcard();
			String phonenumber = appointjob.getAppointjobPhone();
			String json_date = null;
			if (validateCode.equals(Application.validateMap.get(phonenumber).getNumber())
					&& !Application.validateMap.get(phonenumber).isIsuse()) {
				Application.validateMap.get(phonenumber).setIsuse(true);
				AppointJobBiz appointJobBiz = new AppointJobBizImpl();
				int tag = appointJobBiz.sendAppointJob(appointjob,
						Integer.parseInt(user_id), Integer.parseInt(jobId));
				if (tag == 1) {
					json_date = JsonAbstactDate.createPubicJson(requestCode,
							"预约工作成功", SUCCESS);
				} else if(tag == 0) {
					json_date = JsonAbstactDate.createPubicJson(requestCode,
							"预约工作失败", ERROR);
				}else if(tag == -1){
					json_date = JsonAbstactDate.createPubicJson(requestCode,
							"预约工作存在", EXIST);
				}
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "验证码不正确", -2);
			}

			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 获取预约结果
		 */

		if ("40002".equals(requestCode)) {
			String user_id = root_object.getString("user_id");

			AppointJobBiz appointJobBiz = new AppointJobBizImpl();
			List<Job> list = appointJobBiz.getAppointJob(Integer
					.parseInt(user_id));

			JsonDateInter jobUtil = new JsonAppointJobUtil();
			String json_date = jobUtil.createJobListJson(list);
			HttpUtil.sendDateStream(json_date, response);
		}
		/**
		 * 删除我预约的兼职
		 */

		if ("40003".equals(requestCode)) {
			String user_id = root_object.getString("user_id");
			String jobId = root_object.getString("jobId");

			AppointJobBiz appointJobBiz = new AppointJobBizImpl();
			boolean Tag = appointJobBiz.deleteAppointJob(
					Integer.parseInt(user_id), Integer.parseInt(jobId));

			String json_date = null;
			if (Tag) {
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"删除成功", 1);
			} else {
				json_date = JsonAbstactDate.createPubicJson(requestCode,
						"删除失败", 0);

			}
			HttpUtil.sendDateStream(json_date, response);
		}

	}


	public void init() throws ServletException {

	}

}
