package com.wangyao.dp.structural.flyweight;

public class UnsharedConcreteFlyweight implements Flyweight {

    public void operation(String extrinsicState) {
        System.out.println("UnsharedConcreteFlyweight operation:" + extrinsicState);
    }

}
