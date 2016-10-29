package com.agjsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.agjsj.biz.SearchBiz;
import com.agjsj.biz.SearchBizImpl;
import com.agjsj.entity.Holiday;
import com.agjsj.entity.Job;
import com.agjsj.entity.Train;
import com.agjsj.util.HttpUtil;

public class SerachServlet extends HttpServlet {

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
		String json_str = HttpUtil.getDateStream(request);				//获取二进制流对象
		JSONObject root_object = JSONObject.fromObject(json_str);		//获取全部json数据
		
		String str = root_object.getString("str");
		SearchBiz searchBiz = new SearchBizImpl();
		List<Job> jobList =	searchBiz.serchJob(str);
		List<Holiday> holidayList = searchBiz.serchHoliday(str);
		List<Train> trainList = searchBiz.searchTrain(str);
		String json_date = JsonSearchUtil.getListAllSearch(jobList, holidayList, trainList);
		HttpUtil.sendDateStream(json_date, response);
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
