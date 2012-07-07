package com.wangyao.dp.structural.flyweight;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        factory.getFlyweight("A");
        factory.getFlyweight("B");
        factory.getFlyweight("C");
        factory.getFlyweight("A");
        factory.getFlyweight("A");
    }

}
