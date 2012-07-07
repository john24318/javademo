package com.wangyao.dp.behavioral.state;

public class MediumState implements State {

    public void handle(FireSwitch sw) {
        sw.setState(new LargeState());
        System.out.println("large fire");
    }

}
