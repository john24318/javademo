<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户登录</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link type="text/css" href="../../../css/jquery-ui/cupertino/jquery-ui.css" rel="stylesheet" />
		<script type="text/javascript" src="../../../js/jquery.js"></script>
		<script type="text/javascript" src="../../../js/jquery-ui.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#tabs").tabs();
			});
		</script>
	</head>

	<body>
		<div id="tabs">
			<ul>
				<li>
					<a href="#login">登录</a>
				</li>

				<li>
					<a href="#register">注册</a>
				</li>
			</ul>
			<div id="login">
				<form action="../../user/login">
					<label>
						用户名
					</label>
					<input name="login" type="text" tabindex="1" />
					<br />
					<label>
						密&nbsp;&nbsp;&nbsp;&nbsp;码
					</label>
					<input name="password" type="password" tabindex="2" />
					<br />
					<a href="../../user/forgot">忘记密码？</a>
					<input name="remember" type="checkbox" />
					记住密码
					<br />
					<input type="submit" value="登录" />
				</form>
			</div>
			<div id="register">
				<form action="../../user/register">
					<label>
						用户名
					</label>
					<input name="login" type="text" />
					<br />
					<label>
						电子邮箱
					</label>
					<input name="email" type="text" />
					<br />
					<label>
						密码
					</label>
					<input name="password" type="password" />
					<br />
					<label>
						确认密码
					</label>
					<input name="password" type="password" />
					<br />
					<input type="submit" value="创建帐号" />
				</form>
			</div>
		</div>
	</body>
</html>
