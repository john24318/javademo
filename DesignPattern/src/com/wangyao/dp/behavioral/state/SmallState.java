package com.wangyao.dp.behavioral.state;

public class SmallState implements State {

    public void handle(FireSwitch sw) {
        sw.setState(new MediumState());
        System.out.println("medium fire");
    }

}
