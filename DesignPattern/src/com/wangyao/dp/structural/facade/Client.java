package com.wangyao.dp.structural.facade;

/**
 * Client
 * 
 * @author wangyao
 * 
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Computer facade = new Computer(new CPU(), new Memory(), new HardDrive());
        facade.startComputer();
    }

}
