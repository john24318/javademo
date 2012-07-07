package com.wangyao.dp.behavioral.state;

public class LargeState implements State {

    public void handle(FireSwitch sw) {
        sw.setState(new OffState());
        System.out.println("off fire");
    }

}
