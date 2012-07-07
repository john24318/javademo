package com.wangyao.dp.behavioral.state;

public class OffState implements State {

    public void handle(FireSwitch sw) {
        sw.setState(new SmallState());
        System.out.println("small fire");
    }

}
