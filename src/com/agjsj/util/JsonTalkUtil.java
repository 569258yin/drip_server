package com.agjsj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.agjsj.biz.UserBiz;
import com.agjsj.biz.UserBizImpl;
import com.agjsj.entity.Talk;
import com.agjsj.entity.Talkreplay;

public class JsonTalkUtil extends JsonAbstactDate {

	public Talk getTalkFromJson(JSONObject root_object) {

		Talk talk = new Talk();
		talk.setUserId(Integer.parseInt(root_object.getString("user_id")));
//		talk.setTalkId(Integer.parseInt(root_object.getString("user_id")));
		talk.setTalkNumzan(0);
		talk.setTalkNumza(0);
		talk.setTalkNumreply(0);
		talk.setTalkNumicon(1);
		talk.setTalkContext(root_object.getString("talkContext"));
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		talk.setTalkTime(DateUtil.getCurrentAllDate()+"");
		talk.setTalkIcon("");

		return talk;
	}

	public String createListTalkJson(List<Talk> list) {

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Talk talk = null;
			for (int i = 0; i < list.size(); i++) {
				talk = list.get(i);
				JSONObject jsonObject2 = getTalkToJsonObject(talk);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}
	}

	public JSONObject getTalkToJsonObject(Talk talk) {

		JSONObject jsonObject = new JSONObject();
		UserBiz user = new UserBizImpl();
		String[] str = user.getUserNameAndIcon(talk.getUserId());
		jsonObject.put("userName", str[0]);
		jsonObject.put("userIcon",str[1]);
 		jsonObject.put("user_id", talk.getUserId());
		jsonObject.put("talkId", talk.getTalkId());
		jsonObject.put("talkContext", talk.getTalkContext());
		jsonObject.put("talkTime", talk.getTalkTime());
		jsonObject.put("talkNumzan", talk.getTalkNumzan());
		jsonObject.put("talkNumza", talk.getTalkNumza());
		jsonObject.put("talkNumreply", talk.getTalkNumreply());
		jsonObject.put("talkNumicon", talk.getTalkNumicon());
		jsonObject.put("talkIcon", talk.getTalkIcon());
		
		return jsonObject;
	}
	
	@Override
	public String createListTalkRepalyJson(List<Talkreplay> list) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		if (list == null) {

			jsonObject.put("Tag", "0");
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();

		} else {
			jsonObject.put("Tag", "1");
			Talkreplay talkRepaly = null;
			for (int i = 0; i < list.size(); i++) {
				talkRepaly = list.get(i);
				JSONObject jsonObject2 = createTalkRepalyJson(talkRepaly);
				jsonArray.add(jsonObject2);
			}
			jsonObject.put("list", jsonArray);
			return jsonObject.toString();
		}
	}
	
	@Override
	public JSONObject createTalkRepalyJson(Talkreplay talkReplay) {
		JSONObject jsonObject = new JSONObject();
		UserBiz user = new UserBizImpl();
		String[] str = user.getUserNameAndIcon(talkReplay.getUserId());
		jsonObject.put("userName", str[0]+"");
		jsonObject.put("userIcon",str[1]+"");
 		jsonObject.put("user_id", talkReplay.getUserId());
		jsonObject.put("talkId", talkReplay.getTalkId());
		jsonObject.put("talkreplayId", talkReplay.getTalkreplayId());
		jsonObject.put("talkreplayContext", talkReplay.getTalkreplayContext());
		jsonObject.put("talkreplayTime", talkReplay.getTalkreplayTime());
		return jsonObject;
	}
	
	

	public Talkreplay getTalkReplayFromJson(JSONObject root_object) {

		Talkreplay talkreplay = new Talkreplay();
		talkreplay.setTalkId(root_object.getInt("talkId"));
		talkreplay.setUserId(root_object.getInt("user_id"));
		
		talkreplay.setTalkreplayContext(root_object
				.getString("talkreplayContext"));
		talkreplay.setTalkreplayTime(DateUtil.getCurrentDate());
		return talkreplay;
	}

}
