package com.wangyao.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;

public class HelloWorld {
    private int requestCount = 0;

    public String hello(String name) {
        requestCount++;
        System.out.println("requestCount=" + requestCount);
        System.out.println("Received: " + name);

        MessageContext context = MessageContext.getCurrentContext();
        HttpServletRequest req = (HttpServletRequest) context.getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
        System.out.println("Request IP:" + req.getRemoteAddr() + " " + req.getRemoteHost());

        return "Hello " + name;
    }

    public Float add(Float a, float b) {
        requestCount++;
        String result = "a=" + a + ", b=" + b;
        System.out.println("requestCount=" + requestCount);
        System.out.println("Received: " + result);
        return a + b;
    }

    public List<String> list() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        return list;

    }
}
