package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.TalkBiz;
import com.agjsj.biz.TalkBizImpl;
import com.agjsj.biz.TalkreplayBiz;
import com.agjsj.biz.TalkreplayBizImpl;
import com.agjsj.entity.Talk;
import com.agjsj.entity.Talkreplay;
import com.agjsj.util.HttpUtil;
import com.agjsj.util.JsonAbstactDate;
import com.agjsj.util.JsonTalkUtil;

public class TalkServlet extends HttpServlet {

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
		 * 发布神吐槽
		 */
		if ("90001".equals(requestCode)) {

			String user_id = root_object.getString("user_id");

			JsonTalkUtil jsonTalkUtil = new JsonTalkUtil();

			Talk talk = jsonTalkUtil.getTalkFromJson(root_object);

			TalkBiz talkBiz = new TalkBizImpl();
			int tag = talkBiz.sendTalk(talk, Integer.parseInt(user_id));

			String json_date = null;
			if (tag > 0) {
				json_date = jsonTalkUtil.createPubicJson(requestCode,
						"发布神吐槽成功", tag);
			} else {
				json_date = jsonTalkUtil.createPubicJson(requestCode,
						"发布神吐槽失败", tag);
			}
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 获取自己发布的神吐槽的所有信息
		 */
		if ("90002".equals(requestCode)) {
			int start = root_object.getInt("start");
			int count = root_object.getInt("count");
			TalkBiz talkBiz = new TalkBizImpl();
			List<Talk> list = talkBiz.getPublicAllTalk(count, start);
			JsonTalkUtil jsonTalkUtil = new JsonTalkUtil();
			String json_date = jsonTalkUtil.createListTalkJson(list);
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 点赞
		 */
		if ("90003".equals(requestCode)) {
			int talkId = root_object.getInt("talkId");
			TalkBiz talkBiz = new TalkBizImpl();
			talkBiz.addNumZan(talkId);
			String json_date = "0000000";
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 点砸
		 */
		if ("90004".equals(requestCode)) {
			int talkId = root_object.getInt("talkId");
			TalkBiz talkBiz = new TalkBizImpl();
			talkBiz.addNumZa(talkId);
			String json_date = "0000000";
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 评论数+1
		 */
		if ("90005".equals(requestCode)) {
			int talkId = root_object.getInt("talkId");
			TalkBiz talkBiz = new TalkBizImpl();
			talkBiz.addNumReplay(talkId);
			String json_date = "0000000";
			HttpUtil.sendDateStream(json_date, response);
		}

		/**
		 * 添加评论
		 */
		if ("90006".equals(requestCode)) {

			JsonTalkUtil jsonTalkUtil = new JsonTalkUtil();

			Talkreplay talkReplay = jsonTalkUtil
					.getTalkReplayFromJson(root_object);
			TalkreplayBiz talkreplayBiz = new TalkreplayBizImpl();
			boolean tag = talkreplayBiz.addTalkReplay(talkReplay);
			String json_date = null;
			if (tag) {
				json_date = JsonAbstactDate.createPubicJson(requestCode, "评论成功成功",
						SUCCESS);
			} else {
				json_date = JsonAbstactDate
						.createPubicJson(requestCode, "评论失败", ERROR);
			}
			HttpUtil.sendDateStream(json_date, response);
		}
		
		/**
		 * 获取当前吐槽下的评论数目
		 */
		if ("90007".equals(requestCode)) {
			int start = root_object.getInt("start");
			int count = root_object.getInt("count");
			int talkId = root_object.getInt("talkId");
			TalkreplayBiz replayBiz = new TalkreplayBizImpl();
			List<Talkreplay> list = replayBiz.getAllTalkReplay(talkId, count, start);
			System.out.println(list.toString());
			JsonTalkUtil jsonTalkUtil = new JsonTalkUtil();
			String json_date = jsonTalkUtil.createListTalkRepalyJson(list);
			HttpUtil.sendDateStream(json_date, response);
			
		}
	}

	public void init() throws ServletException {
	}

}
