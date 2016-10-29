package com.agjsj.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.agjsj.biz.UuidBiz;
import com.agjsj.biz.UuidBizImpl;

public class MyServiceListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("销毁了");
		UuidBiz uuidBiz = new UuidBizImpl();
		uuidBiz.saveUUid();
		Application.service.shutdown();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("初始化");
		UuidBiz uuidBiz = new UuidBizImpl();
		uuidBiz.getUuid();
	}

}
