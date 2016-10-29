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
import com.agjsj.biz.JobBiz;
import com.agjsj.biz.JobBizImpl;
import com.agjsj.entity.Appointjob;
import com.agjsj.entity.Job;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonAppointJobUtil;
import com.agjsj.util.JsonDateInter;
import com.agjsj.util.JsonJobUtil;

public class JobServlet extends HttpServlet {

	private final static int SUCCESS = 1;
	private final static int ERROR = 0;
	private final static int EXIST = -1;
	public void destroy() {
		super.destroy();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


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
		 * 发布兼职
		 */
		if ("30001".equals(requestCode)) {

			String user_id = root_object.getString("user_id");

			JsonDateInter jsonJobUtil = new JsonJobUtil();
			Job job = jsonJobUtil.getJobJson(root_object);
			JobBiz jobBizImpl = new JobBizImpl();
			int tag = jobBizImpl.sendJob(job, Integer.parseInt(user_id));
			String json_date;
			if (tag > 0) {
				json_date = JsonAbstactDate.createPubicJson("30001", "发布兼职招聘成功",
						tag);
			} else {
				json_date = JsonAbstactDate.createPubicJson("30001", "发布兼职招聘失败",
						tag);
			}

			HttpUtil.sendDateStream(json_date, response);
		}	

		/*
		 * 获取我自己发布的所有兼职
		 */
		if ("30002".equals(requestCode)) {

			String user_id = root_object.getString("user_id");

			JobBiz jobBizImpl = new JobBizImpl();
			List<Job> list = jobBizImpl.getPersonAllJob(Integer
					.parseInt(user_id));

			JsonJobUtil jsonJobUtil = new JsonJobUtil();
			String json_date = jsonJobUtil.createJobListJson(list);

			HttpUtil.sendDateStream(json_date, response);
		}

		/*
		 * 获取平台发布的所有兼职
		 */
		if ("30003".equals(requestCode)) {

			//获取一次获取多少条信息count
			//获取起始位置start
			int count = root_object.getInt("count");
			int start = root_object.getInt("start");

			//获取兼职信息放到list集合中
			JobBiz jobBizImpl = new JobBizImpl();			
			List<Job> list = jobBizImpl.getPublicAllJob(count,start);
			//
			String json_date;
			JsonDateInter jsonJobUtil = new JsonJobUtil();
			json_date = jsonJobUtil.createJobListJson(list);
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 修改我发布的兼职
		 */
		if ("30004".equals(requestCode)) {
			String jobId = root_object.getString("jobId");
			String user_id = root_object.getString("user_id");
			JsonDateInter jobUtil = new JsonJobUtil();
			Job job = jobUtil.getJobJson(root_object);
			JobBiz jobBiz = new JobBizImpl();
			boolean bool = jobBiz.updateJob(Integer.parseInt(jobId), Integer.parseInt(user_id), job);
			String json_date;
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "修改成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "修改失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 删除我发布的某条兼职
		 */
		if ("30005".equals(requestCode)) {
			String jobId = root_object.getString("jobId");
			String user_id = root_object.getString("user_id");
			boolean bool;
			JobBiz jobBiz = new JobBizImpl();
			bool = jobBiz.deleteJob(Integer.parseInt(jobId),Integer.parseInt(user_id));
			String json_date;
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "删除成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "删除失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}



		/**
		 * 预约招聘
		 */
		if ("40001".equals(requestCode)) {
			String user_id = root_object.getString("user_id");
			String jobId = root_object.getString("jobId");

			JsonAppointJobUtil jsonAppointJobUtil = new JsonAppointJobUtil();
			Appointjob appointjob = jsonAppointJobUtil
					.getAppointJobfromJSONObject(root_object);

			AppointJobBiz appointJobBiz = new AppointJobBizImpl();
			int tag = appointJobBiz.sendAppointJob(appointjob,
					Integer.parseInt(user_id), Integer.parseInt(jobId));
			String json_date = null;
			if (tag == 1) {
				json_date = jsonAppointJobUtil.createPubicJson(requestCode,
						"预约工作成功", SUCCESS);
			} else if(tag == 0) {
				json_date = jsonAppointJobUtil.createPubicJson(requestCode,
						"预约工作失败", ERROR);
			}else if(tag == -1){
				json_date = jsonAppointJobUtil.createPubicJson(requestCode,
						"预约工作存在", EXIST);
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
			String json_date = jobUtil.getListAppointJobJson(list);
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
				json_date = JsonAppointJobUtil.createPubicJson(requestCode,
						"删除成功", 1);
			} else {
				json_date = JsonAppointJobUtil.createPubicJson(requestCode,
						"删除失败", 0);

			}
			HttpUtil.sendDateStream(json_date, response);
		}
		
		/**
		 * 获取单个工作详情
		 */
		if ("40005".equals(requestCode)) {
			String jobId = root_object.getString("jobId");
			JobBiz jobBiz = new JobBizImpl();
			Job job = jobBiz.getJobById(Integer.parseInt(jobId));
			JsonJobUtil jobUtil = new JsonJobUtil();
			String json_date = jobUtil.getJobToJsonObject(job).toString();
			HttpUtil.sendDateStream(json_date, response);
		}

	}

	public void init() throws ServletException {
	}

}
