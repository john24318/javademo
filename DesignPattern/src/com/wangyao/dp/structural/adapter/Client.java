package com.wangyao.dp.structural.adapter;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }

}
