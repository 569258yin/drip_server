<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>无线点餐后台管理</title>
</head>
<frameset rows="100px,*,19px" framespacing="0" border="0"
	frameborder="0">
	<frame src="${pageContext.request.contextPath }/drip/public/top.jsp"
		scrolling="no" noresize />
	<frameset cols="178px,*">
		<frame noresize
			src="${pageContext.request.contextPath }/drip/public/left.jsp"
			scrolling="yes" />
		<frame noresize name="right"
			src="${pageContext.request.contextPath }/drip/public/right.jsp"
			scrolling="yes" />
	</frameset>
	<frame noresize name="status_bar" scrolling="no"
		src="${pageContext.request.contextPath }/drip/public/bottom.jsp" />
</frameset>
<noframes>
	<body>
		你的浏览器不支持框架布局，推荐你使用
		<a href="http://www.firefox.com.cn/download/"
			style="text-decoration: none;">火狐浏览器</a>,
		<a href="http://www.google.cn/intl/zh-CN/chrome/"
			style="text-decoration: none;">谷歌浏览器</a>
	</body>
</noframes>
</html>