package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.ResumeBiz;
import com.agjsj.biz.ResumeBizImpl;
import com.agjsj.entity.Resume;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonDateInter;
import com.agjsj.util.JsonResumeUtil;
/**
 * 简历服务器
 * @author yh
 *
 */
public class ResumeServlet extends HttpServlet {

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
		 * 简历
		 */
		/*
		 * 发布简历
		 */
		if (requestCode.equals("20001")) {
			boolean bool = false;
			String json_date;
			JsonDateInter resumeUtil = new JsonResumeUtil();
			//将json字符串解析成对象
			Resume resume = resumeUtil.getResumeJson(root_object);
			ResumeBiz resumeBiz = new ResumeBizImpl();
			//调用业务逻辑层
			bool = resumeBiz.registerResume(resume);
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson("20001", "上传成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson("20001", "上传失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);

		}
		/*
		 * 获取简历
		 */
		if (requestCode.equals("20002")) {
			Resume resume = null;
			String json_date;
			String user_id = root_object.getString("user_id");
			ResumeBiz resumeBiz = new ResumeBizImpl();
			JsonDateInter resumeUtil = new JsonResumeUtil();
			resume = resumeBiz.getResumeByUserId(Integer.parseInt(user_id));
			if (resume == null) {
				json_date = JsonAbstactDate.createPubicJson("20002", "获取简历失败", ERROR);
			}else{
				json_date = resumeUtil.createResumeJson("20002", resume, SUCCESS);
			}
			HttpUtil.sendDateStream(json_date, response); 
		}
		/*
		 * 删除简历
		 */
		if (requestCode.equals("20003")) {
			String json_date;
			boolean bool = false;
			String user_id = root_object.getString("user_id");
			ResumeBiz resumeBiz = new ResumeBizImpl();
			bool = resumeBiz.deleteResumeByUserId(Integer.parseInt(user_id));
			if (bool) {
				json_date = JsonAbstactDate.createPubicJson("20003", "删除简历成功", SUCCESS);
			}else{
				json_date = JsonAbstactDate.createPubicJson("20003", "删除简历失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/*
		 * 修改简历
		 */
		//		if (requestCode.equals("20004")) {
		//			String json_date;
		//			boolean bool = false;
		//			JsonDateInter resumeUtil = new JsonResumeUtil();
		//			Resume resume = resumeUtil.getResumeJson(root_object);
		//			String userId = root_object.getString("user_id");
		//			ResumeBiz resumeBiz = new ResumeBizImpl();
		//			bool = resumeBiz.updateResumeByUserId(resume,Integer.parseInt(userId));
		//			if (bool) {
		//				json_date = resumeUtil.createPubicJson("20004", "修改信息成功", SUCCESS);
		//			}else{
		//				json_date = resumeUtil.createPubicJson("20004", "修改信息失败", ERROR);
		//			}
		//		}

	}

	
	public void init() throws ServletException {
		
	}

}
