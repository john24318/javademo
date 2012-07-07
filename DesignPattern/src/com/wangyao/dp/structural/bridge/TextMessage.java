package com.wangyao.dp.structural.bridge;

public class TextMessage extends Message {

    public TextMessage(MessageLogger logger) {
        super();
        this.logger = logger;
    }

    public void log(String msg) {
        String str = preProcess(msg);
        logger.logMsg(str);
    }

    private String preProcess(String msg) {
        return msg;
    };
}
