package com.wangyao.base.web.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wangyao.base.util.Constants;

/**
 * 登录检测类
 * 
 * @author 王耀
 * 
 */
public class CheckLoginFilter implements Filter {

    private static Log log = LogFactory.getLog(CheckLoginFilter.class);
    private String[] exceptURLs;// 不需要过滤的URL列表
    private String loginURL = "login.jsp";// 检测失败后，转向的地址

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            throw new ServletException("CheckLoginFilter just supports HTTP requests");
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath() + "/";
        Object user = session.getAttribute(Constants.SESSION_USER);

        // 根路径不需要检查，避免死循环
        if (uri.equals(contextPath)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 登录URL不需要检查
        if (uri.equals(contextPath + loginURL)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 如果有例外的url，且当前url符合条件，则跳过检查
        if (null != exceptURLs && exceptURLs.length > 0) {
            for (int i = 0; i < exceptURLs.length; i++) {
                if (uri.equals(contextPath + exceptURLs[i].trim())) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }
        }

        // 若未登录，则转到未登录页面
        if (null == user) {
            resp.sendRedirect(contextPath + loginURL);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        String except = config.getInitParameter("except");
        if (null != except && except.length() > 0) {
            exceptURLs = except.split(",");
        }
        log.debug("exceptURLs " + Arrays.toString(exceptURLs));

        String login = config.getInitParameter("login");
        if (null != login && login.length() > 0) {
            loginURL = login;
        }
        log.debug("loginURL " + loginURL);
    }

}
