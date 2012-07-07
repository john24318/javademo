package com.wangyao.dp.structural.bridge;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Create an appropriate implementer object
        MessageLogger logger = new ConsoleLogger();
        // Choose required interface object and
        // configure it with the implementer object
        Message msg = new EncryptedMessage(logger);
        msg.log("Test Message");
    }

}
