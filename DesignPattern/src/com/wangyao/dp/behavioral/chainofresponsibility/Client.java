package com.wangyao.dp.behavioral.chainofresponsibility;

import java.io.IOException;

public class Client {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Handler numberHandler = new NumberHandler();
        Handler characterHandler = new CharacterHandler();
        Handler symbolHandler = new SymbolHandler();

        numberHandler.setSuccessor(characterHandler);
        characterHandler.setSuccessor(symbolHandler);

        System.out.print("Press any key then return: ");
        char c = (char) System.in.read();
        numberHandler.handleRequest(c);
    }

}
