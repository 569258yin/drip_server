package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.biz.CollectBiz;
import com.agjsj.biz.CollectBizImpl;
import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonDateInter;
import com.agjsj.util.JsonHolidayUtil;
import com.agjsj.util.JsonJobUtil;
import com.agjsj.util.JsonTrainUtil;

public class CollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static int SUCCESS = 1;
	private final static int ERROR = 0;
	private final static int EXIST = -1;
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings("unchecked")
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
		 * 添加收藏
		 */
		if (requestCode.equals("C0001")) {
			boolean bool = false;
			String json_date;
			String user_id = root_object.getString("user_id");
			String tag = root_object.getString("Tag");
			String id = root_object.getString("id");
			CollectBiz collectBiz = new CollectBizImpl();
			bool = collectBiz.addCollect(Integer.parseInt(user_id)
					, Integer.parseInt(tag),Integer.parseInt(id));
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "添加收藏成功", 1);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "添加收藏失败", 0);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 获取收藏
		 */
		if (requestCode.equals("C0002")) {
			String json_date = null;
			int user_id = Integer.parseInt(root_object.getString("user_id"));
			int tag = Integer.parseInt(root_object.getString("Tag"));
//			int id = Integer.parseInt(root_object.getString("id"));
			CollectBiz collectBiz = new CollectBizImpl();
			List<Object> lists = collectBiz.getCollect(user_id, tag);
			if (lists != null) {
				if (tag == 1) {
					List<Job> jobList = new ArrayList<Job>();
					for (Object list : lists) {
						jobList.add((Job) list);
					}
					JsonDateInter jobUtil = new JsonJobUtil();
					json_date = jobUtil.createJobListJson(jobList);
				} else if (tag == 2) {
					List<Holiday> holidayList = new ArrayList<Holiday>();
					for (Object list : lists) {
						holidayList.add((Holiday) list);
					}
					JsonDateInter holidayUtil = new JsonHolidayUtil();
					json_date = holidayUtil.createHolidayListJson(holidayList);
				} else if (tag == 3) {
					List<Train> trainList = new ArrayList<Train>();
					for (Object list : lists) {
						trainList.add((Train) list);
					}
					JsonDateInter trainUtil = new JsonTrainUtil();
					json_date = trainUtil.createTrainListJson(trainList);
				}
			}else{
				JSONObject jsonObject = new JSONObject();
				JSONArray jsonArray = new JSONArray();
				jsonObject.put("Tag", "0");
				jsonObject.put("list", jsonArray);
				json_date = jsonObject.toString();
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		/*
		 * 删除收藏
		 */
		if (requestCode.equals("C0003")) {
			boolean bool = false;
			String json_date;
			int user_id = Integer.parseInt(root_object.getString("user_id"));
			int collectId = Integer.parseInt(root_object.getString("collectId"));
			int tag = Integer.parseInt(root_object.getString("tag"));
			CollectBiz collectBiz = new CollectBizImpl();
			bool = collectBiz.deleteCollect(user_id, collectId,tag);
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "删除收藏成功", 1);
			}else{
				json_date = JsonAbstactDate.createPubicJson(requestCode, "删除收藏失败", 0);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		
	}
	public void init() throws ServletException {
	}

}
