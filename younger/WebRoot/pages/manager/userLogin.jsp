<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/pages/common/meta.jsp"%>
		<title>管理员登录</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="styles/base.css" />
		<script src="scripts/jquery/jquery.js" type="text/javascript"></script>
		<script src="scripts/jquery-validate/jquery.validate.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#userLogin").focus();
			
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
						$(".error").html(error);
					}
				});
			});
		</script>
	</head>

	<body>
		<div id="container">
			<%@ include file="/pages/common/header.jsp"%>
			<div id="center">
				<fieldset id="">
					<legend align="center">
						用户登录
					</legend>
					<form id="loginForm" name="loginForm" action="manager/user.do?method=login" method="post">
						<ul>
							<li class="error" style="padding: 0; text-align: left;">
								${msg }
							</li>
							<li>
								<label for="userLogin">
									用户名：
								</label>
								<input id="userLogin" name="userLogin" value="${param.userLogin }" type="text" style="width: 150px;" />
							</li>
							<li>
								<label for="userPass">
									密&nbsp;&nbsp;码：
								</label>
								<input id="userPass" name="userPass" type="password" style="width: 150px;" />
							</li>
							<li>
								<input id="submit" name="submit" value=" 登 录 " type="submit" />
							</li>
							<li></li>
						</ul>
					</form>
				</fieldset>
			</div>
			<%@ include file="/pages/common/footer.jsp"%>
		</div>
	</body>
</html>
