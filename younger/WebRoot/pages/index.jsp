<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/pages/common/meta.jsp"%>
		<title>青少年个人发展报告</title>
		<link rel="stylesheet" href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css" type="text/css">
		<link rel="stylesheet" href="http://yui.yahooapis.com/2.7.0/build/base/base-min.css" type="text/css">
		<script src="scripts/jquery/jquery.js" type="text/javascript"></script>
		<script src="scripts/jquery-validate/jquery.validate.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#no").focus();
			
				$("#reportForm").validate({
				  	rules: {
						no:{required:true}
					},
					messages: {
						no: "请输入唯一编号"
					},
					errorPlacement: function(error, element) {
						$("#msg").html(error);
					}
				});
				
				$("#loginForm").validate({
				  	rules: {
						userLogin:{required:true},
						userPass:{required:true}
					},
					messages: {
						userLogin: "请输入用户名和密码",
						userPass: "请输入用户名和密码"
					},
					errorPlacement: function(error, element) {
						//element.html(error);
					}
				});
			});
		</script>
	</head>
	<body>
		<div id="doc2" class="yui-t7">
			<div id="hd" role="banner" style="height: 80px;">
				<h1>
					青少年个人发展报告
				</h1>
			</div>
			<div id="bd" role="main" style="height: 400px;">
				<div class="yui-ge">
					<div class="yui-u first">
						<br />
						<br />
						<br />
						<div style="text-align: center;">
							<div id="msg" style="color: red;">
								&nbsp;
							</div>
							<form id="reportForm" name="reportForm" action="customer/report.do?method=view" method="post">
								<label>
									唯一编号：
								</label>
								<input id="no" name="no" value="${param.no }" type="text" style="width: 150px;" />
								<input id="submit" name="submit" value=" 提 交 " type="submit" />
							</form>
						</div>
					</div>
					<div class="yui-u" style="border: 1px solid green; padding: 5px;">
						<form id="loginForm" name="loginForm" action="manager/user.do?method=login" method="post">
							<label for="userLogin">
								用户名：
							</label>
							<input id="userLogin" name="userLogin" value="${param.userLogin }" type="text" style="width: 120px;" />
							<br />
							<label for="userPass">
								密&nbsp;&nbsp;&nbsp;码：
							</label>
							<input id="userPass" name="userPass" type="password" style="width: 120px; margin-top: 10px;" />
							<br />
							<input id="submit" name="submit" value=" 登 录 " type="submit" style="margin-top: 10px;" />
						</form>
					</div>
				</div>
			</div>
			<div id="ft" role="contentinfo" style="text-align: center; height: 40px; vertical-align: middle;">
				<p>
					深圳市远见管理咨询有限公司 版权所有
				</p>
			</div>
		</div>
	</body>
</html>
