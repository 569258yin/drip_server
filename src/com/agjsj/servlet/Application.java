package com.agjsj.servlet;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.agjsj.entity.Validata;

public class Application {
	public static ScheduledExecutorService service;
	/**
	 * 定时清理任务
	 */
	static{
		Runnable runnable = new Runnable() {
			@SuppressWarnings("rawtypes")
			public void run() {
				Set set = Application.validateMap.keySet();
				for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
					String key = (String) iterator2.next();
					Validata validata =  (Validata) Application.validateMap.get(key);
					if (validata.getTime() > new Date().getTime()) {
						Application.validateMap.remove(key);
					}
				}
				System.out.println("清除了验证码");
			}
		};
		service = Executors
				.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, 2, 5, TimeUnit.MINUTES);
	}

	public static String path = "/DripServlet/www/image/drip";


	public static Map<String, String> userMap = new HashMap<String, String>();

	public static Map<String, Validata> validateMap = new HashMap<String, Validata>(); 
}
