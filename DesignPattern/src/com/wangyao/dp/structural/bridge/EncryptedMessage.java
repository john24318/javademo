package com.wangyao.dp.structural.bridge;

public class EncryptedMessage extends Message {

    public EncryptedMessage(MessageLogger logger) {
        super();
        this.logger = logger;
    }

    public void log(String msg) {
        String str = preProcess(msg);
        logger.logMsg(str);
    }

    private String preProcess(String msg) {
        return "EncryptedMessage:" + msg;
    };

}
