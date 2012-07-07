<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/pages/common/meta.jsp"%>
		<title>页面重定向提示</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="styles/base.css" />
	</head>

	<body>
		<table style="width: 100%; height: 200px;">
			<tr>
				<td style="height: 50px;">
				</td>
			</tr>
			<tr>
				<td style="height: 50px; font-weight: bold; color: green;">
					重定向提示
				</td>
			</tr>
			<tr>
				<td style="vertical-align: middle; height: 50px; color: blue;">
					您请求的页面不存在，5秒后将自动转入主页。
				</td>
			</tr>
		</table>
	</body>
</html>
