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
<title>Frame Bottom</title>
<style type="text/css">
body {
	margin: 0;
}

img {
	vertical-align: inherit;
	border: 0;
}

a:link, a:hover, a:visited {
	color: #A9DCFF text-decoration=none;
}

#StatusBar {
	background-color: #4386B7;
	border-top: 1px solid #FFFFFF;
	height: 20px;
	width: 100%
}
#StatusBar #StatusBar_Links{
	color: #A9DCFF;
	float: left;
	font-family: "宋体";
	font-size: 12px;
	padding-left: 20px;
	padding-top: 3px;
}
#StatusBar #StatusBar_Right{
	color: #A9DCFF;
	float: right;
	font-family: "宋体";
	font-size: 12px;
	padding-right: 30px;
	padding-top: 4px;
}

</style>
</head>

<body>
	<div id="StatusBar">
		<!-- 链接 -->
		<div id="StatusBar_Links"></div>
		<div id="StatusBar_Right">
			<!-- 版本 -->
			<a href=""> <img border="0" width="11" height="11"
				src="${pageContext.request.contextPath }/drip/style/images/info.gif" />
				<img border="0" width="40" height="11"
				src="${pageContext.request.contextPath }/drip/style/images/version.gif" />
			</a>
		</div>
	</div>
</body>
</html>

