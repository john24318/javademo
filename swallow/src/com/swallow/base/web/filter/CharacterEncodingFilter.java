package com.swallow.base.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 字符编码设置过滤器
 * 
 * @author wangyao
 * 
 */
public class CharacterEncodingFilter implements Filter {

    private String encoding; // 字符编码类型

    private boolean forceEncoding = false; // 是否强制编码

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (encoding != null && (forceEncoding || request.getCharacterEncoding() == null)) {
            request.setCharacterEncoding(encoding);

            if (this.forceEncoding) {
                response.setCharacterEncoding(encoding);
            }
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");

        if (filterConfig.getInitParameter("forceEncoding").equalsIgnoreCase("true")) {
            forceEncoding = true;
        }
    }

}
