<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>OpenFlashChartDemo</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<a href="chart.html">chart.html</a>
		<br />
		<a href="chart.html?ofc=data.json">chart.html?ofc=data.json</a>
		<br />
		<a href="chart2.html">chart2.html</a>
		<br />
		<a href="chart2.html?ofc=data.json">chart.html2?ofc=data.json</a>
		<br />
		<a href="chart3.html">chart3.html</a>
		<br />
		<a href="chart4.html">chart4.html</a>
		<br />
		<a href="chart5.html">chart5.html</a>
		<br />
		<a href="chart6.html">chart6.html</a>
		<br />
	</body>
</html>
