package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.AppointTuanBiz;
import com.agjsj.biz.AppointTuanBizImpl;
import com.agjsj.biz.PersonTuanBiz;
import com.agjsj.biz.PersonTuanBizImpl;
import com.agjsj.entity.Appointtuan;
import com.agjsj.entity.Persontuan;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAppointTuanUtil;
import com.agjsj.util.JsonPersonTuanUtil;

public class PersonTuanServlet extends HttpServlet {

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
		 * 添加开团
		 */
		if ("A0001".equals(requestCode)) {

			String user_id = root_object.getString("user_id");

			JsonPersonTuanUtil jsonPersonTuanUtil = new JsonPersonTuanUtil();
			Persontuan persontuan = jsonPersonTuanUtil
					.getPersonTuanFromJson(root_object);

			PersonTuanBiz personTuanBiz = new PersonTuanBizImpl();

			boolean tag = personTuanBiz.sendPersonTuan(persontuan,
					Integer.parseInt(user_id));

			String json_date = null;
			if (tag) {
				json_date = jsonPersonTuanUtil.createPubicJson(requestCode,
						"开团成功", SUCCESS);
			} else {
				json_date = jsonPersonTuanUtil.createPubicJson(requestCode,
						"开团失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 添加评论
		 */
		if ("A0002".equals(requestCode)) {

			String user_id = root_object.getString("user_id");

			JsonPersonTuanUtil jsonPersonTuanUtil = new JsonPersonTuanUtil();

			PersonTuanBiz personTuanBiz = new PersonTuanBizImpl();

			List<Persontuan> list = personTuanBiz.getPersonAllTuan(Integer
					.parseInt(user_id));

			String json_date = jsonPersonTuanUtil.getListPersonTuanToJson(list);

			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 获取所有个人团信息
		 */
		if ("A0003".equals(requestCode)) {

			String start = root_object.getString("start");
			String count = root_object.getString("count");

			JsonPersonTuanUtil jsonPersonTuanUtil = new JsonPersonTuanUtil();

			PersonTuanBiz personTuanBiz = new PersonTuanBizImpl();

			List<Persontuan> list = personTuanBiz.getPublicAllTuan(
					Integer.parseInt(count), Integer.parseInt(start));

			String json_date = jsonPersonTuanUtil.getListPersonTuanToJson(list);

			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 修改个人发布的某条跟团信息
		 */
		if ("A0004".equals(requestCode)) {

			int user_id = root_object.getInt("user_id");
			int persontuanId = root_object.getInt("persontuanId");

			JsonPersonTuanUtil jsonPersonTuanUtil = new JsonPersonTuanUtil();

			Persontuan persontuan = jsonPersonTuanUtil
					.getPersonTuanFromJson(root_object);

			PersonTuanBiz personTuanBiz = new PersonTuanBizImpl();

			boolean tag = personTuanBiz.updatePersonTuan(persontuanId, user_id,
					persontuan);

			String json_date = null;
			if (tag) {
				json_date = jsonPersonTuanUtil.createPubicJson(requestCode,
						"修改成功", SUCCESS);
			} else {
				json_date = jsonPersonTuanUtil.createPubicJson(requestCode,
						"修改失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);

		}

		/**
		 * 删除我发布的某条跟团招聘信息
		 */
		if ("A0005".equals(requestCode)) {

			int user_id = root_object.getInt("user_id");
			int persontuanId = root_object.getInt("persontuanId");

			JsonPersonTuanUtil jsonPersonTuanUtil = new JsonPersonTuanUtil();

			PersonTuanBiz personTuanBiz = new PersonTuanBizImpl();

			boolean tag = personTuanBiz.deletePersonTuan(persontuanId, user_id);

			String json_date = null;
			if (tag) {
				json_date = jsonPersonTuanUtil.createPubicJson(requestCode,
						"删除成功", SUCCESS);
			} else {
				json_date = jsonPersonTuanUtil.createPubicJson(requestCode,
						"删除失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);

		}
		
		/**
		 * 预约个人团
		 */
		if ("B0001".equals(requestCode)) {
			int user_id = Integer.parseInt(root_object.getString("user_id"));
			int persontuanId = Integer.parseInt(root_object.getString("persontuanId"));

			JsonAppointTuanUtil jsonAppointTuanUtil = new JsonAppointTuanUtil();

			Appointtuan appointtuan = jsonAppointTuanUtil
					.getAppointTuanFromJson(root_object);

			AppointTuanBiz appointTuanBiz = new AppointTuanBizImpl();

			int tag = appointTuanBiz.sendAppointTuan(appointtuan, user_id,
					persontuanId);

			String json_date = null;
			if (tag == 1) {
				json_date = jsonAppointTuanUtil.createPubicJson(requestCode,
						"预约成功", SUCCESS);
			} else if(tag == 0){
				json_date = jsonAppointTuanUtil.createPubicJson(requestCode,
						"预约失败", ERROR);
			}else if (tag == -1) {
				json_date = jsonAppointTuanUtil.createPubicJson(requestCode,
						"预约存在", EXIST);
			}
			HttpUtil.sendDateStream(json_date, response);
			System.out.println("Sendstart");
		}

		/**
		 * 获取预约的 个人团
		 */
		if ("B0002".equals(requestCode)) {
			int user_id = root_object.getInt("user_id");
			AppointTuanBiz appointTuanBiz = new AppointTuanBizImpl();
			List<Persontuan> list = appointTuanBiz.getAppointTuan(user_id);
			System.out.println(list.toString());
			JsonPersonTuanUtil jsonPersonTuanUtil = new JsonPersonTuanUtil();
			String json_date = jsonPersonTuanUtil.getListPersonTuanToJson(list);
			HttpUtil.sendDateStream(json_date, response);

		}

		/**
		 * 删除我预约的个人团
		 */
		if ("B0003".equals(requestCode)) {

			int user_id = root_object.getInt("user_id");
			int persontuanId = root_object.getInt("persontuanId");

			AppointTuanBiz appointTuanBiz = new AppointTuanBizImpl();

			boolean tag = appointTuanBiz.deleteAppointTuan(user_id,
					persontuanId);

			JsonAppointTuanUtil jsonAppointTuanUtil = new JsonAppointTuanUtil();
			String json_date = null;
			if (tag) {
				json_date = jsonAppointTuanUtil.createPubicJson(requestCode,
						"删除成功", SUCCESS);
			} else {
				json_date = jsonAppointTuanUtil.createPubicJson(requestCode,
						"删除失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
