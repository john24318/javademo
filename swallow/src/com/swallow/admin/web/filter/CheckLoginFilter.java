package com.swallow.admin.web.filter;

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

import com.swallow.base.util.Constants;

public class CheckLoginFilter implements Filter {
    private static final Log log = LogFactory.getLog(CheckLoginFilter.class);
    private String[] exceptUrls;// 不需要过滤的URL列表
    private String loginUrl = "index.jsp";// 检测失败后，转向的地址

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            throw new ServletException("CheckLoginFilter支持HTTP请求");
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath() + "/";
        Object user = session.getAttribute(Constants.SESSION_USER);

        // 用户已登录、根路径、登录URL都转入下一个Filter继续处理
        if (null != user || uri.equals(contextPath) || uri.equals(contextPath + loginUrl)) {
            chain.doFilter(request, response);
            return;
        }

        // 如果有例外的url，且当前URL符合条件，则转入下一个Filter继续处理
        if (null != exceptUrls && exceptUrls.length > 0) {
            for (int i = 0; i < exceptUrls.length; i++) {
                if (uri.equals(contextPath + exceptUrls[i])) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }

        resp.sendRedirect(contextPath + loginUrl);
    }

    public void init(FilterConfig config) throws ServletException {
        String exceptUrls = config.getInitParameter("exceptUrls");
        if (null != exceptUrls && exceptUrls.length() > 0) {
            this.exceptUrls = exceptUrls.split(",");

            for (int i = 0; i < this.exceptUrls.length; i++) {
                this.exceptUrls[i] = this.exceptUrls[i].trim();
            }
        }
        log.debug("exceptURLs " + Arrays.toString(this.exceptUrls));

        String loginUrl = config.getInitParameter("loginUrl");
        if (null != loginUrl && loginUrl.length() > 0) {
            this.loginUrl = loginUrl.trim();
        }
        log.debug("loginURL " + this.loginUrl);
    }

}
