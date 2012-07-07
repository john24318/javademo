<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>错误提示</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="错误提示">
	</head>

	<body>
		<h1 align="center">
			错误提示
		</h1>
		<hr />
		<p>
			错误产生：
			<I><%=exception%></I>
		</p>

		<p>
			问题如下：
			<br />
			<%
			    exception.printStackTrace(new PrintWriter(out));
			%>
		</p>
	</body>
</html>
