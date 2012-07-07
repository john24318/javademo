package com.wangyao.dp.behavioral.chainofresponsibility;

public class CharacterHandler extends Handler {
    public void handleRequest(char c) {
        if (Character.isLetter(c)) {
            System.out.println("Character has been handled");
        } else {
            getSuccessor().handleRequest(c);
        }
    }
}
