<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.DateFormat"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    Calendar cale = Calendar.getInstance();
    TimeZone timeZone = cale.getTimeZone();
    int hour = timeZone.getRawOffset() / 3600000;
    int minute = (timeZone.getRawOffset() / 60000) % 60;
    Date date = cale.getTime();
    DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>时间测试</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv=content-type content="text/html; charset=UTF-8">
	</head>

	<body>
		<h2>
			时间测试
		</h2>

		<div align="center">
			<br>
			时区：<%=timeZone.getDisplayName() + "(" + hour + ":" + minute + ")"%>
			<br>
			当前时间：<%=df.format(date)%>
			<br>
			<%
			    df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			%>
			北京时间：<%=df.format(date)%>
		</div>
	</body>
</html>
