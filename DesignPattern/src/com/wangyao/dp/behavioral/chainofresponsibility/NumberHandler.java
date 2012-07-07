package com.wangyao.dp.behavioral.chainofresponsibility;

public class NumberHandler extends Handler {
    public void handleRequest(char c) {
        if (Character.isDigit(c)) {
            System.out.println("Number has been handled");
        } else {
            getSuccessor().handleRequest(c);
        }
    }
}
