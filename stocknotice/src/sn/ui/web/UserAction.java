package sn.ui.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.base.util.Constants;
import sn.base.web.servlet.BaseServlet;
import sn.core.persistence.model.SnUser;
import sn.core.service.EmailService;
import sn.core.service.impl.EmailServiceImpl;
import sn.ui.service.UserService;
import sn.ui.service.impl.UserServiceImpl;

public class UserAction extends BaseServlet {

	private static final long serialVersionUID = -5780532996353251162L;

	private UserService userService = new UserServiceImpl();

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http://127.0.0.1:8080/stocknotice/user/reginit?a=b#t
		// req.getRequestURI() /stocknotice/user/reginit
		// req.getRequestURL() http://127.0.0.1:8080/stocknotice/user/reginit
		// req.getQueryString() a=b
		// req.getScheme() http
		// req.getServerName() 127.0.0.1
		// req.getServerPort() 8080
		// req.getContextPath() /stocknotice
		// req.getServletPath() /user
		// req.getPathInfo() /reginit
		String method = (null == req.getPathInfo()) ? null : req.getPathInfo().substring(1);

		if ("reginit".equalsIgnoreCase(method)) {
			regInit(req, resp);
		} else if ("checkName".equalsIgnoreCase(method)) {
			checkName(req, resp);
		} else if ("register".equalsIgnoreCase(method)) {
			register(req, resp);
		} else if ("activate".equalsIgnoreCase(method)) {
			activate(req, resp);
		} else if ("edit".equalsIgnoreCase(method)) {
			edit(req, resp);
		} else if ("save".equalsIgnoreCase(method)) {
			save(req, resp);
		} else if ("login".equalsIgnoreCase(method)) {
			login(req, resp);
		} else if ("logout".equalsIgnoreCase(method)) {
			logout(req, resp);
		} else if ("forgot".equalsIgnoreCase(method)) {
			forgot(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	/**
	 * 注册页面
	 */
	private void regInit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("tab", 1);
		forward("/pages/user/login.jsp", req, resp);
	}

	/**
	 * 检查用户名是否可用
	 */
	private void checkName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("login").trim();
		PrintWriter out = resp.getWriter();
		boolean isExist = userService.checkName(name);

		if (isExist) {
			out.print("disable");
		} else {
			out.print("enable");
		}
		out.flush();
	}

	/**
	 * 注册
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SnUser user = new SnUser();
		user.setLogin(req.getParameter("login").trim());
		user.setPassword(req.getParameter("password").trim());
		user.setEmail(req.getParameter("email".trim()));
		user.setMobilePhoneNumber((null == req.getParameter("mobilePhoneNumber")) ? "" : req.getParameter(
				"mobilePhoneNumber").trim());

		boolean result = userService.add(user);// 保存用户信息

		// 发送激活邮件
		if (result) {
			user = userService.get(user.getLogin());
			String contextPath = "http://" + req.getServerName()
					+ (80 == req.getServerPort() ? "" : ":" + req.getServerPort()) + req.getContextPath()
					+ req.getServletPath() + "/activate?u=" + user.getUserId() + "&ac=" + user.getActiveCode();
			String activeURL = "<a href=\"" + contextPath + "\">" + contextPath + "</a>";
			EmailService emailService = new EmailServiceImpl();
			emailService.sendHtmlEmail(user.getEmail(), user.getLogin(), "用户激活", "<html>" + user.getLogin()
					+ "，你好！<br/>这是一封来自股价通知器的注册确认信，请点击下面的链接地址，激活账号完成注册：<br />" + activeURL
					+ "<br/>(如果你无法点击此链接，请将上面的链接地址复制到你的浏览器地址栏中，打开页面即可)</html>");
		}

		// 结果
		if (result) {
			// 注册成功，重定向到登录页面
			redirect("/user/login", resp);
		} else {
			// 注册失败，返回到注册页面
			req.setAttribute("msg", "注册失败，请检查注册参数");
			req.setAttribute("tab", 1);
			forward("/pages/user/login.jsp", req, resp);
		}
	}

	/**
	 * 激活
	 */
	private void activate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer userId = Integer.parseInt(req.getParameter("u").trim());
		String activeCode = req.getParameter("ac").trim();
		boolean result = userService.activate(userId, activeCode);

		if (result) {
			// 激活成功，重定向到登录页面
			redirect("/user/login", resp);
		} else {
			resp.setContentType("text/html; charset=utf-8");
			resp.getWriter().print("激活失败！");
		}
	}

	/**
	 * 登录
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");

		if (null != login && null != password) {
			SnUser user = userService.login(login, password);// 验证用户信息

			// 登录成功
			if (null != user) {
				req.getSession().setAttribute(Constants.SESSION_USER, user);

				if ("on".equals(remember)) {
					Cookie cLogin = new Cookie("login", login);
					cLogin.setMaxAge(Constants.COOKIE_MAX_AGE);
					Cookie cPassword = new Cookie("password", password);
					cPassword.setMaxAge(Constants.COOKIE_MAX_AGE);
					resp.addCookie(cLogin);
					resp.addCookie(cPassword);
				}
				redirect("/stocks", resp); // 转入主菜单
				return;
			} else {
				req.setAttribute("msg", "登录失败！");
			}
		}

		req.setAttribute("tab", 0);
		forward("/pages/user/login.jsp", req, resp);// 转到登录界面

	}

	/**
	 * 编辑
	 */
	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	/**
	 * 保存
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	/**
	 * 注销
	 */
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 清空会话
		req.getSession().removeAttribute(Constants.SESSION_USER);
		// 清空Cookie
		Cookie cLogin = new Cookie("login", "");
		cLogin.setMaxAge(0);
		Cookie cPassword = new Cookie("password", "");
		cPassword.setMaxAge(0);
		resp.addCookie(cLogin);
		resp.addCookie(cPassword);
		redirect("/user/login", resp);// 转到登录界面
	}

	/**
	 * 忘记密码
	 */
	private void forgot(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
