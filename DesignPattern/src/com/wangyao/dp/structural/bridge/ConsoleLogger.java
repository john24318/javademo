package com.wangyao.dp.structural.bridge;

public class ConsoleLogger implements MessageLogger {

    public void logMsg(String msg) {
        System.out.println(msg);
    }

}
