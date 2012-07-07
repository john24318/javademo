package com.wangyao.dp.structural.flyweight;

public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        super();
        this.intrinsicState = intrinsicState;
        System.out.println("Create ConcreteFlyweight intrinsicState=" + this.intrinsicState);
    }

    public void operation(String extrinsicState) {
        this.intrinsicState = extrinsicState;
        System.out.println("ConcreteFlyweight operation:" + intrinsicState);
    }

}
