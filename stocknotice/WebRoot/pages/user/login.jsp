<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<base href="${ctx }" />
		<title>用户登录</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet"
			href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css"
			type="text/css">
		<link type="text/css" href="css/jquery-ui/cupertino/jquery-ui.css"
			rel="stylesheet" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#tabs").tabs().tabs('select', ${tab});

				<c:if test="${null!=msg}">
					alert("${msg}");
				</c:if>
			});
		</script>
	</head>

	<body>
		<div id="doc3" class="yui-t7">
			<div id="hd" style="height: 80px;">
				<h1>
					Header
				</h1>
			</div>

			<div id="bd">
				<div class="yui-gb">
					<div class="yui-u first">
						&nbsp;
					</div>

					<div class="yui-u">
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
								<form action="user/login" method="post">
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
									<a href="user/forgot">忘记密码？</a>
									<input name="remember" type="checkbox" />
									记住密码
									<br />
									<input type="submit" value="登录" />
								</form>
							</div>
							<div id="register">
								<form action="user/register" method="post">
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
					</div>

					<div class="yui-u">
						&nbsp;
					</div>
				</div>
			</div>

			<div id="ft">
				<p>
					Footer
				</p>
			</div>
		</div>
	</body>
</html>